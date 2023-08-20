package com.mindspace.backend.domain.board.exception;

import com.mindspace.backend.global.exception.ErrorCode;
import com.mindspace.backend.global.exception.common.CustomException;

public class NodeNotFoundException extends CustomException {

    public NodeNotFoundException() {
        super(ErrorCode.NODE_NOT_FOUND);
    }
}
