package com.example.exception;

import com.example.common.ErrorCode;

public class NotFoundStoreRegistrationException extends CustomException{
    public NotFoundStoreRegistrationException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public NotFoundStoreRegistrationException(ErrorCode errorCode) {
        super(errorCode);
    }
}
