package com.mindspace.backend.domain.node.repository;

import com.mindspace.backend.domain.node.entity.Node;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepository extends JpaRepository<Node, Integer> {
}
