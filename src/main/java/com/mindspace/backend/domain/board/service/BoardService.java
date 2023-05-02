package com.mindspace.backend.domain.board.service;

import com.mindspace.backend.domain.board.dto.BoardMapper;
import com.mindspace.backend.domain.board.entity.Board;
import com.mindspace.backend.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository BOARD_REPOSITORY;
    private final BoardMapper BOARD_MAPPER;

    public List<Board> getAllBoard(){
        return BOARD_REPOSITORY.findAll();
    }
}
