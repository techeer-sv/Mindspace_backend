package com.mindspace.backend.domain.board.exception;

import com.mindspace.backend.global.exception.ErrorCode;
import com.mindspace.backend.global.exception.common.CustomException;

public class ContentNullException extends CustomException {

    public ContentNullException() {
        super(ErrorCode.CONTENT_NULL);
    }
}
