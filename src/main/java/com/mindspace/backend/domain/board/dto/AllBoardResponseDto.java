package com.mindspace.backend.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class AllBoardResponseDto {

    private int id;

    private String userNickname;

    private String title;

    private LocalDateTime updatedAt;

}
