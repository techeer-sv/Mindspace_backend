package com.mindspace.backend.global.exception.commonClass;

import com.mindspace.backend.global.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RequestNotFoundException extends RuntimeException {
  private int errorCode;

  public RequestNotFoundException(String message, ErrorCode statusCodes) {
    super(message);
    this.errorCode = statusCodes.getStatusCode();
  }
}
