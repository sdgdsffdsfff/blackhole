package com.dp.blackhole.supervisor;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.dianping.lion.EnvZooKeeperConfig;
import com.dianping.lion.client.ConfigCache;
import com.dianping.lion.client.ConfigChange;
import com.dianping.lion.client.LionException;
import com.dp.blackhole.common.ParamsKey;
import com.dp.blackhole.common.Util;
import com.dp.blackhole.http.HttpClientSingle;
import com.dp.blackhole.supervisor.model.Blacklist;
import com.dp.blackhole.supervisor.model.LogNotFoundEntity;
import com.dp.blackhole.supervisor.model.Stream.StreamId;
import com.dp.blackhole.supervisor.model.TopicConfig;

public class ConfigManager {
    private static final Log LOG = LogFactory.getLog(ConfigManager.class);

    private final ConcurrentHashMap<String, Set<String>> hostToTopics = new ConcurrentHashMap<String, Set<String>>();
    private final Map<String, Set<String>> cmdbAppToTopics = new ConcurrentHashMap<String, Set<String>>();
    // key is a topic name which is just maintained in configurations but may not be using.
    private final Map<String, TopicConfig> confMap = new ConcurrentHashMap<String, TopicConfig>();
    private final Set<String> newTopicToBroadcast = new CopyOnWriteArraySet<String>();
    private Map<StreamId, String> brokerPreassignment = new HashMap<StreamId, String>();
    private ConcurrentHashMap<LogNotFoundEntity, String> logNotFounds;// entity -> source
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private Lock rLock = rwLock.readLock();
    private Lock wLock = rwLock.writeLock();
    private final ConfigCache cache;
    private final Supervisor supervisor;
    private final Blacklist blacklist;

    private HttpClientSingle httpClient;
    
    public int webServicePort;
    public int connectionTimeout;
    public int socketTimeout;
    
    public int supervisorPort;
    public int jettyPort;
    public int numHandler;
    
    public volatile boolean brokerAssignmentLimitEnable;
    public volatile int brokerAssignmentLimitMin;
    
    public String checkpiontPath;
    public long checkpiontPeriod;
    
    public long abnormalStageCheckPeriod;
    public long abnormalStageDuration;
    public long normalStageTTL;
    
    public String getPaaSInstanceURLPerfix;
    
    public ConfigManager(Supervisor supervisor) throws LionException {
        this.cache = ConfigCache.getInstance(EnvZooKeeperConfig.getZKAddress());
        this.supervisor = supervisor;
        this.blacklist = new Blacklist();
        this.logNotFounds = new ConcurrentHashMap<LogNotFoundEntity, String>();
    }
    
    public Supervisor getSupervisor() {
        return this.supervisor;
    }
    
    public Blacklist getBlacklist() {
        return blacklist;
    }
    
    public Map<StreamId, String> getBrokerPreassignmentCopy() {
        rLock.lock();
        try {
            return new HashMap<StreamId, String>(brokerPreassignment);
        } finally {
            this.rLock.unlock();
        }
    }

    public String getBrokerPreassignmentByPartition(String topic, String partition) {
        StreamId streamId = new StreamId(topic, partition);
        rLock.lock();
        try {
            return brokerPreassignment.get(streamId);
        } finally {
            rLock.unlock();
        }
    }

    public void setBrokerPreassignment(Map<StreamId, String> brokerPreassignment) {
        wLock.lock();
        try {
            this.brokerPreassignment = brokerPreassignment;
        } finally {
            wLock.unlock();
        }
    }

    public HttpClientSingle getHttpClient() {
        return httpClient;
    }

    public Set<String> getTopicsByHost(String host) {
        return hostToTopics.get(host);
    }
    
    public Set<String> getTopicsByCmdb(String cmdbApp) {
        return cmdbAppToTopics.get(cmdbApp);
    }
    
    public Set<String> getAllCmdb() {
        return cmdbAppToTopics.keySet();
    }
    
    public Set<String> getAllTopicConfNames() {
        return confMap.keySet();
    }
    
    public TopicConfig getConfByTopic(String topic) {
        return confMap.get(topic);
    }
    
    public void addTopicToHost(String agentHost, String topic) {
        //fill host->topics map
        Set<String> tmp = new CopyOnWriteArraySet<String>();
        Set<String> topicsInOneHost = hostToTopics.putIfAbsent(agentHost, tmp);
        if (topicsInOneHost == null) {
            topicsInOneHost = tmp;
        }
        topicsInOneHost.add(topic);
    }
    
    public void initConfig() throws IOException {
        Properties prop = new Properties();
        prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        Util.setZkEnv(EnvZooKeeperConfig.getEnv());
        Util.setAuthorizationId(Integer.parseInt(prop.getProperty("supervisor.lionapi.id")));
        webServicePort = Integer.parseInt(prop.getProperty("supervisor.webservice.port"));
        connectionTimeout = Integer.parseInt(prop.getProperty("supervisor.webservice.connectionTimeout", "30000"));
        socketTimeout = Integer.parseInt(prop.getProperty("supervisor.webservice.socketTimeout", "10000"));
        
        supervisorPort = Integer.parseInt(prop.getProperty("supervisor.port"));
        jettyPort = Integer.parseInt(prop.getProperty("rest.jetty.port", "8085"));
        numHandler = Integer.parseInt(prop.getProperty("GenServer.handler.count", "3"));
        getPaaSInstanceURLPerfix = prop.getProperty("supervisor.paas.url");
        brokerAssignmentLimitEnable = Boolean.parseBoolean(prop.getProperty("supervisor.broker-assignment-limit.enable", "false"));
        
        checkpiontPath = prop.getProperty("supervisor.checkpoint.path", "/tmp/checkpoint");
        checkpiontPeriod = Long.parseLong(prop.getProperty("supervisor.checkpoint.period", "60000"));
        
        abnormalStageCheckPeriod = Long.parseLong(prop.getProperty("supervisor.abnormalStage.checkPeriod", "600000"));  //10 minutes
        abnormalStageDuration = Long.parseLong(prop.getProperty("supervisor.abnormalStage.duration", "1200000"));        //20 minutes
        normalStageTTL = Long.parseLong(prop.getProperty("supervisor.normalStage.ttl", "1800000"));                      //30 minutes
        
        //create a http client for PaaS
        httpClient = new HttpClientSingle(connectionTimeout, socketTimeout);
        reloadTopicConfig();
    }
    
    private void reloadTopicConfig() {
        reloadConf();
        addWatchers();
    }
    
    private void reloadConf() {
        String topicsString = definitelyGetProperty(ParamsKey.LionNode.TOPIC);
        String[] topics = Util.getStringListOfLionValue(topicsString);
        if (topics == null || topics.length == 0) {
            LOG.info("There are no legacy configurations.");
            return;
        }

        String blacklistString = definitelyGetProperty(ParamsKey.LionNode.BLACKLIST);
        loadBlacklist(blacklistString);

        String preassignString = definitelyGetProperty(ParamsKey.LionNode.PERASSIGNMENT);
        loadBrokerPerassignment(preassignString);

        String assignLimit = definitelyGetProperty(ParamsKey.LionNode.BROKER_ASSIGN_LIMIT_MIN);
        loadBrokerAssignLimit(assignLimit);
        
        for (int i = 0; i < topics.length; i++) {
            confMap.put(topics[i], new TopicConfig(topics[i]));
            String confString = definitelyGetProperty(ParamsKey.LionNode.CONF_PREFIX + topics[i]);
            fillConfMap(topics[i], confString);
            String hostsString = definitelyGetProperty(ParamsKey.LionNode.HOSTS_PREFIX + topics[i]);
            fillHostMap(topics[i], hostsString);
        }
    }

    private void addWatchers() {
        LionChangeListener listener = new LionChangeListener();
        cache.addChange(listener);
        definitelyGetProperty(ParamsKey.LionNode.TOPIC);
        definitelyGetProperty(ParamsKey.LionNode.BLACKLIST);
        definitelyGetProperty(ParamsKey.LionNode.BROKER_ASSIGN_LIMIT_MIN);
        definitelyGetProperty(ParamsKey.LionNode.PERASSIGNMENT);
    }

    private synchronized String definitelyGetProperty(String watchKey) {
        while (true) {
            try {
                String value = cache.getProperty(watchKey);
                LOG.info("add watcher for " + watchKey);
                return value;
            } catch (LionException e) {
                LOG.warn(e.getMessage(), e);
                LOG.info("reset watcher to " + watchKey + "after 3 sencond...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    LOG.error(e1.getMessage(), e1);
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private void fillConfMap(String topic, String confValue) {
        String[][] confKV = Util.getStringMapOfLionValue(confValue);
        if (confKV != null) {
            TopicConfig confInfo = confMap.get(topic);
            for (int i = 0; i < confKV.length; i++) {
                String key = confKV[i][0];
                String value = confKV[i][1];
                LOG.info("topic:" + topic + " K:" + key + " V:" + value);
                if (key.equalsIgnoreCase(ParamsKey.TopicConf.WATCH_FILE)) {
                    confInfo.setWatchLog(value);
                } else if (key.equalsIgnoreCase(ParamsKey.TopicConf.ROTATE_PERIOD)) {
                    confInfo.setRotatePeriod(Util.parseInt(value, 3600));
                } else if (key.equalsIgnoreCase(ParamsKey.TopicConf.ROLL_PERIOD)) {
                    confInfo.setRollPeriod(Util.parseInt(value, confInfo.getRotatePeriod()));
                } else if (key.equalsIgnoreCase(ParamsKey.TopicConf.MAX_LINE_SIZE)) {
                    confInfo.setMaxLineSize(Util.parseInt(value, 512000));
                } else if (key.equalsIgnoreCase(ParamsKey.TopicConf.PERSISTENT)) {
                    confInfo.setPersistent(Util.parseBoolean(value, true));
                } else if (key.equalsIgnoreCase(ParamsKey.TopicConf.READ_INTERVAL)) {
                    confInfo.setReadInterval(Util.parseLong(value, 1L));
                } else if (key.equalsIgnoreCase(ParamsKey.TopicConf.MINIMUM_MESSAGES_SENT)) {
                    confInfo.setMinMsgSent(Util.parseInt(value, 30));
                } else if (key.equalsIgnoreCase(ParamsKey.TopicConf.MESSAGE_BUFFER_SIZE)) {
                    confInfo.setMsgBufSize(Util.parseInt(value, 512000));
                } else if (key.equalsIgnoreCase(ParamsKey.TopicConf.BANDWIDTH_PER_SEC)) {
                    confInfo.setBandwidthPerSec(Util.parseInt(value, 0));
                } else if (key.equalsIgnoreCase(ParamsKey.TopicConf.APP)) {
                    internalFillingCmdbMap(topic, value);
                } else if (key.equalsIgnoreCase(ParamsKey.TopicConf.OWNER)) {
                    confInfo.setOwner(value);
                } else if (key.equalsIgnoreCase(ParamsKey.TopicConf.COMPRESSION)) {
                    confInfo.setCompression(value);
                } else if (key.equalsIgnoreCase(ParamsKey.TopicConf.PARTITION_FACTOR)) {
                    int factor = Util.parseInt(value, 1);
                    confInfo.setPartitionFactor(factor < 1 ? 1 : factor);
                } else if (key.equalsIgnoreCase(ParamsKey.TopicConf.TAIL_POSITION)) {
                    long tailPosition = Util.parseLong(value, -1);
                    confInfo.setTailPosition(tailPosition);
                } else {
                    LOG.error("Unrecognized conf string.");
                }
            }
        } else {
            LOG.error("Lose configurations for " + topic);
        }
    }
    
    public void updateInstancesOfNewTopic(TopicConfig confInfo) {
        String cmdbApp = confInfo.getAppName();
        String topic = confInfo.getTopic();
        if (cmdbApp == null) {
            LOG.error("Oops, no cmdb app assign to topic " + confInfo.getTopic());
            return;
        }
        //one topic has only one cmdbapp, but the interface of PAAS is cmdbapp list
        List<String> cmdbApps = new ArrayList<String>();
        cmdbApps.add(cmdbApp);
        try {
            Map<String, Set<String>> hostToInstances = findInstancesByCmdbApps(topic, cmdbApps);
            confInfo.setInstances(hostToInstances);
        } catch (Exception e) {
            LOG.error("Oops, can not find instances.", e);
        }
    }
    
    public Map<String, Set<String>> findInstancesByCmdbApps(String topic, List<String> cmdbApps)
            throws UnsupportedEncodingException, JSONException {
        if (cmdbApps.size() == 0) {
            return null;
        }
        //HTTP get the json
        StringBuilder catalogURLBuild = new StringBuilder();
        catalogURLBuild.append(getPaaSInstanceURLPerfix);
        for (String app : cmdbApps) {
            catalogURLBuild.append(app).append(",");
        }
        catalogURLBuild.deleteCharAt(catalogURLBuild.length() - 1);
        String response = httpClient.getResponseText(catalogURLBuild.toString());
        if (response == null) {
            LOG.error("response is null.");
            return null;
        }
        String jsonStr = java.net.URLDecoder.decode(response, "utf-8");
        JSONObject rootObject = new JSONObject(jsonStr);
        JSONArray catalogArray = rootObject.getJSONArray("catalog");
        if (catalogArray.length() == 0) {
            LOG.warn("Can not get any catalog by url " + catalogURLBuild.toString());
        }
        Map<String, Set<String>> hostToInstances = new HashMap<String, Set<String>>();
        for (int i = 0; i < catalogArray.length(); i++) {
            JSONObject layoutObject = catalogArray.getJSONObject(i);
            String app = (String)layoutObject.get("app");
            JSONArray layoutArray = layoutObject.getJSONArray("layout");
            if (layoutArray.length() == 0) {
                LOG.warn("Can not get any layout by app " + app);
            }
            for (int j = 0; j < layoutArray.length(); j++) {
                JSONObject hostIdObject = layoutArray.getJSONObject(j);
                String ip = (String) hostIdObject.get("ip");
                InetAddress host;
                try {
                    host = InetAddress.getByName(ip);
                } catch (UnknownHostException e) {
                    LOG.error("Receive a unknown host " + ip, e);
                    continue;
                }
                String agentHost = host.getHostName();
                addTopicToHost(agentHost, topic);
                
                Set<String> instances;
                if ((instances = hostToInstances.get(agentHost)) == null) {
                    instances = new HashSet<String>();
                    hostToInstances.put(agentHost, instances);
                }
                JSONArray idArray = hostIdObject.getJSONArray("id");
                if (idArray.length() == 0) {
                    LOG.warn("Can not get any instance by host " + agentHost);
                }
                for (int k = 0; k < idArray.length(); k++) {
                    LOG.debug("PaaS catalog app: " + app + ", ip: " + ip + ", id: " + idArray.getString(k));
                    instances.add(idArray.getString(k));
                }
            }
        }
        return hostToInstances;
    }

    private void fillHostMap(String topic, String hostsValue) {
        String[] hosts = Util.getStringListOfLionValue(hostsValue);
        if (hosts != null) {
            List<String> list = new CopyOnWriteArrayList<String>();
            for (int i = 0; i < hosts.length; i++) {
                String host = hosts[i].trim();
                if (host.length() != 0) {
                    list.add(host);
                    addTopicToHost(host, topic);
                }
            }
            TopicConfig confInfo = confMap.get(topic);
            confInfo.setHosts(list);
            //update instances if this topic also exists in PaaS
            updateInstancesOfNewTopic(confInfo);
            //broadcast confRes message for new topic
            broadcastNewTopicConfig(confInfo);
        } else {
            LOG.warn("Lose hosts for " + topic);
        }
        
    }

    public void internalFillingCmdbMap(String topic, String cmdbApp) {
        if (cmdbApp != null && cmdbApp.length() != 0) {
            Set<String> topicsInOneCMDB;
            if ((topicsInOneCMDB = cmdbAppToTopics.get(cmdbApp)) == null) {
                topicsInOneCMDB = new CopyOnWriteArraySet<String>();
                cmdbAppToTopics.put(cmdbApp, topicsInOneCMDB);
            }
            topicsInOneCMDB.add(topic);
            TopicConfig confInfo = confMap.get(topic);
            confInfo.setAppName(cmdbApp);
        } else {
            LOG.error("Lose CMDB mapping for " + topic);
        }
    }
    
    public void updateLionList(String watchKey, String op, String[] updates) throws HttpException {
        //get list of old value of the watchkey
        String url = Util.generateGetURL(watchKey);
        String response = httpClient.getResponseText(url);
        if (response == null) {
            throw new HttpException("IO exception was thrown when handle url ." + url);
        } else if (response.startsWith("1|")) {
            throw new HttpException(response.substring(2));
        } else if (response.equals("<null>")) {
            throw new HttpException("No configration in lion for key=" + watchKey);
        }
        String[] oldArray = Util.getStringListOfLionValue(response);
        if (oldArray == null) {
            oldArray = new String[0];
        }
        Set<String> oldSet = new HashSet<String>(Arrays.asList(oldArray));
        Set<String> updateSet = new HashSet<String>(Arrays.asList(updates));
        if (op.equals(ParamsKey.LionNode.OP_SCALEOUT)) {
                oldSet.addAll(updateSet);
        } else if (op.equals(ParamsKey.LionNode.OP_SCALEIN)) {
                oldSet.removeAll(updateSet);
        } else {
            throw new HttpException("Just suppert \"+\" and \"-\" operation.");
        }
        String[] newArray = oldSet.toArray(new String[oldSet.size()]);
        String newHostsLionString = Util.getLionValueOfStringList(newArray);
        url = Util.generateSetURL(watchKey, newHostsLionString);
        response = httpClient.getResponseText(url);
        if (response == null) {
            throw new HttpException("IO exception was thrown when handle url ." + url);
        } else if (response.startsWith("1|")) {
            throw new HttpException("No configration in lion for key=" + watchKey);
        } else if (response.startsWith("0")) {
            return;
        } else {
            LOG.error("Unkown response.");
            throw new HttpException("Unkown response.");
        }
    }

    public String dumpconf() {
        StringBuilder sb = new StringBuilder();
        sb.append("dumpconf:\n");
        sb.append("############################## dump ##############################\n");
        sb.append("print topic configurations in MEMORY\n");
        for (String topic : confMap.keySet()) {
            sb.append("TOPIC: [").append(topic).append("]\n");
            sb.append("HOSTS: \n");
            TopicConfig confInfo = confMap.get(topic);
            if (confInfo == null) {
                continue;
            }
            List<String> hosts =  confInfo.getHosts();
            if (hosts != null) {
                for (String host : hosts) {
                    sb.append(host)
                    .append(" ");
                }
            }
            sb.append("\n")
            .append("CONF:\n")
            .append(ParamsKey.TopicConf.WATCH_FILE)
            .append(" = ")
            .append(confInfo.getWatchLog())
            .append("\n")
            .append(ParamsKey.TopicConf.PERSISTENT)
            .append(" = ")
            .append(confInfo.isPersistent())
            .append("\n")
            .append(ParamsKey.TopicConf.ROTATE_PERIOD)
            .append(" = ")
            .append(confInfo.getRotatePeriod())
            .append("\n")
            .append(ParamsKey.TopicConf.ROLL_PERIOD)
            .append(" = ")
            .append(confInfo.getRollPeriod())
            .append("\n")
            .append(ParamsKey.TopicConf.MAX_LINE_SIZE)
            .append(" = ")
            .append(confInfo.getMaxLineSize())
            .append("\n")
            .append(ParamsKey.TopicConf.READ_INTERVAL)
            .append(" = ")
            .append(confInfo.getReadInterval())
            .append("\n")
            .append(ParamsKey.TopicConf.MINIMUM_MESSAGES_SENT)
            .append(" = ")
            .append(confInfo.getMinMsgSent())
            .append("\n")
            .append(ParamsKey.TopicConf.MESSAGE_BUFFER_SIZE)
            .append(" = ")
            .append(confInfo.getMsgBufSize())
            .append("\n")
            .append(ParamsKey.TopicConf.COMPRESSION)
            .append(" = ")
            .append(confInfo.getCompression())
            .append("\n")
            .append(ParamsKey.TopicConf.PARTITION_FACTOR)
            .append(" = ")
            .append(confInfo.getPartitionFactor())
            .append("\n")
            .append(ParamsKey.TopicConf.OWNER)
            .append(" = ")
            .append(confInfo.getOwner())
            .append("\n")
            .append(ParamsKey.TopicConf.APP)
            .append(" = ")
            .append(confInfo.getAppName())
            .append("\n");
        }
        sb.append("##################################################################");
        
        return sb.toString();
    }
    
    public void removeConf(String topic) {
        if (confMap.containsKey(topic)) {
            List<String> hostsOfOneTopic = confMap.get(topic).getHosts();
            confMap.remove(topic);
            if (hostsOfOneTopic != null) {
                for (String host : hostsOfOneTopic) {
                    Set<String> topicsInOneHost = hostToTopics.get(host);
                    if (topicsInOneHost.remove(topic)) {
                        LOG.info("remove "+ topic + " form hostToTopics for " + host);
                    } else {
                        LOG.warn(topic + " in topicsInOneHost had been removed before.");
                    }
                }
            }
        }
    }
    
    private void broadcastNewTopicConfig(TopicConfig confInfo) {
        if (confInfo.getWatchLog() == null || confInfo.getWatchLog().length() == 0) {
            LOG.error("Oops, no watchlog found for " + confInfo.getTopic());
            return;
        }
        if (newTopicToBroadcast.remove(confInfo.getTopic())) {
            //trigger confRes of topic deployed in KVM
            supervisor.findAndSendAppConfRes(confInfo);
            
            //trigger confRes of topic deployed in PAAS
            supervisor.findAndSendLxcConfRes(confInfo);
        }
    }
    
    private void loadBrokerPerassignment(String value) {
        try {
            Map<StreamId, String> preassignmentMap = new HashMap<StreamId, String>();
            JSONArray assignmentArray = new JSONArray(value);
            for (int i = 0; i < assignmentArray.length(); i++) {
                JSONObject assignmentObject = assignmentArray.getJSONObject(i);
                String topic = assignmentObject.getString(ParamsKey.TOPIC_KEY);
                String partition = assignmentObject.getString(ParamsKey.PARTITION_KEY);
                String broker = assignmentObject.getString(ParamsKey.BROKER_KEY);
                StreamId streamId = new StreamId(topic, partition);
                preassignmentMap.put(streamId, broker);
            }
            setBrokerPreassignment(preassignmentMap);
        } catch (JSONException e) {
            LOG.error("Invaild json string, skip replace", e);
        }
    }

    private void loadBlacklist(String value) {
        String[] blacklistArray = Util.getStringListOfLionValue(value);
        if (blacklistArray != null) {
            blacklist.setBlacklist(Arrays.asList(blacklistArray));
        }
    }

    private void loadBrokerAssignLimit(String value) {
        if (brokerAssignmentLimitEnable) {
            brokerAssignmentLimitMin = Util.parseInt(value, 1);
        }
    }
    
    public ConcurrentHashMap<LogNotFoundEntity, String> getLogNotFounds() {
        return logNotFounds;
    }

    public void addLogNotFound(String topic, String host, String file, long ts, String source) {
        LogNotFoundEntity entity = new LogNotFoundEntity(topic, host);
        entity.setFile(file);
        entity.setTs(ts);
        if(null == logNotFounds.putIfAbsent(entity, source)) {
            LOG.info(entity);
        }
    }

    public void removeLogNotFound(String topic, String host) {
        logNotFounds.remove(new LogNotFoundEntity(topic, host));
    }

    class LionChangeListener implements ConfigChange {
    
        @Override
        public void onChange(String key, String value) {
            if (key.equals(ParamsKey.LionNode.TOPIC)) {
                String[] topics = Util.getStringListOfLionValue(value);
                if (topics != null) {
                    Set<String> newTopicSet = new HashSet<String>(Arrays.asList(topics));
                    for (String newTopic : newTopicSet) {
                        if (!confMap.containsKey(newTopic)) {
                            LOG.info("Topics Change is triggered by "+ newTopic);
                            confMap.put(newTopic, new TopicConfig(newTopic));
                            String watchKey = ParamsKey.LionNode.CONF_PREFIX + newTopic;
                            addWatherForKey(watchKey);
                            watchKey = ParamsKey.LionNode.HOSTS_PREFIX + newTopic;
                            addWatherForKey(watchKey);
                            //trigger new topic to broadcast confRes messages
                            newTopicToBroadcast.add(newTopic);
                        }
                    }
                    for (String oldTopic : confMap.keySet()) {
                        if (!newTopicSet.contains(oldTopic)) {
                            removeConf(oldTopic);
                        }
                    }
                }
            } else if (key.equals(ParamsKey.LionNode.BLACKLIST)) {
                LOG.info("black list has been changed.");
                loadBlacklist(value);
            } else if (key.equals(ParamsKey.LionNode.BROKER_ASSIGN_LIMIT_MIN)) {
                if (brokerAssignmentLimitEnable) {
                    brokerAssignmentLimitMin = Util.parseInt(value, 1);
                }
            } else if (key.startsWith(ParamsKey.LionNode.CONF_PREFIX)) {
                for (String topic : confMap.keySet()) {
                    if (key.equals(ParamsKey.LionNode.CONF_PREFIX + topic)) {
                        LOG.info("Topic Conf Change is triggered by " + topic);
                        fillConfMap(topic, value);
                        break;
                    }
                }
            } else if (key.startsWith(ParamsKey.LionNode.HOSTS_PREFIX)) {
                for (String topic : confMap.keySet()) {
                    if (key.equals(ParamsKey.LionNode.HOSTS_PREFIX + topic)) {
                        LOG.info("Agent Hosts Change is triggered by " + topic);
                        fillHostMap(topic, value);
                        break;
                    }
                }
            } else if (key.equals(ParamsKey.LionNode.PERASSIGNMENT)) {
                LOG.info("Preassignment broker Change is triggered");
                loadBrokerPerassignment(value);
            }
        }
    
        private void addWatherForKey(String watchKey) {
            definitelyGetProperty(watchKey);
        }
    }
}