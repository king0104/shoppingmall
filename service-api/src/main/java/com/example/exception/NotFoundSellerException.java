package com.example.exception;

import com.example.common.ErrorCode;


public class NotFoundSellerException extends CustomException {
    
    public NotFoundSellerException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public NotFoundSellerException(ErrorCode errorCode) {
        super(errorCode);
    }
}
