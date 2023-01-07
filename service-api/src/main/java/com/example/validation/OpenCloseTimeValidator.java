package com.example.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalTime;

@Slf4j
public class OpenCloseTimeValidator implements ConstraintValidator<OpenCloseTime, Object> {

    private String openTime;
    private String closeTime;

    @Override
    public void initialize(OpenCloseTime constraintAnnotation) {
        this.openTime = constraintAnnotation.openTime();
        this.closeTime = constraintAnnotation.closeTime();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        LocalTime openTimeValue = (LocalTime)new BeanWrapperImpl(value)
                .getPropertyValue(openTime); // -- 객체를 생성하는게 성능적으로는 좋은게 아님
        LocalTime closeTimeValue = (LocalTime)new BeanWrapperImpl(value)
                .getPropertyValue(closeTime);

        // -- 한번만 생성해서 getPropertyValue
        // -- regex


        // -- 한줄로 해결
        if (openTimeValue.isBefore(closeTimeValue)) {
            return true;
        }
        return false;




    }
}
