package com.sparta.springpersonalboard.dto;

import com.sparta.springpersonalboard.entity.Comment;

import java.time.LocalDateTime;

public class CommentResponseDto {
    private Long id;
    private String content;
    private String userid;
    private LocalDateTime commentAt;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.userid = comment.getUserId();
        this.commentAt = comment.getCommentAt();
    }
}
