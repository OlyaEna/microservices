////package com.example.docservice.configuration;
////
////import org.apache.kafka.clients.admin.NewTopic;
////import org.springframework.beans.factory.annotation.Value;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.kafka.config.TopicBuilder;
////
////@Configuration
////public class KafkaTopicConfig {
////
////    @Value("${spring.kafka.topic-json.name.address}")
////    private String addressTopic;
////
////    @Value("${spring.kafka.topic-json.name.company}")
////    private String companyTopic;
////
////    @Value("${spring.kafka.topic-json.name.document}")
////    private String documentTopic;
////
////
////    @Bean
////    public NewTopic newAddressTopic(){
////        return TopicBuilder.name(addressTopic)
////                .build();
////    }
////
////    @Bean
////    public NewTopic newCompanyTopic(){
////        return TopicBuilder.name(companyTopic)
////                .build();
////    }
////
////    @Bean
////    public NewTopic newDocumentTopic(){
////        return TopicBuilder.name(documentTopic)
////                .build();
////    }
//
//}