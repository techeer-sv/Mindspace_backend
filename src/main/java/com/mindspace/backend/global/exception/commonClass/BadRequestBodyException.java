package com.mindspace.backend.global.exception.commonClass;

import com.mindspace.backend.global.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestBodyException extends RuntimeException {
  private int errorCode;

  public BadRequestBodyException(String message, ErrorCode statusCodes) {
    super(message);
    this.errorCode = statusCodes.getStatusCode();
  }
}
