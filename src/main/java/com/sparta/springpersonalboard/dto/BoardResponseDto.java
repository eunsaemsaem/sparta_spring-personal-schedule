package com.sparta.springpersonalboard.dto;

import com.sparta.springpersonalboard.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {

    private Long id;
    private String title;
    private String content;
    private String manager;
    private String password;
    private String date;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.manager = board.getManager();
        this.password = board.getPassword();
        this.date = board.getDate();
    }

    public BoardResponseDto(Long id, String title, String content, String manager, String password, String date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.manager = manager;
        this.password = password;
        this.date = date;
    }
}
