package com.muratkistan.service.abstracts;

import com.muratkistan.dto.CreditRequestDto;
import com.muratkistan.dto.CreditResultDto;
import com.muratkistan.model.Credit;

import java.util.List;

public interface CreditService {
    Credit addCredit(Credit credit);
    List<Credit> getAllCredits();
    Credit updateCredit(String identityNumber,Credit credit);
    Credit findCreditByIdentityNumber(String identityNumber);
    CreditResultDto calculateCredit(CreditRequestDto creditRequestDto);
}
