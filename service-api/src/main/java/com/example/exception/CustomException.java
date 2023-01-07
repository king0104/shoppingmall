package com.example.exception;

import com.example.common.ErrorCode;
import lombok.Getter;


@Getter
public class CustomException extends RuntimeException {
    private ErrorCode errorCode;

    // 1. 메세지, 에러코드 같이 넘겨줌
    public CustomException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    // 2. 에러코드만 넘겨줌
    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}

/**
 * 커스텀 익셉션 만들기
 * 1. message 담아주면 해당 메세지로 넣기
 * 2. message 안담아주면(errorCode만 있으면) errorCode.getMessage로 메세지 출력
 */