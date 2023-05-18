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

    public void setUserId(int userId) {
    }

    public static class BoardRequestDtoBuilder {
        public BoardRequestDtoBuilder userId(int userId) {
            this.userId = userId;
            return this;
        }
    }
//    public static class Builder {
//        private int userId;
//        // 다른 필드들...
//
//        public Builder userId(int userId) {
//            this.userId = userId;
//            return this;
//        }
//
//        // 다른 필드들의 빌더 메서드들...
//
//        public BoardRequestDto build() {
//            return new BoardRequestDto(this);
//        }
//    }
//
//    private BoardRequestDto(Builder builder) {
//        this.userId = builder.userId;
//        // 다른 필드들...
//    }
//
//    public static Builder builder() {
//        return new Builder();
//    }
}
