package com.mindspace.backend.domain.board.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class BoardRequestDto {


    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private int userId;

    private int nodeId;

    public static class BoardRequestDtoBuilder {
        public BoardRequestDtoBuilder userId(int userId) {
            this.userId = userId;
            return this;
        }
    }
}
