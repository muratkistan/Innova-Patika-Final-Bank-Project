package com.muratkistan.service.impl;

import com.muratkistan.dto.CreditDto;
import com.muratkistan.dto.UserDto;
import com.muratkistan.model.Credit;
import com.muratkistan.repository.CreditRepository;
import com.muratkistan.service.abstracts.CreditScoreService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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

//    @BeforeEach
//    public void setUp(){
//        creditRepository = mock(CreditRepository.class);
//        creditScoreService= mock(CreditScoreService.class);
//        modelMapper = mock(ModelMapper.class);
//        restTemplate = mock(RestTemplate.class);
//
//        creditService = new CreditServiceImpl(creditRepository,creditScoreService,modelMapper,restTemplate);
//    }


    @Test
    void getAllCredits(){

        Credit creditDto1 = new Credit("1111","1111",10000,true);
        Credit creditDto2 = new Credit("2222","2222",20000,true);


        List<Credit> creditDtos= new ArrayList<>();

        creditDtos.add(creditDto1);
        creditDtos.add(creditDto2);

        when(creditRepository.findAll()).thenReturn(creditDtos);

        List<CreditDto> allCreditDtos = creditService.getAllCredits();

        Assert.assertEquals(creditDtos.size(),allCreditDtos.size());
        verify(creditRepository).findAll();
    }


}