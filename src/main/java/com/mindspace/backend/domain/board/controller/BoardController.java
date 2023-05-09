package com.mindspace.backend.domain.board.controller;

import com.mindspace.backend.domain.board.dto.BoardMapper;
import com.mindspace.backend.domain.board.dto.BoardRequestDto;
import com.mindspace.backend.domain.board.dto.BoardResponseDto;
import com.mindspace.backend.domain.board.entity.Board;
import com.mindspace.backend.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public List<Board> getAllBoard(){
        return BOARD_SERVICE.getAllBoard();
    }

    /*
    // 노드 글 정보 조회
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  List<Board>{
        return;
    }
    */

    // 게시글 작성
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public BoardResponseDto createBoard(
            @RequestBody BoardRequestDto boardRequestDto) {
        Board createResult = BOARD_SERVICE.createBoard(boardRequestDto);
        return BOARD_MAPPER.DtoFromEntity(createResult);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBoard(@PathVariable int id) {
        BOARD_SERVICE.deleteBoard(id);
    }

}
