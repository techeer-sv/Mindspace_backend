package com.mindspace.backend.domain.board.service;

import com.mindspace.backend.domain.board.dto.BoardMapper;
import com.mindspace.backend.domain.board.dto.BoardRequestDto;
import com.mindspace.backend.domain.board.entity.Board;
import com.mindspace.backend.domain.board.repository.BoardRepository;
import com.mindspace.backend.domain.user.entity.User;
import com.mindspace.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final UserRepository USER_REPOSITORY;
    private final BoardRepository BOARD_REPOSITORY;
    private final BoardMapper BOARD_MAPPER;

    @Transactional
    public List<Board> getAllBoard(){
        return BOARD_REPOSITORY.findAll();
    }

    @Transactional
    public List<Board> getBoardByNodeId(int nodeId) {
        return BOARD_REPOSITORY.findByNodeId(nodeId);
    }

    @Transactional
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

    @Transactional
    public void deleteBoard(int userId, Integer nodeId) {
        Board board = findByNodeIdAndUserId(userId, nodeId);
        BOARD_REPOSITORY.deleteById(board.getId());
    }

    public Board findByNodeIdAndUserId(int nodeId, int userId) {
        List<Board> boards = BOARD_REPOSITORY.findByNodeIdAndUserId(nodeId, userId);
        if (boards.isEmpty()) {
            throw new RuntimeException("Board not found");
        }
        return boards.get(0);
    }

    @Transactional
    public Board updateBoard(BoardRequestDto boardUpdate, int nodeId, int userId) {
        Board board = findByNodeIdAndUserId(nodeId, userId);
        board.update(boardUpdate);
        return BOARD_REPOSITORY.save(board);
    }

    public Board findOneBoard(int id) {
        return BOARD_REPOSITORY.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public Board findOneBoardByNodeIdAndUserId(int nodeId, int userId) {
        User user = USER_REPOSITORY.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }
        List<Board> boards = BOARD_REPOSITORY.findOneBoardByNodeIdAndUserId(nodeId, userId);
        if (boards.isEmpty()) {
            return null;
        }
        return boards.get(0);
    }
}