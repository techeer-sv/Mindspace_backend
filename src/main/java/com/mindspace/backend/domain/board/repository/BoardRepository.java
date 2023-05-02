package com.mindspace.backend.domain.board.repository;

import com.mindspace.backend.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
