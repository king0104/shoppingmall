package com.example.validation;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 해당 필드로 "Y", "N", null 값만 허용한다!!
 */
@Slf4j
public class IsDeletedValidator implements ConstraintValidator<IsDeletedConstraint, String> {


    @Override
    public void initialize(IsDeletedConstraint constraintAnnotation) {
        log.info("init 값은? = {}", constraintAnnotation);

    }

    @Override
    public boolean isValid(String isDeleted, ConstraintValidatorContext context) {
        return StringUtils.isBlank(isDeleted) || "Y".equals(isDeleted) || "N".equals(isDeleted); // NPE 방지.

    }
}
