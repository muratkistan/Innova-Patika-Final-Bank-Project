package com.muratkistan.controller;

import com.muratkistan.dto.CreditDto;

import com.muratkistan.dto.CreditResultDto;
import com.muratkistan.dto.UserDto;
import com.muratkistan.model.Credit;
import com.muratkistan.service.abstracts.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credits")
public class CreditController {

    private final CreditService creditService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CreditDto>> getAllCredits(){
        return ResponseEntity.ok(creditService.getAllCredits());
    }

    @GetMapping("/{identityNumber}")
    public ResponseEntity<CreditDto> findCreditByIdentityNumber(@PathVariable("identityNumber") String identityNumber) {
        return  ResponseEntity.ok(creditService.findCreditByIdentityNumber(identityNumber));
    }


    @PostMapping("/calculate")
    public ResponseEntity<CreditResultDto> calculateCredit(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok( creditService.calculateCredit(userDto));
    }

}
