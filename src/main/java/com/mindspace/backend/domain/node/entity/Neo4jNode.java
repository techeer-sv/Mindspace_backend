package com.mindspace.backend.domain.node.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node
public class Neo4jNode {

    @Id
    private Long id;

    // 관계를 나타내는 경우 사용하는 어노테이션
    @Relationship(type = "LINKS_TO", direction = Relationship.Direction.OUTGOING)
    private List<Link> links;

}