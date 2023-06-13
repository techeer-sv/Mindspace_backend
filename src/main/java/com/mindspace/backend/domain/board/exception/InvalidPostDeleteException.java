package com.mindspace.backend.domain.board.exception;

import com.mindspace.backend.global.exception.ErrorCode;
import com.mindspace.backend.global.exception.common.CustomException;

public class InvalidPostDeleteException extends CustomException {

    public InvalidPostDeleteException() {
        super(ErrorCode.INVALID_POST_DELETE);
    }
}
