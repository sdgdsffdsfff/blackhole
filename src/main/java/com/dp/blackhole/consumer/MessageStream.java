package com.dp.blackhole.consumer;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;

public class MessageStream implements Iterable<String> {

    public final String topic;

    public final int consumerTimeoutMs;

    private final ConsumerIterator consumerIterator;

    public MessageStream(String topic, BlockingQueue<FetchedDataChunk> queue, int consumerTimeoutMs) {
        super();
        this.topic = topic;
        this.consumerTimeoutMs = consumerTimeoutMs;
        this.consumerIterator = new ConsumerIterator(topic, queue, consumerTimeoutMs);
    }

    @Override
    public Iterator<String> iterator() {
        return consumerIterator;
    }

    /**
     * This method clears the queue being iterated during the consumer
     * rebalancing. This is mainly to reduce the number of duplicates
     * received by the consumer
     */
    public void clear() {
        consumerIterator.clearCurrentChunk();
    }

}
