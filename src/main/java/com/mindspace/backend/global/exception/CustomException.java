package com.mindspace.backend.global.exception;

import org.springframework.http.HttpStatus;

// 1. 예외 클래스 정의
public class CustomException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String message;

    public CustomException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
