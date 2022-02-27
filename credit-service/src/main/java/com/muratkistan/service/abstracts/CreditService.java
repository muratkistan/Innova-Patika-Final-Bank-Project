package com.muratkistan.service.abstracts;

import com.muratkistan.dto.CreditDto;
import com.muratkistan.dto.CreditResultDto;
import com.muratkistan.dto.UserDto;
import com.muratkistan.model.Credit;

import java.util.List;
import java.util.Optional;

public interface CreditService {
    CreditDto addCredit(CreditDto CreditDto);
    List<CreditDto> getAllCredits();
    CreditDto findCreditByIdentityNumber(String identityNumber);
    CreditResultDto calculateCredit(UserDto userDto);
}
