package com.muratkistan.repository;

import com.muratkistan.model.Credit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends MongoRepository<Credit,String> {
    Credit findByIdentityNumber(String identityNumber);
}
