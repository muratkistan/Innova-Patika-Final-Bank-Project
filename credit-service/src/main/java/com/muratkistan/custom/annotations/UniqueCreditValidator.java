package com.muratkistan.custom.annotations;

import com.muratkistan.model.Credit;
import com.muratkistan.repository.CreditRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@RequiredArgsConstructor
public class UniqueCreditValidator implements ConstraintValidator<UniqueCredit,String> {

    private final CreditRepository creditRepository;
    @Override
    public boolean isValid(String identityNumber, ConstraintValidatorContext context) {

        Optional<Credit> credit = creditRepository.findByIdentityNumber(identityNumber);
        if(credit.isPresent()){
            return false;
        }
        return true;
    }
}
