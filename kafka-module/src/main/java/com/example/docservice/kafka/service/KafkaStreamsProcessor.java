package com.example.docservice.kafka.service;

import java.time.Duration;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.state.StoreBuilder;
import org.apache.kafka.streams.state.Stores;
import org.apache.kafka.streams.state.WindowStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaStreamsProcessor {
    private static final String storeName = "document-store";
    final Duration windowSize = Duration.ofMinutes(5);
    final Duration retentionPeriod = windowSize;

    final StoreBuilder<WindowStore<String, Long>> dedupStoreBuilder = Stores.windowStoreBuilder(
            Stores.persistentWindowStore(storeName,
                    retentionPeriod,
                    windowSize,
                    false
            ),
            Serdes.String(),
            Serdes.Long());

    @Autowired
    void buildPipeline(StreamsBuilder streamsBuilder) {
        streamsBuilder.addStateStore(dedupStoreBuilder);

        final KStream<String, String> stream = streamsBuilder.stream("input-document");
        final KStream<String, String> deduplicated = stream.transform(
                () -> new DeduplicationTransformer<>(windowSize.toMillis(), (key, value) -> value),
                storeName);
        deduplicated.to("output-document");
    }
}