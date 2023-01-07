package com.example.exception.handler;

import com.example.ApiResponse;
import com.example.ValidationErrorData;
import com.example.common.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    // validation annotation 조건에 걸렸을 경우 발생하는 exception
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ApiResponse handleConstraintViolationException(ConstraintViolationException ex) {
        log.error("exception = {}, {}", ex.getMessage(), ex.getClass());

        return ApiResponse.builder()
                .success(false)
                .data(ErrorCode.INVALID_INPUT_VALUE.getMessage())
                .errorCode(ErrorCode.INVALID_INPUT_VALUE.getCode())
                .build();
    }

    // 값이 들어왔는데, 타입이 일치하지 않는 경우에 대한 Exception
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ApiResponse handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        log.error("exception = {}, {}", ex.getMessage(), ex.getClass());

        return ApiResponse.builder()
                .success(false)
                .data(ErrorCode.INVALID_INPUT_VALUE.getMessage())
                .errorCode(ErrorCode.INVALID_INPUT_VALUE.getCode())
                .build();
    }

    // 값이 들어와야하는데 아예 들어오지 않은 경우 Exception - 근데 이건 왜 유효성 검사를 안타냐? notnull에서 걸러져야 하는거 아님?
    // NotNull
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ApiResponse handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
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
