package com.mindspace.backend.global.exception;

import com.mindspace.backend.global.exception.CustomException;
import com.mindspace.backend.global.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 2. @RestControllerAdvice를 사용하여 예외 처리를 한 후, ExceptionHandler를 정의하여 예외를 처리
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//    @ExceptionHandler(CustomException.class)
//    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
//        ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(), ex.getMessage());
//        errorResponse.setMessage(ex.getMessage());
//        return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
//        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(), ex.getMessage());
        errorResponse.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}