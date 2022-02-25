package com.muratkistan.custom.annotations.phone;

import com.muratkistan.model.User;
import com.muratkistan.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@RequiredArgsConstructor
public class UniquePhoneNumberValidator implements ConstraintValidator<UniquePhoneNumber,String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String  phoneNumber, ConstraintValidatorContext context) {

        User user = userRepository.findByPhoneNumber(phoneNumber);
        if(user != null) {
            return false;
        }

        return true;
    }

}
