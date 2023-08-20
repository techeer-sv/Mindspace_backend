package com.mindspace.backend.domain.node.repository;

import com.mindspace.backend.domain.node.entity.Node;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NodeRepository extends JpaRepository<Node, Integer> {
    boolean existsById(int id);
    Optional<Node> findById(int id);
}
