package com.mindspace.backend.domain.board.exception;

import com.mindspace.backend.global.exception.ErrorCode;
import com.mindspace.backend.global.exception.common.CustomException;

public class NodeAlreadyWrittenException extends CustomException {

    public NodeAlreadyWrittenException() {
        super(ErrorCode.NODE_ALREADY_WRITTEN);
    }
}
