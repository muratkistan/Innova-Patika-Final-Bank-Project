package com.muratkistan.controller;

import com.muratkistan.dto.CreditScoreDto;
import com.muratkistan.model.CreditScore;
import com.muratkistan.service.abstracts.CreditScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credits/score")
public class CreditScoreController {

    private final CreditScoreService creditScoreService;

    //GET ALL
    @GetMapping("getAll")
    public ResponseEntity<List<CreditScoreDto>> getAllUsers(){
        return ResponseEntity.ok(creditScoreService.getAllScores());

    }

    //ADD
    @PostMapping("/add")
    public ResponseEntity<CreditScoreDto> addUser(@Valid @RequestBody CreditScoreDto creditScoreDto){
        return ResponseEntity.ok(creditScoreService.addScore(creditScoreDto));
    }

    //GET By ID
    @GetMapping("/{identityNumber}")
    public ResponseEntity<CreditScoreDto> getUserById(@PathVariable(name = "identityNumber") String identityNumber){
        return ResponseEntity.ok(creditScoreService.findByIdentityNumber(identityNumber));
    }

    //UPDATE
    @PutMapping("/update/{identityNumber}")
    public ResponseEntity<CreditScoreDto> updateUser(@PathVariable String identityNumber,@Valid @RequestBody CreditScoreDto CreditScoreDto){
        return ResponseEntity.ok(creditScoreService.updateCreditScore(identityNumber,CreditScoreDto));
    }





}
