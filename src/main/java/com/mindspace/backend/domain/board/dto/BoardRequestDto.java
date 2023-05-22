package com.mindspace.backend.domain.board.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Builder
public class BoardRequestDto {


    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private int userId;

    @NotNull
    private int nodeId;

    public static class BoardRequestDtoBuilder {
        public BoardRequestDtoBuilder userId(int userId) {
            this.userId = userId;
            return this;
        }
    }
}
