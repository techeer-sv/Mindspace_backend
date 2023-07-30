package com.mindspace.backend.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // Global
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "G001", "서버 오류"),
    INPUT_INVALID_VALUE(HttpStatus.BAD_REQUEST, "G002", "잘못된 입력"),

    // User
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "U001","해당 유저를 찾을 수 없습니다."),
    USER_INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "U002","비밀번호를 다시 확인해주세요."),
    USER_NICKNAME_DUPLICATED(HttpStatus.CONFLICT, "U003", "해당 nickname는 사용 중입니다." ),
    USER_EMAIL_DUPLICATED(HttpStatus.CONFLICT, "U004", "이미 해당 Email로 회원가입했습니다." ),
    USER_LOGIN_REQUIRED(HttpStatus.UNAUTHORIZED,"U005","로그인이 필요합니다."),

    // BOARD
    BOARD_NOT_FOUND(HttpStatus.NOT_FOUND, "B001", "해당 게시글을 찾을 수 없습니다."),
    TITLE_NULL(HttpStatus.BAD_REQUEST, "B002", "제목을 입력해주세요."),
    CONTENT_NULL(HttpStatus.BAD_REQUEST, "B003", "내용을 입력해주세요."),
    NODE_ALREADY_WRITTEN(HttpStatus.CONFLICT, "B004", "이미 작성된 노드에 대한 작성 요청입니다."),
    INVALID_POST_DELETE(HttpStatus.NOT_FOUND, "B005", "삭제할 수 없는 글이거나 이미 삭제된 글입니다."),

    // Node
    NODE_NOT_FOUND(HttpStatus.NOT_FOUND, "N001", "해당 노드를 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
