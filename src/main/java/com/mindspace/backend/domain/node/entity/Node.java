package com.mindspace.backend.domain.node.entity;

import com.mindspace.backend.domain.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "node")
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "node_id")
    private int id;

    @Column(name= "node_name", nullable = false)
    private String name;

//    @OneToMany(mappedBy = "node")
//    private List<Board> boards;
}