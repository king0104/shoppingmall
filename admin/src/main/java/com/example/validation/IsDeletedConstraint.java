package com.example.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IsDeletedValidator.class)
@Target( { ElementType.TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsDeletedConstraint {
    String message() default "isDeleted field must be 'Y' or 'N' or nothing";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
