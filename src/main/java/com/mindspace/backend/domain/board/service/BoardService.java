package com.mindspace.backend.domain.board.service;

import com.mindspace.backend.domain.board.dto.BoardMapper;
import com.mindspace.backend.domain.board.dto.BoardRequestDto;
import com.mindspace.backend.domain.board.dto.BoardResponseDto;
import com.mindspace.backend.domain.board.entity.Board;
import com.mindspace.backend.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository BOARD_REPOSITORY;
    private final BoardMapper BOARD_MAPPER;

    public List<Board> getAllBoard(){
        return BOARD_REPOSITORY.findAll();
    }

    public Board createBoard(BoardRequestDto boardRequestDto, int userId, Integer nodeId) {
        nodeId = nodeId != null ? nodeId : DEFAULT_NODE_ID;
        BoardRequestDto updatedDto = BoardRequestDto.builder()
                .title(boardRequestDto.getTitle())
                .content(boardRequestDto.getContent())
                .userId(userId)
                .nodeId(nodeId)
                .build();

        return BOARD_REPOSITORY.save(BOARD_MAPPER.DtoToEntity(updatedDto));
    }

    private static final int DEFAULT_NODE_ID = 1;

    public void deleteBoard(int id) {
        Board board = IsBoardExisted(id);
        BOARD_REPOSITORY.deleteById(board.getId());
    }

    public Board IsBoardExisted(int id){
        Board foundBaord = BOARD_REPOSITORY.findById(id).orElseThrow(NullPointerException::new);
        return foundBaord;
    }

    public Board updateBoard(BoardRequestDto boardUpdate, int id) {
        Board board = IsBoardExisted(id);
        board.update(boardUpdate);
        return BOARD_REPOSITORY.save(board);
    }

    public Board findOneBoard(int id) {
        return BOARD_REPOSITORY.findById(id).orElseThrow(RuntimeException::new);
    }
}