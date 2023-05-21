package com.mindspace.backend.global.exception.commonClass;

import com.mindspace.backend.global.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RequestNotFoundException extends RuntimeException {
  private int statusCode;

  private String message;

  public RequestNotFoundException(ErrorCode statusCodes,String message) {
    super(message);
    this.statusCode = statusCodes.getStatusCode();
    this.message = message;
  }
}
