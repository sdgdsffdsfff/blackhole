package com.dp.blackhole.consumer;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dp.blackhole.consumer.ConsumerConnector;
import com.dp.blackhole.consumer.api.CommittedOffsetStrategy;
import com.dp.blackhole.consumer.api.Consumer;
import com.dp.blackhole.consumer.api.ConsumerConfig;
import com.dp.blackhole.consumer.api.MessagePack;
import com.dp.blackhole.consumer.api.decoder.StringDecoder;

public class TestSimpleConsumer {
   
    private static final Log LOG = LogFactory.getLog(TestSimpleConsumer.class);
    public static void main( String[] args ) throws InterruptedException {
        String topic = "localtest";
        String group = "t123";
        boolean debug = false;
        ConsumerConnector.getInstance().init("localhost", 8080, true, 6000);
        Properties prop = new Properties();
        ConsumerConfig config = new ConsumerConfig(prop);
        Consumer consumer = new Consumer(topic, group, config, new CommittedOffsetStrategy());
        consumer.start();
        MessageStream stream = consumer.getStream();
        MessageConsumeThread t = new MessageConsumeThread(stream, debug);
        t.start();
        int count = 0;
        while(true) {
            Thread.sleep(1000);
            count++;
            if (count == 20) {
                consumer.shutdown();
            }
            if (count == 40) {
                break;
            }
        }
    }
    
    static class MessageConsumeThread extends Thread {
        private MessageStream stream;
        private volatile boolean running;
        private boolean debug;
        private StringDecoder decoder;
        public MessageConsumeThread(MessageStream stream, boolean debug) {
            this.stream = stream;
            this.running = true;
            this.debug = debug;
            this.decoder = new StringDecoder();
        }
        
        @Override
        public void run() {
            LOG.info("WORK THREAD " + Thread.currentThread().getName());
            while (running) {
                long i =0;
                for (MessagePack entity : stream) {
                    if (i % 100000L == 0) {
                        LOG.info("consumed: " + i);
                    }
                    if (debug) {
                        System.out.println(decoder.decode(entity));
                    }
                    i++;
                }
                running = false;
                LOG.warn("shotdown gracefully");
            }
        }
        
        public void shutdown() {
            running = false;
        }
    }
}
