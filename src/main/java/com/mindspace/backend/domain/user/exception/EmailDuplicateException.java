package com.mindspace.backend.domain.user.exception;

import com.mindspace.backend.global.exception.ErrorCode;
import com.mindspace.backend.global.exception.common.CustomException;

public class EmailDuplicateException extends CustomException {

public EmailDuplicateException() {
    super(ErrorCode.USER_EMAIL_DUPLICATED);
}
}

