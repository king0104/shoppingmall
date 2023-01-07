package com.example.exception;

import com.example.common.ErrorCode;

public class NotFoundStoreException extends CustomException{
    public NotFoundStoreException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public NotFoundStoreException(ErrorCode errorCode) {
        super(errorCode);
    }
}
