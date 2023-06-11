package com.mindspace.backend.global.exception;

import com.mindspace.backend.global.exception.common.CustomException;
import com.mindspace.backend.global.exception.common.RequestNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleRuntimeException(CustomException e) {
        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response =
                ErrorResponse.builder()
                        .errorMessage(errorCode.getMessage())
                        .errorCode(errorCode.getCode())
                        .build();
        log.warn(e.getMessage());
        return ResponseEntity.status(errorCode.getStatus()).body(response);
    }

    @ExceptionHandler(RequestNotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleNotFoundException(RequestNotFoundException e) {
        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response = makeErrorResponse(errorCode);
        log.warn(e.getMessage());
        return new ResponseEntity<>(response, errorCode.getStatus());
    }

    private ErrorResponse makeErrorResponse(ErrorCode errorCode) {
        return ErrorResponse.builder()
                .errorMessage(errorCode.getMessage())
                .errorCode(errorCode.getCode())
                .build();
    }
}