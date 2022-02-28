package com.muratkistan.service.impl;


import com.muratkistan.dto.CreditScoreDto;
import com.muratkistan.dto.UserDto;
import com.muratkistan.model.CreditScore;
import com.muratkistan.model.mapper.CreditScoreMapper;
import com.muratkistan.repository.CreditScoreRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CreditScoreServiceImplTest {

    @Mock
    private  CreditScoreRepository creditScoreRepository;

    @Mock
    private  ModelMapper modelMapper;


    private CreditScoreServiceImpl creditScoreService;

    @BeforeEach
    void setup() {
        creditScoreService = new CreditScoreServiceImpl(creditScoreRepository, new ModelMapper());
    }




    @Test
    void getAllCredits(){

        CreditScore score1 = new CreditScore("1111","11111111111",10000);
        CreditScore score2 = new CreditScore("2222","22222222222",20000);


        List<CreditScore> scores= new ArrayList<>();

        scores.add(score1);
        scores.add(score2);

        when(creditScoreRepository.findAll()).thenReturn(scores);

        List<CreditScoreDto> allCreditDtos = creditScoreService.getAllScores();

        Assert.assertEquals(scores.size(),allCreditDtos.size());
        verify(creditScoreRepository).findAll();
    }




    @Test
    void findByIdentityNumber(){

            CreditScore creditScore = CreditScore.builder().id("1111")
                    .identityNumber("1111")
                    .creditScore(1200).build();


            when(creditScoreRepository.findByIdentityNumber("1111")).thenReturn(creditScore);

            CreditScoreDto creditScoreDto  = creditScoreService.findByIdentityNumber(creditScore.getIdentityNumber());

            Assert.assertEquals(creditScoreDto.getIdentityNumber(),creditScore.getIdentityNumber());




    }

    @Test
    void addScore(){
        CreditScore creditScore = CreditScore.builder().id("1111")
                .identityNumber("1111").creditScore(1000).build();


        CreditScoreDto creditScoreDto = CreditScoreMapper.entityToDto(creditScore);

        when(creditScoreRepository.save(Mockito.any(CreditScore.class))).thenReturn(creditScore);

        CreditScoreDto savedScore = creditScoreService.addScore(creditScoreDto);

        Assert.assertEquals(savedScore.getIdentityNumber(),creditScore.getIdentityNumber());
        Assert.assertEquals(savedScore.getId(),creditScore.getId());

    }




}