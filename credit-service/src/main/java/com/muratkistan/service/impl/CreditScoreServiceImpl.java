package com.muratkistan.service.impl;

import com.muratkistan.model.CreditScore;
import com.muratkistan.repository.CreditScoreRepository;
import com.muratkistan.service.abstracts.CreditScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CreditScoreServiceImpl implements CreditScoreService {

    private final CreditScoreRepository creditScoreRepository;

    @Override
    public CreditScore addScore(CreditScore creditScore) {
        log.info("Adding credit score to DB + "+creditScore);
        return creditScoreRepository.save(creditScore);
    }

    @Override
    public List<CreditScore> getAllScores() {
        log.info("Get All creditScores from DB");
        return creditScoreRepository.findAll();
    }

    @Override
    public CreditScore updateCreditScore(String identityNumber, CreditScore creditScore) {
        CreditScore creditScoreDB = findByIdentityNumber(identityNumber);
        if(creditScoreDB != null){
            creditScoreDB.setIdentityNumber(creditScore.getIdentityNumber());
            creditScoreDB.setCreditScore(creditScore.getCreditScore());
            log.info("Updated credit score -> user identity Number: "+identityNumber + " credit score : "+ creditScore);
            return creditScoreRepository.save(creditScoreDB);
        }
        return null;
    }

    @Override
    public CreditScore findByIdentityNumber(String identityNumber) {
        log.info("Get credit score user identity number : "+identityNumber);
        return  creditScoreRepository.findByIdentityNumber(identityNumber);
    }
}
