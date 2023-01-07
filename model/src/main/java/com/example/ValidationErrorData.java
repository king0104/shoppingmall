package com.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidationErrorData<T> {
    private String field;
    private String defaultMessage;
    private T rejectedValue;
}
