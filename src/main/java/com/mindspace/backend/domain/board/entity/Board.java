package com.mindspace.backend.domain.board.entity;

import com.mindspace.backend.domain.board.dto.BoardRequestDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name="board")
@Builder
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_id")
    private int id;
    @Column(name="title", nullable = false)
    private String title;
    @Column(name="content", nullable = false)
    private String content;
    @Column(name="userId", nullable = false)
    private int userId;
    @Column(name="nodeId", nullable = false)
    private int nodeId;

    public static void delete() {
    }

    public void update(BoardRequestDto boardUpdate) {
        this.title = boardUpdate.getTitle();
        this.content = boardUpdate.getContent();
    }


}
