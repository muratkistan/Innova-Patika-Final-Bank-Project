package com.muratkistan.custom.annotations.identity;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {UniqueIdentityNumberValidator.class })
public @interface UniqueIdentityNumber {

    String message() default "User already exist. ";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
