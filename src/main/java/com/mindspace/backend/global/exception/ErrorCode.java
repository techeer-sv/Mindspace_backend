package com.mindspace.backend.global.exception;

public enum ErrorCode {
    BAD_REQUEST(400, "잘못된 요청입니다."),
    UNAUTHORIZED(401, "인증되지 않은 요청입니다."),
    FORBIDDEN(403, "접근 권한이 없습니다."),
    NOT_FOUND(404, "요청한 자원을 찾을 수 없습니다."),
    CONFLICT(409, "이미 존재하는 데이터입니다.");

    private final int statusCode;
    private final String message;

    ErrorCode(int statusCode, String message) {
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
