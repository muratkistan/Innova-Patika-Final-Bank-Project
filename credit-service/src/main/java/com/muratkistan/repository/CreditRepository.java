package com.muratkistan.repository;

import com.muratkistan.model.Credit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreditRepository extends MongoRepository<Credit,String> {
    Optional<Credit> findByIdentityNumber(String identityNumber);




}


