package com.mindspace.backend.domain.link.entity;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.NodeEntity;
import javax.persistence.*;

@Getter
@NodeEntity
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "link_id")
    private int id;

    @Column(name="source", nullable = false)
    private String source;

    @Column(name="target", nullable = false)
    private String target;

}
