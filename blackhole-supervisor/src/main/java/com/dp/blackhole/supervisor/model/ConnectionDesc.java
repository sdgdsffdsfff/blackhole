package com.dp.blackhole.supervisor.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

import com.dp.blackhole.common.ParamsKey;
import com.dp.blackhole.common.Util;
import com.dp.blackhole.network.ByteBufferNonblockingConnection;

public class ConnectionDesc {
    public static final int AGENT = 1;
    public static final int BROKER = 2;
    public static final int CONSUMER = 3;
    public static final int PRODUCER = 4;
    
    private int type;
    private AtomicLong lastHeartBeat;
    private final ByteBufferNonblockingConnection connection;
    private final ConnectionInfo connectionInfo;
    //Storm sets up multi-thread(Executors) in a processor(worker),
    //each executor will register a consumer entity
    private List<NodeDesc> attachments;
    private String version;
    
    public ConnectionDesc(ByteBufferNonblockingConnection connection) {
        this.connection = connection;
        this.connectionInfo = new ConnectionInfo(connection.getHost(), connection.getIP(), connection.getPort());
        lastHeartBeat = new AtomicLong(Util.getTS());
        attachments = new ArrayList<NodeDesc>();
        this.version = ParamsKey.DEFAULT_VERSION;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    
    public int getType() {
        return type;
    }
    
    public void updateHeartBeat() {
        lastHeartBeat.getAndSet(Util.getTS());
    }

    public long getLastHeartBeat() {
        return lastHeartBeat.get();
    }
    
    @JsonIgnore
    public ByteBufferNonblockingConnection getConnection() {
        return connection;
    }

    public ConnectionInfo getConnectionInfo() {
        return connectionInfo;
    }

    @JsonIgnore
    public List<NodeDesc> getAttachments() {
        return attachments;
    }

    @JsonIgnore
    public void attach(NodeDesc desc) {
        attachments.add(desc);
    }
    
    @JsonIgnore
    public void detach(NodeDesc desc) {
        attachments.remove(desc);
    }
    
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        if (StringUtils.isBlank(version)) {
            this.version = ParamsKey.DEFAULT_VERSION;
        } else {
            this.version = version;
        }
    }

    @Override
    public String toString() {
        String typeName = "";
        switch (this.type) {
        case AGENT:
            typeName = "AGENT";
            break;
        case BROKER:
            typeName = "BROKER";
            break;
        case CONSUMER:
            typeName = "CONSUMER";
            break;
        case PRODUCER:
            typeName = "PRODUCER";
            break;
        default:
            typeName = "UNKNOW";
            break;
        }
        return connection.toString() + " type: " + typeName;
    }
    
    public static class ConnectionInfo {
        private final String host;
        private final String ip;
        private final int port;
        
        public ConnectionInfo(String host, String ip, int port) {
            this.host = host;
            this.ip = ip;
            this.port = port;
        }
        
        public String getHost() {
            return host;
        }
        public String getIp() {
            return ip;
        }
        public int getPort() {
            return port;
        }
    }
}
