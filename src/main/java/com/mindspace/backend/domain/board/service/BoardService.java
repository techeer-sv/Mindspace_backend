package com.mindspace.backend.domain.board.service;

import com.mindspace.backend.domain.board.dto.BoardMapper;
import com.mindspace.backend.domain.board.dto.BoardRequestDto;
import com.mindspace.backend.domain.board.entity.Board;
import com.mindspace.backend.domain.board.exception.*;
import com.mindspace.backend.domain.board.repository.BoardRepository;
import com.mindspace.backend.domain.node.entity.Node;
import com.mindspace.backend.domain.node.repository.NodeRepository;
import com.mindspace.backend.domain.user.entity.User;
import com.mindspace.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final NodeRepository NODE_REPOSITORY;
    private final UserRepository USER_REPOSITORY;
    private final BoardRepository BOARD_REPOSITORY;
    private final BoardMapper BOARD_MAPPER;

    @Transactional
    public List<Board> getAllBoard(int nodeId) {
        Node node = NODE_REPOSITORY.findById(nodeId).orElseThrow(() -> new NodeNotFoundException());
        List<Board> boards = BOARD_REPOSITORY.findByNode(node);
        return boards;
    }


    @Transactional
    public Board createBoard(BoardRequestDto boardRequestDto, int userId, Integer nodeId) {
        nodeId = nodeId != null ? nodeId : DEFAULT_NODE_ID;

        // 노드가 데이터베이스에 존재하는지 확인
        Node node = NODE_REPOSITORY.findById(nodeId).orElseThrow(() -> new NodeNotFoundException());

        boolean boardExists = BOARD_REPOSITORY.findByNodeIdAndUserId(nodeId, userId) != null;
        if (boardExists) {
            throw new NodeAlreadyWrittenException();
        }

        if (boardRequestDto.getTitle() == null || boardRequestDto.getTitle().isEmpty()) {
            throw new TitleNullException();
        }

        if (boardRequestDto.getContent() == null || boardRequestDto.getContent().isEmpty()) {
            throw new ContentNullException();
        }

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
        Board board = findByNodeIdAndUserId(nodeId, userId);

        if (board == null) {
            throw new InvalidPostDeleteException();
        }

        BOARD_REPOSITORY.deleteById(board.getId());
    }

    public Board findByNodeIdAndUserId(int nodeId, int userId) {
        Board boards = BOARD_REPOSITORY.findByNodeIdAndUserId(nodeId, userId);
        return boards;
    }


    @Transactional
    public Board updateBoard(BoardRequestDto boardUpdate,int userId, int nodeId) {
        Board board = findByNodeIdAndUserId(nodeId, userId);

        if (boardUpdate.getTitle() == null || boardUpdate.getTitle().isEmpty()) {
            throw new TitleNullException();
        }

        if (boardUpdate.getContent() == null || boardUpdate.getContent().isEmpty()) {
            throw new ContentNullException();
        }

        board.update(boardUpdate);
        return BOARD_REPOSITORY.save(board);
    }


    public Board findOneBoard(int id) {
        return BOARD_REPOSITORY.findById(id).orElseThrow(BoardNotFoundException::new);
    }


    @Transactional
    public Board findOneBoardByNodeIdAndUserId(int nodeId, int userId) {
        User user = USER_REPOSITORY.findById(userId).orElse(null);
        if (user == null) {
            throw new BoardNotFoundException();
        }
        List<Board> boards = BOARD_REPOSITORY.findOneBoardByNodeIdAndUserId(nodeId, userId);
        if (boards.isEmpty()) {
            throw new BoardNotFoundException();
        }
        return boards.get(0);
    }

}