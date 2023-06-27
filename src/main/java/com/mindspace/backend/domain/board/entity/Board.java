package com.mindspace.backend.domain.board.entity;

import com.mindspace.backend.domain.board.dto.BoardRequestDto;
import com.mindspace.backend.domain.node.entity.Node;
import com.mindspace.backend.domain.user.entity.User;
import com.mindspace.backend.global.common.Timestamp;
import com.mindspace.backend.domain.node.entity.Node;
import com.mindspace.backend.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @OneToOne
    @JoinColumn(name="user", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "node", referencedColumnName = "node_id")
    private Node node;

    public void update(BoardRequestDto boardUpdate) {
        this.title = boardUpdate.getTitle();
        this.content = boardUpdate.getContent();
    }
}
