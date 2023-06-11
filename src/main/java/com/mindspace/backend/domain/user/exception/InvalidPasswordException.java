package com.mindspace.backend.domain.user.exception;

import com.mindspace.backend.global.exception.common.CustomException;
import com.mindspace.backend.global.exception.ErrorCode;

public class InvalidPasswordException extends CustomException {

    public InvalidPasswordException() {
        super(ErrorCode.USER_INVALID_PASSWORD);
    }
}
