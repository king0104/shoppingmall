package com.example.exception;

import com.example.common.ErrorCode;

public class ValidationException extends CustomException {

    public ValidationException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public ValidationException(ErrorCode errorCode) {
        super(errorCode);
    }
}
