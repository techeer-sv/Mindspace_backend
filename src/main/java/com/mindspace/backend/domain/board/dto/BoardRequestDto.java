package com.mindspace.backend.domain.board.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardRequestDto {

    @NotNull
    private String boardname;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private int userId;

    @NotNull
    private int nodeId;
}
