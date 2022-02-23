package com.muratkistan.controller;

import com.muratkistan.dto.CreditRequestDto;
import com.muratkistan.dto.CreditResultDto;
import com.muratkistan.model.Credit;
import com.muratkistan.service.abstracts.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credits")
public class CreditController {

    private final CreditService creditService;

    @GetMapping("/getAll")
    public List<Credit> getAllCredits(){
        return creditService.getAllCredits();
    }

    @GetMapping("/{identityNumber}")
    public Credit findCreditByIdentityNumber(@PathVariable("identityNumber") String identityNumber) {
        return creditService.findCreditByIdentityNumber(identityNumber);
    }

    @PostMapping("/calculate")
    public CreditResultDto calculateCredit(@Valid @RequestBody CreditRequestDto creditRequestDto) {
        return creditService.calculateCredit(creditRequestDto);
    }
}
