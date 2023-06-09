package com.mindspace.backend.domain.board.dto;

import com.mindspace.backend.domain.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class BoardResponseDto {

    private int id;

    private String userNickname;

    private String title;

    private String content;

    private LocalDateTime updatedAt;

}
