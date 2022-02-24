package com.muratkistan.service.abstracts;

import com.muratkistan.dto.CreditScoreDto;
import com.muratkistan.model.CreditScore;

import java.util.List;
import java.util.Optional;

public interface CreditScoreService {
    CreditScoreDto addScore(CreditScoreDto creditScoreDto);
    List<CreditScoreDto> getAllScores();
    CreditScoreDto updateCreditScore(String identityNumber,CreditScoreDto creditScoreDto);
    CreditScoreDto findByIdentityNumber(String identityNumber);
}
