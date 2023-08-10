package com.example.docservice.model.repository;

import com.example.docservice.model.entity.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AddressRepository extends MongoRepository<Address, String> {
    Address findAddressById(String id);
}
