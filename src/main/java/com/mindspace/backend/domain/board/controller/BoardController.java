package com.mindspace.backend.domain.board.controller;

import com.mindspace.backend.domain.board.dto.*;
import com.mindspace.backend.domain.board.entity.Board;
import com.mindspace.backend.domain.board.service.BoardService;
import com.mindspace.backend.domain.node.entity.Node;
import com.mindspace.backend.domain.node.repository.NodeRepository;
import com.mindspace.backend.domain.user.entity.User;
import com.mindspace.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards")
public class BoardController {
    private final NodeRepository NODE_REPOSITORY;
    private final BoardService BOARD_SERVICE;
    private final BoardMapper BOARD_MAPPER;
    private final UserRepository USER_REPOSITORY;

    // 전체 게시글 조회
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<AllBoardResponseDto> getAllBoard(@RequestParam(value = "node_id", required = false) Integer nodeId){
        List<Board> boardlist = BOARD_SERVICE.getAllBoard();
        List<AllBoardResponseDto> boardResponseList = new ArrayList<>();

        for (Board board : boardlist) {
            AllBoardResponseDto allBoardResponseDto = BOARD_MAPPER.AllDtoFromEntity(board);
            boardResponseList.add(allBoardResponseDto);
        }
        return boardResponseList;
    }

    //“사용자”가 특정 노드 게시물 조회
    @GetMapping
    public ResponseEntity<UserBoardResponseDto> findOneBoardByNodeIdAndUserId(@RequestHeader("Authorization") int userId, @RequestParam(value = "node_id", required = false) Integer nodeId) {
        User user = USER_REPOSITORY.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Board board = BOARD_SERVICE.findOneBoardByNodeIdAndUserId(nodeId, userId);
        if (board == null) {
            return ResponseEntity.notFound().build();
        }
        UserBoardResponseDto userBoardResponseDto = BOARD_MAPPER.UserDtoFromEntity(board);
        return ResponseEntity.ok(userBoardResponseDto);
    }

    // “다른 사람”의 특정 노드 게시물 조회
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BoardResponseDto findOneBoard(@PathVariable int id){
        Board board = BOARD_SERVICE.findOneBoard(id);
        return BOARD_MAPPER.DtoFromEntity(board);
    }

    // 게시글 작성
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto boardRequestDto, @RequestHeader("Authorization") int userId, @RequestParam(value = "node_id", required = false) Integer nodeId) {
        if (nodeId == null) {
            throw new IllegalArgumentException("node_id is required");
        }

        Node node = NODE_REPOSITORY.findById(nodeId).orElse(null);
        if (node == null) {
            throw new IllegalArgumentException("Invalid node_id: " + nodeId);
        }

        Board createResult = BOARD_SERVICE.createBoard(boardRequestDto, userId, nodeId);
        return BOARD_MAPPER.DtoFromEntity(createResult);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBoard(@PathVariable int id) {
        BOARD_SERVICE.deleteBoard(id);
    }

    // 게시글 수정
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BoardResponseDto> updateBoard(
            @Valid @RequestBody BoardRequestDto boardUpdate, @PathVariable int id){
        Board updateBoard = BOARD_SERVICE.updateBoard(boardUpdate, id);
        return new ResponseEntity<>(BOARD_MAPPER.DtoFromEntity(updateBoard), HttpStatus.OK);
    }
}
