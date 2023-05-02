package com.mindspace.backend.domain.board.controller;

import com.mindspace.backend.domain.board.dto.BoardMapper;
import com.mindspace.backend.domain.board.entity.Board;
import com.mindspace.backend.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards")
public class BoardController {
    private final BoardService BOARD_SERVICE;
    private final BoardMapper BOARD_MAPPER;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Board> getAllBoard(){
        return BOARD_SERVICE.getAllBoard();
    }
}
