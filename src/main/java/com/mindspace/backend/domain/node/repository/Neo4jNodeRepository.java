package com.mindspace.backend.domain.node.repository;

import com.mindspace.backend.domain.node.entity.Link;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import com.mindspace.backend.domain.node.entity.Neo4jNode;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface Neo4jNodeRepository extends Neo4jRepository<Neo4jNode, Long> {
    // 시작 노드와 종료 노드의 ID 값을 반환
    @Query("MATCH (n1)-[r]->(n2) RETURN id(n1) as source, id(n2) as target")
    List<Link> findAllLinks();
}
