package com.muratkistan.repository;

import com.muratkistan.model.CreditScore;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditScoreRepository extends MongoRepository<CreditScore,String> {
    Optional<CreditScore> findByIdentityNumber(String identityNumber);
}
