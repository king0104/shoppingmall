package com.example.exception;

import com.example.common.ErrorCode;
import lombok.Getter;

@Getter
public class DuplicatedStoreRegistrationException extends CustomException {

    public DuplicatedStoreRegistrationException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public DuplicatedStoreRegistrationException(ErrorCode errorCode) {
        super(errorCode);
    }
}
