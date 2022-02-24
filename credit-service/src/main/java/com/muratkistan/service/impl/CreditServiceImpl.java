package com.muratkistan.service.impl;

import com.muratkistan.dto.CreditRequestDto;
import com.muratkistan.dto.CreditResultDto;
import com.muratkistan.model.Credit;
import com.muratkistan.model.CreditScore;
import com.muratkistan.repository.CreditRepository;
import com.muratkistan.service.abstracts.CreditScoreService;
import com.muratkistan.service.abstracts.CreditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;
    private final CreditScoreService creditScoreService;
    private final RestTemplate restTemplate;


    @Override
    public Credit addCredit(Credit credit) {
        log.info("Adding credit score to DB + "+credit);
        return creditRepository.save(credit);
    }

    @Override
    public List<Credit> getAllCredits() {
        log.info("Get All credits from DB");
        return creditRepository.findAll();
    }

    @Override
    public Credit updateCredit(String identityNumber, Credit credit) {
        Credit creditDB = findCreditByIdentityNumber(identityNumber);
        if(creditDB != null){
            creditDB.setIdentityNumber(credit.getIdentityNumber());
            creditDB.setCreditLimit(credit.getCreditLimit());
        }
        log.info("Updated credit score -> user identity Number: "+identityNumber + " credit score : "+ credit);
        return null;
    }

    @Override
    public Credit findCreditByIdentityNumber(String identityNumber) {
        log.info("Get credit score user identity number : "+identityNumber);
        return creditRepository.findByIdentityNumber(identityNumber);
    }

    @Override
    public CreditResultDto calculateCredit(CreditRequestDto creditRequestDto) {
        return null;
    }

//    @Override
//    public CreditResultDto calculateCredit(CreditRequestDto creditRequestDto) {
//        Long score;
//        double limit;
//        Credit credit;
//        CreditScore creditScore = creditScoreService.findByIdentityNumber(creditRequestDto.getIdentityNumber());
//        CreditResultDto creditResultDto = new CreditResultDto();
//        score = creditScore.getCreditScore();
//        double salary = creditRequestDto.getMonthlySalary();
//        String identityNumber = creditScore.getIdentityNumber();
//
//
//        if(score >= 500){
//
//            if(score < 1000){
//                if(salary < 5000){
//                    limit =10000;
//                    credit = Credit.builder().identityNumber(identityNumber).creditLimit(limit).build();
//                    addCredit(credit);
//                    log.info("Approved credit -> identity Number : " +identityNumber + " limit: "+limit);
//                    restTemplate.postForObject("http://USER-SERVICE/users/add", creditRequestDto, Object.class);
//                    return new CreditResultDto(true,identityNumber,score,limit);
//                }else{
//                    limit =20000;
//                    credit = Credit.builder().identityNumber(identityNumber).creditLimit(limit).build();
//                    addCredit(credit);
//                    log.info("Approved credit -> identity Number : " +identityNumber + " limit: "+limit);
//                    restTemplate.postForObject("http://USER-SERVICE/users/add", creditRequestDto, Object.class);
//                    return new CreditResultDto(true,identityNumber,score,limit);
//                }
//            }else{
//                limit = 4 * salary;
//                credit = Credit.builder().identityNumber(identityNumber).creditLimit(limit).build();
//                addCredit(credit);
//                log.info("Approved credit -> identity Number : " +identityNumber + " limit: "+limit);
//                restTemplate.postForObject("http://USER-SERVICE/users/add", creditRequestDto, Object.class);
//                return new CreditResultDto(true,identityNumber,score,limit);
//            }
//        }else{
//
//            log.info("Unapproved credit -> identity Number : " +identityNumber );
//            return new CreditResultDto(false);
//        }
//    }
}
