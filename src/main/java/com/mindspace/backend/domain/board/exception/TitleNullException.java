package com.mindspace.backend.domain.board.exception;

import com.mindspace.backend.global.exception.ErrorCode;
import com.mindspace.backend.global.exception.common.CustomException;

public class TitleNullException extends CustomException {

    public TitleNullException() {
        super(ErrorCode.TITLE_NULL);
    }
}
