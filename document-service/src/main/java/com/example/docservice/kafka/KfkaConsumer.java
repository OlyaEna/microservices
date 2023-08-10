package com.example.docservice.kafka;

import com.example.docservice.schema.Address;
import com.example.docservice.schema.Company;
import com.example.docservice.schema.Document;
import com.example.docservice.service.AddressService;
import com.example.docservice.service.CompanyService;
import com.example.docservice.service.DocumentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class KfkaConsumer {
    private final AddressService addressService;
    private final CompanyService companyService;
    private final DocumentService documentService;

    @KafkaListener(topics = "${avro.topic.name.address}", containerFactory = "kafkaListenerContainerFactory")
    public void readAddress(ConsumerRecord<String, Address> record, Acknowledgment acknowledgment) {
        String key = record.key();
        Address address = record.value();
        acknowledgment.acknowledge();
        addressService.transferFromAvro(address);
        log.info("Avro message received for key : " + key + " value : " + address.toString());
    }

    @KafkaListener(topics = "${avro.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void readCompany(ConsumerRecord<String, Company> record, Acknowledgment acknowledgment) {
        String key = record.key();
        Company company = record.value();
        acknowledgment.acknowledge();
        companyService.transferFromAvro(company);
        log.info("Avro message received for key : " + key + " value : " + company.toString());
    }

    @KafkaListener(topics = "${avro.topic.name.document}", containerFactory = "kafkaListenerContainerFactory")
    public void readDocument(ConsumerRecord<String, Document> record, Acknowledgment acknowledgment) {
        String key = record.key();
        Document document = record.value();
        acknowledgment.acknowledge();
        documentService.transferFromAvro(document);

        log.info("Avro message received for key : " + key + " value : " + document.toString());
    }

}