package com.mindspace.backend.global.exception.common;

import com.mindspace.backend.global.exception.ErrorCode;
import lombok.Getter;

import java.util.NoSuchElementException;

@Getter
public class RequestNotFoundException extends NoSuchElementException {
  private final ErrorCode errorCode;

  public RequestNotFoundException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }
}
