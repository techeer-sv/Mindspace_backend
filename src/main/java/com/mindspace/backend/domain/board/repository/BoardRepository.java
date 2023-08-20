package com.mindspace.backend.domain.board.repository;

import com.mindspace.backend.domain.board.entity.Board;
import com.mindspace.backend.domain.node.entity.Node;
import com.mindspace.backend.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;


public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findOneBoardByNodeIdAndUserId(int nodeId, int userId);

    Board findByNodeIdAndUserId(int nodeId, int userId);

    @Query("SELECT new map(n.id AS id, CASE WHEN b.id IS NULL THEN false ELSE true END AS isWritten ,n.name AS name) " +
            "FROM Node n " +
            "LEFT JOIN Board b " +
            "ON n = b.node " +
            "AND b.user.id = :userId")
    List<Map<String, Object>> getNodeListWithWriteStatus(@Param("userId") int userId);

    List<Board> findByNode(Node node);

}