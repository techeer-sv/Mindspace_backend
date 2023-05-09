package com.mindspace.backend.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BoardResponseDto {

    private int id;

    private String title;

    private String content;

    private int userId;

    private int nodeId;
}
