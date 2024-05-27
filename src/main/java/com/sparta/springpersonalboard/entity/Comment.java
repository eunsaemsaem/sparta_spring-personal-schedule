package com.sparta.springpersonalboard.entity;

import com.sparta.springpersonalboard.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "comments")
@NoArgsConstructor
public class Comment extends CommentTime {

    /* column */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "userId", nullable = false)
    private String userId;


    /* mapping */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    /* constructor */
    public Comment(CommentRequestDto requestDto) {
        this.content = requestDto.getContent();
        this.userId = requestDto.getUserId();
    }

}
