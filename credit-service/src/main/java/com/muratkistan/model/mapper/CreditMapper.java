package com.muratkistan.model.mapper;

import com.muratkistan.dto.CreditDto;
import com.muratkistan.dto.CreditScoreDto;
import com.muratkistan.model.Credit;
import com.muratkistan.model.CreditScore;


public class CreditMapper {

    public static Credit dtoToEntity(CreditDto creditDto){
        //Builder Design Pattern
        return Credit.builder()
                .id(creditDto.getId())
                .identityNumber(creditDto.getIdentityNumber())
                .creditLimit(creditDto.getCreditLimit()).status(creditDto.getStatus()).build();

    }

    public static CreditDto entityToDto(Credit credit){

        //Builder Design Pattern
        return CreditDto.builder()
                .id(credit.getId())
                .identityNumber(credit.getIdentityNumber())
                .creditLimit(credit.getCreditLimit()).status(credit.getStatus()).build();
    }
}
