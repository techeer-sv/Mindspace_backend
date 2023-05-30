package com.mindspace.backend.domain.board.repository;

import com.mindspace.backend.domain.board.entity.Board;
import com.mindspace.backend.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    Board findByNodeIdAndUserId(int nodeId, int userId);
}
