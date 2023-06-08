package com.mindspace.backend.global.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {
    private String errorCode;
    private String errorMessage;

    private ErrorResponse(ErrorCode code) {
        this.errorCode = code.getCode();
        this.errorMessage = code.getMessage();
    }
}