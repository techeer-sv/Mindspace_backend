package com.mindspace.backend.domain.node.entity;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "LINKS_TO")
public class Link {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Neo4jNode startNode;

    @EndNode
    private Neo4jNode endNode;

}
