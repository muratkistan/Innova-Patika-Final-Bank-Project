package com.muratkistan.service.abstracts;

import com.muratkistan.model.CreditScore;

import java.util.List;

public interface CreditScoreService {
    CreditScore addScore(CreditScore creditScore);
    List<CreditScore> getAllScores();
    CreditScore updateCreditScore(String identityNumber,CreditScore creditScore);
    CreditScore findByIdentityNumber(String identityNumber);
}
