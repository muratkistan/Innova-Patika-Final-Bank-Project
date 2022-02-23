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

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;
    private final CreditScoreService creditScoreService;


    @Override
    public Credit addCredit(Credit credit) {
        return creditRepository.save(credit);
    }

    @Override
    public List<Credit> getAllCredits() {
        return creditRepository.findAll();
    }

    @Override
    public Credit updateCredit(String identityNumber, Credit credit) {
        Credit creditDB = findCreditByIdentityNumber(identityNumber);
        if(creditDB != null){
            creditDB.setIdentityNumber(credit.getIdentityNumber());
            creditDB.setCreditLimit(credit.getCreditLimit());
        }
        return null;
    }

    @Override
    public Credit findCreditByIdentityNumber(String identityNumber) {
        return creditRepository.findByIdentityNumber(identityNumber);
    }

    @Override
    public CreditResultDto calculateCredit(CreditRequestDto creditRequestDto) {
        Long score;
        double limit;
        Credit credit;
        CreditScore creditScore = creditScoreService.findByIdentityNumber(creditRequestDto.getIdentityNumber());
        CreditResultDto creditResultDto = new CreditResultDto();
        score = creditScore.getCreditScore();
        double salary = creditRequestDto.getMonthlySalary();
        String identityNumber = creditScore.getIdentityNumber();


        if(score >= 500){

            if(score < 1000){
                if(salary < 5000){
                    limit =10000;
                    credit = Credit.builder().identityNumber(identityNumber).creditLimit(limit).build();
                    addCredit(credit);
                    return new CreditResultDto(true,identityNumber,score,limit);
                }else{
                    limit =20000;
                    credit = Credit.builder().identityNumber(identityNumber).creditLimit(limit).build();
                    addCredit(credit);
                    return new CreditResultDto(true,identityNumber,score,limit);
                }
            }else{
                limit = 4 * salary;
                credit = Credit.builder().identityNumber(identityNumber).creditLimit(limit).build();
                addCredit(credit);
                return new CreditResultDto(true,identityNumber,score,limit);
            }
        }else{

            return new CreditResultDto(false);
        }
    }
}
