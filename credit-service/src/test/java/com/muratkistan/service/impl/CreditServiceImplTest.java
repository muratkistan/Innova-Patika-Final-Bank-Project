package com.muratkistan.service.impl;

import com.muratkistan.dto.CreditDto;
import com.muratkistan.dto.CreditScoreDto;
import com.muratkistan.dto.UserDto;
import com.muratkistan.model.Credit;
import com.muratkistan.model.CreditScore;
import com.muratkistan.model.mapper.CreditMapper;
import com.muratkistan.model.mapper.CreditScoreMapper;
import com.muratkistan.repository.CreditRepository;
import com.muratkistan.service.abstracts.CreditScoreService;
import org.junit.Assert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreditServiceImplTest {

    @Mock
    private CreditRepository creditRepository;

    @Mock
    private CreditScoreService creditScoreService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CreditServiceImpl creditService;

    @BeforeEach
    void setup() {
        creditService = new CreditServiceImpl(creditRepository,creditScoreService, new ModelMapper(),new  RestTemplate());
    }




    @Test
    void getAllCredits(){

        Credit credit1 = new Credit("1111","11111111111",10000,true);
        Credit credit2 = new Credit("2222","22222222222",20000,true);


        List<Credit> credits= new ArrayList<>();

        credits.add(credit1);
        credits.add(credit2);

        when(creditRepository.findAll()).thenReturn(credits);

        List<CreditDto> allCreditDtos = creditService.getAllCredits();

        Assert.assertEquals(credits.size(),allCreditDtos.size());
        verify(creditRepository).findAll();
    }

    @Test
    void addScore(){
        Credit credit = Credit.builder().id("1111")
                .identityNumber("1111").creditLimit(3000).status(true).build();


        CreditDto creditDto = CreditMapper.entityToDto(credit);

        when(creditRepository.save(Mockito.any(Credit.class))).thenReturn(credit);

        CreditDto savedCredit = creditService.addCredit(creditDto);

        Assert.assertEquals(savedCredit.getIdentityNumber(),credit.getIdentityNumber());
        Assert.assertEquals(savedCredit.getId(),credit.getId());

    }

    @Test
    void getByIdentityNumber(){

        Credit  credit = Credit.builder().id("1111")
                .identityNumber("1111")
                .creditLimit(10000).status(true).build();




        when(creditRepository.findByIdentityNumber("1111")).thenReturn(Optional.of(credit));

        CreditDto creditDto  = creditService.findCreditByIdentityNumber(credit.getIdentityNumber());

        Assert.assertEquals(creditDto.getIdentityNumber(),credit.getIdentityNumber());

    }













}