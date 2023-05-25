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
    private int userId; // int 타입의 필드는 기본적으로 null이 아닌 값을 가지므로 @NotNull 어노테이션은 필요하지 않음

    private int nodeId;

//    public void setUserId(int userId){
//    }

//    public void setNodeId(int nodeId) {
//        this.nodeId = nodeId;
//    }

    public static class BoardRequestDtoBuilder {
        public BoardRequestDtoBuilder userId(int userId) {
            this.userId = userId;
            return this;
        }
    }
}
