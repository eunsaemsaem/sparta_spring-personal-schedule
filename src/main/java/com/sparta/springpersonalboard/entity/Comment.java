package com.sparta.springpersonalboard.entity;

import jakarta.persistence.*;

public class Comment extends Timestamped {

    /* column */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "userId", nullable = false)
    private String userId;

    @Column(name = "boardId", nullable = false)
    private Long boardId;

    /* mapping */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

}
