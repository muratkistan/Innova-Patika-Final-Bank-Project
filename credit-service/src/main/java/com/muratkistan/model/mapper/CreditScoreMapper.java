package com.muratkistan.model.mapper;

import com.muratkistan.dto.CreditScoreDto;

import com.muratkistan.model.CreditScore;


public class CreditScoreMapper {

    public static CreditScore dtoToEntity(CreditScoreDto creditScoreDto){
        //Builder Design Pattern
        return CreditScore.builder()
                .id(creditScoreDto.getId())
                .identityNumber(creditScoreDto.getIdentityNumber())
                .creditScore(creditScoreDto.getCreditScore()).build();

    }

    public static CreditScoreDto entityToDto(CreditScore creditScore){

        //Builder Design Pattern
        return CreditScoreDto.builder()
                .id(creditScore.getId())
                .identityNumber(creditScore.getIdentityNumber())
                .creditScore(creditScore.getCreditScore()).build();
    }
}
