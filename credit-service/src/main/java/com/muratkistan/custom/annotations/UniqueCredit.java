package com.muratkistan.custom.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = { UniqueCreditValidator.class})
public @interface UniqueCredit {

    String message() default "You have already a credit apply ";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
