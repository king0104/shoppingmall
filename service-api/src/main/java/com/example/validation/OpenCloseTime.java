package com.example.validation;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = OpenCloseTimeValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface OpenCloseTime {
    String message() default "open time은 close time 이전이여야 합니다.";
    String openTime();
    String closeTime();

    Class[] groups() default {};
    Class[] payload() default {};
}
