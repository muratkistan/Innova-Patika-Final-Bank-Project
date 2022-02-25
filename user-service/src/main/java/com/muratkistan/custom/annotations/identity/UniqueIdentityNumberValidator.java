package com.muratkistan.custom.annotations.identity;

import com.muratkistan.model.User;
import com.muratkistan.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueIdentityNumberValidator implements ConstraintValidator<UniqueIdentityNumber,String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String identityNumber, ConstraintValidatorContext context) {
       User user = userRepository.findByIdentityNumber(identityNumber);
       if(user != null) {
           return false;
       }

        return true;
    }
}
