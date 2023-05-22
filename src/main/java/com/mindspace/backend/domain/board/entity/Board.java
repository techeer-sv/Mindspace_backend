package com.mindspace.backend.domain.board.entity;

import com.mindspace.backend.domain.board.dto.BoardRequestDto;
import com.mindspace.backend.global.common.Timestamp;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name="board")
@Builder
@AllArgsConstructor
public class Board extends Timestamp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_id")
    private int id;
    @Column(name="title", nullable = false)
    private String title;
    @Column(name="content", nullable = false)
    private String content;
    @Column(name="user_id", nullable = false)
    private int userId;
    @Column(name="node_id", nullable = false)
    private int nodeId;

    public static void delete() {
    }

    public void update(BoardRequestDto boardUpdate) {
        this.title = boardUpdate.getTitle();
        this.content = boardUpdate.getContent();
    }
}