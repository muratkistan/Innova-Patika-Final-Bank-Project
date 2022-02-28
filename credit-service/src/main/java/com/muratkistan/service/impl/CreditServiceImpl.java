package com.muratkistan.service.impl;

import com.muratkistan.dto.*;
import com.muratkistan.model.Credit;
import com.muratkistan.repository.CreditRepository;
import com.muratkistan.service.abstracts.CreditScoreService;
import com.muratkistan.service.abstracts.CreditService;
import com.muratkistan.util.NotFoundException;
import com.muratkistan.util.constants.ConstantVariable;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class CreditServiceImpl implements CreditService {


    private final  CreditRepository creditRepository;
    private final CreditScoreService creditScoreService;
    private final ModelMapper modelMapper;
    private final RestTemplate  restTemplate;



    //ADD
    @Override
    public CreditDto addCredit(CreditDto creditDto) {
        Credit credit = modelMapper.map(creditDto,Credit.class);
        log.info("Adding credit  to DB + "+creditDto);
        return modelMapper.map(creditRepository.save(credit),CreditDto.class);
    }

    //GET ALL
    @Override
    public List<CreditDto> getAllCredits() {
        log.info("Get All credits from DB");
        List<Credit> credits = creditRepository.findAll();
        return credits.stream().map(score -> modelMapper.map(score,CreditDto.class)).collect(Collectors.toList());
    }



    //FIND CREDIT BY IDENTITY NUMBER
    @Override
    public CreditDto findCreditByIdentityNumber(String identityNumber) {
        log.info("Get credit  user identity number : "+identityNumber);
        Optional<Credit> credit = creditRepository.findByIdentityNumber(identityNumber);
        return credit.map(score -> modelMapper.map(score, CreditDto.class)).orElseThrow(() ->new NotFoundException("Credit"));

    }



    //CHECK USER FROM DATABASE IN USER-SERVICE
     Boolean checkUserFromUserService(RestTemplate restTemplate,String identityNumber){
        return restTemplate.getForObject(ConstantVariable.CHECK_USER_FROM_USER_SERVICE_PATH+identityNumber,Boolean.class);
    }




    //CALCULATE CREDIT
    @Override
    public CreditResultDto calculateCredit(UserDto userDto) {
        int score;
        CreditScoreDto creditScoreDto;
        if (creditScoreService.existsByIdentityNumber(userDto.getIdentityNumber())){
            //get score by identityNumber from database
             creditScoreDto = creditScoreService.findByIdentityNumber(userDto.getIdentityNumber());
            score = creditScoreDto.getCreditScore();
        }else {//MINIMUM LIMIT IS  ASSIGNED TO A NEW CUSTOMER
            score = 500;
        }
        //CALCULATE CREDIT
        return calculateCreditHelper(score,userDto);
    }


    //Calculate Credit Limit
    public double limitCalculatorHelper(Integer score,double salary){
        double limit;
        if(score < 1000){
            if(salary < 5000){
                limit =ConstantVariable.SMALL_CREDIT;
            }else{
                limit =ConstantVariable.MIDDLE_CREDIT;
            }
        }else{
            limit = ConstantVariable.MULTIPLIER * salary;
        }
        return limit;
    }



    //HELPER METHOD FOR CALCULATE CREDIT
    CreditResultDto calculateCreditHelper(int score,UserDto userDto){
        double limit,salary=userDto.getMonthlySalary();
        String identityNumber = userDto.getIdentityNumber();

        if(score >= 500){//APPROVED CREDIT
            limit = limitCalculatorHelper(score,salary);//Called Limit calculator

            if(!checkUserFromUserService(restTemplate,userDto.getIdentityNumber())){     //Check user is Present in Database from user-service
                restTemplate.postForObject(ConstantVariable.ADD_USER_TO_USER_SERVICE_PATH, userDto, Object.class); // Send user to user-service for save database
                creditScoreService.addScore(new CreditScoreDto(identityNumber,score));//Add new user score to database
            }
            addCredit(modelMapper.map(Credit.builder().identityNumber(identityNumber).creditLimit(limit).status(true).build(),CreditDto.class));
            log.info("Approved credit -> identity Number : " +identityNumber + " limit: "+limit);
            return new CreditResultDto(true,identityNumber,score,limit);

        }else{//UNAPPROVED CREDIT
            log.info("Unapproved credit -> identity Number : " +identityNumber );
            addCredit(modelMapper.map(Credit.builder().identityNumber(identityNumber).creditLimit(0).status(false).build(),CreditDto.class));
            return new CreditResultDto(false);
        }

    }



}
