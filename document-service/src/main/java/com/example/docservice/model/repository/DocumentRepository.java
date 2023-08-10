package com.example.docservice.model.repository;

import com.example.docservice.model.entity.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;

@Repository
public interface DocumentRepository extends MongoRepository<Document, String> {
    @Query("{id :?0}")
    Document getById(String id);
    Document findFirstByDocumentIdOrderByCreatedAtDesc(String id);
}
