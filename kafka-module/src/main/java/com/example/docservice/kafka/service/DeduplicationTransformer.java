package com.example.docservice.kafka.service;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KeyValueMapper;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.WindowStore;
import org.apache.kafka.streams.state.WindowStoreIterator;

public class DeduplicationTransformer<K, V, E> implements Transformer<K, V, KeyValue<K, V>> {
    private static final String storeName = "document-store";

    private ProcessorContext context;
    private WindowStore<E, Long> eventIdStore;

    private final long leftDurationMs;
    private final long rightDurationMs;

    private final KeyValueMapper<K, V, E> idExtractor;

    public DeduplicationTransformer(final long maintainDurationPerEventInMs, final KeyValueMapper<K, V, E> idExtractor) {
        if (maintainDurationPerEventInMs < 1) {
            throw new IllegalArgumentException("maintain duration per event must be >= 1");
        }
        leftDurationMs = maintainDurationPerEventInMs / 2;
        rightDurationMs = maintainDurationPerEventInMs - leftDurationMs;
        this.idExtractor = idExtractor;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void init(final ProcessorContext context) {
        this.context = context;
        eventIdStore = context.getStateStore(storeName);
    }

    public KeyValue<K, V> transform(final K key, final V value) {
        final E eventId = idExtractor.apply(key, value);
        if (eventId == null) {
            return KeyValue.pair(key, value);
        } else {
            final KeyValue<K, V> output;
            if (isDuplicate(eventId)) {
                output = null;
                updateTimestampOfExistingEventToPreventExpiry(eventId, context.timestamp());
            } else {
                output = KeyValue.pair(key, value);
                rememberNewEvent(eventId, context.timestamp());
            }
            return output;
        }
    }

    private boolean isDuplicate(final E eventId) {
        final long eventTime = context.timestamp();
        final WindowStoreIterator<Long> timeIterator = eventIdStore.fetch(
                eventId,
                eventTime - leftDurationMs,
                eventTime + rightDurationMs);
        final boolean isDuplicate = timeIterator.hasNext();
        timeIterator.close();
        return isDuplicate;
    }

    private void updateTimestampOfExistingEventToPreventExpiry(final E eventId, final long newTimestamp) {
        eventIdStore.put(eventId, newTimestamp, newTimestamp);
    }

    private void rememberNewEvent(final E eventId, final long timestamp) {
        eventIdStore.put(eventId, timestamp, timestamp);
    }

    @Override
    public void close() {
    }
}
