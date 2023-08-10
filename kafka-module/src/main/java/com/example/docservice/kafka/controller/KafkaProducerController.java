package com.example.docservice.kafka.controller;

import com.example.docservice.kafka.service.KafkaProducerService;
import com.example.docservice.schema.Address;
import com.example.docservice.schema.Company;
import com.example.docservice.schema.Document;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/create")
public class KafkaProducerController {

    @Value("${avro.topic.name.address}")
    private String addressTopicName;

    @Value("${avro.topic.name}")
    String companyTopicName;

    @Value("${avro.topic.name.document}")
    String documentTopicName;

    private final KafkaProducerService producerService;

    public KafkaProducerController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/address")
    public String createAddress(@RequestBody Address address) {
        log.info("sending data to topicName-Value {}-{}", addressTopicName, address.toString());
        producerService.sendAvroData(addressTopicName, address);
        return "Data Posted";
    }

    @PostMapping("/company")
    public String createCompany(@RequestBody Company company) {
        log.info("sending data to topicName-Value {}-{}", companyTopicName, company.toString());
        producerService.sendAvroData(companyTopicName, company);
        return "Data Posted";
    }

    @PostMapping("/document")
    public String createDocument(@RequestBody Document document) {
        log.info("sending data to topicName-Value {}-{}", documentTopicName, document.toString());
        producerService.sendAvroData(documentTopicName, document);
        return "Data Posted";
    }
}