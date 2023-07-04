package com.mindspace.backend.domain.board.repository;

import com.mindspace.backend.domain.board.entity.Board;
import com.mindspace.backend.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findOneBoardByNodeIdAndUserId(int nodeId, int userId);

    Board findByNodeIdAndUserId(int nodeId, int userId);

    List<Board> findByNodeId(int nodeId);
}
