package com.mindspace.backend.global.exception;

import lombok.Getter;

// 3. status code와 message를 담는 클래스
@Getter
public class ErrorResponse {
    private final int statusCode;
    private String message; //service단에서 각 예외에 맞게 변형될 수 있기 때문

    public ErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
