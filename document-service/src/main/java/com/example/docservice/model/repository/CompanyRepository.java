package com.example.docservice.model.repository;

import com.example.docservice.model.entity.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {
    @Query("{id :?0}")
    Company getById(String id);
}
