package com.mindspace.backend.global.exception;

// 3. status code와 message를 담는 클래스
public class ErrorResponse {
    private final int statusCode;
    private final String message;

    public ErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
