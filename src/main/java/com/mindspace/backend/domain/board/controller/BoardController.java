package com.mindspace.backend.domain.board.controller;

import com.mindspace.backend.domain.board.dto.BoardMapper;
import com.mindspace.backend.domain.board.dto.BoardRequestDto;
import com.mindspace.backend.domain.board.dto.BoardResponseDto;
import com.mindspace.backend.domain.board.entity.Board;
import com.mindspace.backend.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
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
    private final BoardService BOARD_SERVICE;
    private final BoardMapper BOARD_MAPPER;

    // 전체 게시글 조회
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<BoardResponseDto> getAllBoard(){
        List<Board> boardlist = BOARD_SERVICE.getAllBoard();
        List<BoardResponseDto> boardResponseList = new ArrayList<>();

        for (Board board : boardlist) {
            BoardResponseDto boardResponseDto = BOARD_MAPPER.DtoFromEntity(board);
            boardResponseList.add(boardResponseDto);
        }

        return boardResponseList;
    }

    // 게시글 조회
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
        nodeId = nodeId != null ? nodeId : DEFAULT_NODE_ID;
        Board createResult = BOARD_SERVICE.createBoard(boardRequestDto, userId, nodeId);
        return BOARD_MAPPER.DtoFromEntity(createResult);
    }

    private static final int DEFAULT_NODE_ID = 1;

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
