package com.example.exception.handler;

import com.example.ApiResponse;
import com.example.common.ErrorCode;
import com.example.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ApiResponse handleCustomException(CustomException ex) {
        log.error("exception = {}, {}", ex.getMessage(), ex.getClass());

        return ApiResponse.builder()
                .success(false)
                .data(ex.getMessage())
                .errorCode(ex.getErrorCode().getCode())
                .build();
    }

    // [deserializeException(jackson)]
    // - http body -> 컨트롤러에 들어오는 객체 역직렬화에서 에러
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ApiResponse handleDeserializeException(HttpMessageNotReadableException ex) throws IOException {
        log.error("exception = {}, {}", ex.getMessage(), ex.getClass());

        return ApiResponse.builder()
                .success(false)
                .data(ErrorCode.INVALID_INPUT_JSON_VALUE.getMessage())
                .errorCode(ErrorCode.INVALID_INPUT_JSON_VALUE.getCode())
                .build();
    }

    // [validationException]
    // - validationErrorData 객체에 default message, rejectedvalue 담음
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ApiResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("exception = {}, {}", ex.getMessage(), ex.getClass());

        return ApiResponse.builder()
                .success(false)
                .data(ErrorCode.INVALID_INPUT_VALUE.getMessage())
                .errorCode(ErrorCode.INVALID_INPUT_VALUE.getCode())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ApiResponse handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("exception = {}, {}", ex.getMessage(), ex.getClass());

        return ApiResponse.builder()
                .success(false)
                .data(ex.getMessage())
                .errorCode("") // 여기에 들어갈 값은..?
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ApiResponse handleIllegalStateException(IllegalStateException ex) {
        log.error("exception = {}, {}", ex.getMessage(), ex.getClass());

        return ApiResponse.builder()
                .success(false)
                .data(ex.getMessage())
                .errorCode("") // 여기에 들어갈 값은..?
                .build();
    }

}
