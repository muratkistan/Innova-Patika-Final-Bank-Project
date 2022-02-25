package com.muratkistan.service.abstracts;

import com.muratkistan.dto.CreditDto;
import com.muratkistan.dto.CreditResultDto;
import com.muratkistan.dto.UserDto;

import java.util.List;

public interface CreditService {
    CreditDto addCredit(CreditDto CreditDto);
    List<CreditDto> getAllCredits();
    CreditDto updateCredit(String identityNumber,CreditDto creditDto);
    CreditDto findCreditByIdentityNumber(String identityNumber);
    CreditResultDto calculateCredit(UserDto userDto);
}
