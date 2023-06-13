package com.mindspace.backend.domain.board.exception;

import com.mindspace.backend.global.exception.ErrorCode;
import com.mindspace.backend.global.exception.common.CustomException;

public class BoardNotFoundException extends CustomException {

    public BoardNotFoundException() {
        super(ErrorCode.BOARD_NOT_FOUND);
    }
}
