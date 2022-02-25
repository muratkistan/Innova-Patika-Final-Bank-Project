package com.muratkistan.custom.annotations.phone;

import com.muratkistan.custom.annotations.identity.UniqueIdentityNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {UniquePhoneNumberValidator.class })
public @interface UniquePhoneNumber {

    String message() default "Phone number registered to other user!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
