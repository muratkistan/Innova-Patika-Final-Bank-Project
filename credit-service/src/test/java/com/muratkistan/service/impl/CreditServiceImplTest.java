package com.muratkistan.service.impl;

import com.muratkistan.dto.CreditDto;
import com.muratkistan.model.Credit;
import com.muratkistan.repository.CreditRepository;
import com.muratkistan.service.abstracts.CreditScoreService;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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


//    @Test
//    void getCredits_successful(){
//
//        //init step
//        Credit expectedCredit = new Credit("3","546",10000,true);
//
////        stub - when step
//        Optional<Credit> expectedOptionalCredit = (Optional<Credit>) Optional.of(expectedCredit);
//        when(creditRepository.findByIdentityNumber("1111")).thenReturn(expectedOptionalCredit);
//
//        //then step
//        CreditDto actualCreditDto = creditService.findCreditByIdentityNumber("546");
//
//        //valid step
//        assertEquals(expectedCredit, actualCreditDto);
//    }
///////////////////////////////////////////////////////////////////////////////////////////////////
//    @Test
//    void addCredit(){
//        Credit expectedCredit = new Credit("1111","11111111111",10000,true);
//        Credit credit2 = new Credit("2222","22222222222",20000,true);
//        // stub - when
//        when(creditRepository.save(expectedCredit)).thenReturn(expectedCredit);
//
//        // then
//        creditService.addCredit(modelMapper.map(expectedCredit,CreditDto.class));
//        Optional<Credit> byId = creditRepository.findById("1111");
////
//        Assert.assertEquals(expectedCredit, byId);
//
//        verify(creditRepository, times(1)).save(expectedCredit);
//    }










}