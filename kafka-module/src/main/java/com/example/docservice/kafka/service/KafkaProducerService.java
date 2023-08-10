package com.example.docservice.kafka.service;

import com.example.docservice.schema.Address;
import com.example.docservice.schema.Company;
import com.example.docservice.schema.Document;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerService {
    @Value("${avro.topic.name.address}")
    String addressTopicName;

    String companyTopicName = "company_topic4";

    @Value("${avro.topic.name.document}")
    String documentTopicName;

    private final KafkaTemplate<String, Address> addressKafkaTemplate;
    private final KafkaTemplate<String, Company> companyKafkaTemplate;
    private final KafkaTemplate<String, Document> documentKafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Address> addressKafkaTemplate,
                                KafkaTemplate<String, Company> companyKafkaTemplate,
                                KafkaTemplate<String, Document> documentKafkaTemplate) {
        this.addressKafkaTemplate = addressKafkaTemplate;
        this.companyKafkaTemplate = companyKafkaTemplate;
        this.documentKafkaTemplate = documentKafkaTemplate;
    }

    public void sendAvroData(String topicName, Address address) {
        log.info("sending data to kafka topic i.e. {}", topicName);
        String key = "Key" + String.format("%.3f", Math.random());
        addressKafkaTemplate.send(topicName, key, address);
        log.info("Sent message successfully {} ", address.toString());
    }

    public void sendAvroData(String companyTopicName, Company company) {
        log.info("sending data to kafka topic i.e. {}", companyTopicName);
        String key = "Key" + String.format("%.3f", Math.random());
        companyKafkaTemplate.send(companyTopicName, key, company);
        log.info("Sent message successfully {} ", company.toString());
    }

    public void sendAvroData(String documentTopicName, Document document) {
        log.info("sending data to kafka topic i.e. {}", documentTopicName);
        String key = "Key" + String.format("%.3f", Math.random());
        documentKafkaTemplate.send(documentTopicName, key, document);
        log.info("Sent message successfully {} ", document.toString());
    }


}