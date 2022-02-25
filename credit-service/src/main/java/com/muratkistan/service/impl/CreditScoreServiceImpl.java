package com.muratkistan.service.impl;

import com.muratkistan.dto.CreditScoreDto;
import com.muratkistan.model.CreditScore;
import com.muratkistan.repository.CreditScoreRepository;
import com.muratkistan.service.abstracts.CreditScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class CreditScoreServiceImpl implements CreditScoreService {

    private final CreditScoreRepository creditScoreRepository;
    private final ModelMapper modelMapper;

    @Override
    public CreditScoreDto addScore(CreditScoreDto creditScoreDto) {
        CreditScore creditScore = modelMapper.map(creditScoreDto,CreditScore.class);
        log.info("Adding credit score to DB + "+creditScoreDto);
        return  modelMapper.map(creditScoreRepository.save(creditScore),CreditScoreDto.class);
    }

    @Override
    public List<CreditScoreDto> getAllScores() {
        log.info("Get All creditScores from DB");
        List<CreditScore> creditScores = creditScoreRepository.findAll();

        return creditScores.stream().map(score -> modelMapper.map(score,CreditScoreDto.class)).collect(Collectors.toList());
    }

    @Override
    public CreditScoreDto updateCreditScore(String identityNumber, CreditScoreDto creditScoreDto) {
        log.info("Updated credit score -> user identity Number: "+identityNumber + " credit score : "+ creditScoreDto);
        CreditScoreDto dtoDb = findByIdentityNumber(identityNumber);
        dtoDb.setIdentityNumber(creditScoreDto.getIdentityNumber());
        dtoDb.setCreditScore(creditScoreDto.getCreditScore());
        return modelMapper.map(creditScoreRepository.save(modelMapper.map(dtoDb,CreditScore.class)),CreditScoreDto.class);


    }

    @Override
    public CreditScoreDto findByIdentityNumber(String identityNumber) {
        return modelMapper.map(creditScoreRepository.findByIdentityNumber(identityNumber),CreditScoreDto.class);
    }


    @Override
    public Boolean existsByIdentityNumber(String identityNumber) {
        log.info("Check credit score for user identity number : "+identityNumber);
        return creditScoreRepository.existsByIdentityNumber(identityNumber);
    }


}
