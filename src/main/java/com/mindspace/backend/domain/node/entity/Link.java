package com.mindspace.backend.domain.node.entity;

import org.neo4j.ogm.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RelationshipEntity(type = "LINKS_TO")
public class Link {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name="source")
    private Long source;

    @Property(name="target")
    private Long target;
}

