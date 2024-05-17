package com.sparta.springpersonalboard.dto;

import com.sparta.springpersonalboard.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponseDto {

    private Long id;
    private String title;
    private String content;
    private String manager;
//    private String password;
    private LocalDateTime date;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.manager = board.getManager();
//        this.password = board.getPassword();
        this.date = board.getDate();
    }

}
