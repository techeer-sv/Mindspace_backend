package com.mindspace.backend.domain.board.dto;

import com.mindspace.backend.domain.board.entity.Board;
import org.springframework.stereotype.Component;

@Component
public class BoardMapper {
    public Board DtoToEntity(BoardRequestDto boardRequestDto) {
        return Board.builder()
                .boardName(boardRequestDto.getBoardname())
                .title(boardRequestDto.getTitle())
                .content(boardRequestDto.getContent())
                .userId(boardRequestDto.getUserId())
                .nodeId(boardRequestDto.getNodeId())
                .build();
    }

    public BoardResponseDto DtoFromEntity(Board board) {
        return BoardResponseDto.builder()
                .id(board.getId())
                .boardName(board.getBoardName())
                .title(board.getTitle())
                .content(board.getContent())
                .userId(board.getUserId())
                .nodeId(board.getNodeId())
                .build();
    }
}
