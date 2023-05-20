package com.mindspace.backend.domain.board.dto;

import com.mindspace.backend.domain.board.entity.Board;
import com.mindspace.backend.domain.node.entity.Node;
import com.mindspace.backend.domain.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class BoardMapper {
    public Board DtoToEntity(BoardRequestDto boardRequestDto) {
        return Board.builder()
                .title(boardRequestDto.getTitle())
                .content(boardRequestDto.getContent())
                .user(User.builder().id(boardRequestDto.getUserId()).build())
                .node(Node.builder().id(boardRequestDto.getNodeId()).build())
                .build();
    }


    public BoardResponseDto DtoFromEntity(Board board) {
        return BoardResponseDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .userId(board.getUser().getId())
                .nodeId(board.getId())
                .build();
    }
}
