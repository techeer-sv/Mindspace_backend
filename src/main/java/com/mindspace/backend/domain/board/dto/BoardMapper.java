package com.mindspace.backend.domain.board.dto;

import com.mindspace.backend.domain.board.entity.Board;
import com.mindspace.backend.domain.node.entity.Node;
import com.mindspace.backend.domain.node.repository.NodeRepository;
import com.mindspace.backend.domain.user.entity.User;
import com.mindspace.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BoardMapper {
    private final UserRepository USER_REPOSITORY;
    private final NodeRepository NODE_REPOSITORY;

    public Board DtoToEntity(BoardRequestDto boardRequestDto) {
        User user = USER_REPOSITORY.findById(boardRequestDto.getUserId()).orElseThrow(NullPointerException::new);
        Node node = NODE_REPOSITORY.findById(boardRequestDto.getNodeId()).orElseThrow(NullPointerException::new);

        return Board.builder()
                .title(boardRequestDto.getTitle())
                .content(boardRequestDto.getContent())
                .user(user)
                .node(node)
                .build();
    }


    public BoardResponseDto DtoFromEntity(Board board) {
        return BoardResponseDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .userNickname(board.getUser().getNickname())
                .updatedAt(board.getUpdatedAt())
                .build();
    }

    public UserBoardResponseDto UserDtoFromEntity(Board board) {
        return UserBoardResponseDto.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .updatedAt(board.getUpdatedAt())
                .build();
    }

    public AllBoardResponseDto AllDtoFromEntity(Board board) {
        return AllBoardResponseDto.builder()
                .id(board.getId())
                .userNickname(board.getUser().getNickname())
                .title(board.getTitle())
                .updatedAt(board.getUpdatedAt())
                .build();
    }

    public List<BoardResponseDto> DtoListFromEntity(List<Board> boardList) {
        return boardList.stream()
                .map(this::DtoFromEntity)
                .collect(Collectors.toList());
    }
}
