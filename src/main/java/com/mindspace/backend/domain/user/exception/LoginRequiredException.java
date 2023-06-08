package com.mindspace.backend.domain.user.exception;

import com.mindspace.backend.global.exception.ErrorCode;
import com.mindspace.backend.global.exception.common.CustomException;

public class LoginRequiredException extends CustomException {
    public LoginRequiredException() { super(ErrorCode.USER_LOGIN_REQUIRED); }
}