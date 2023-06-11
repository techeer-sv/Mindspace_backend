package com.mindspace.backend.domain.user.exception;

import com.mindspace.backend.global.exception.ErrorCode;
import com.mindspace.backend.global.exception.common.CustomException;

public class NickNameDuplicateException extends CustomException {
    public NickNameDuplicateException() {
        super(ErrorCode.USER_NICKNAME_DUPLICATED);
    }
}
