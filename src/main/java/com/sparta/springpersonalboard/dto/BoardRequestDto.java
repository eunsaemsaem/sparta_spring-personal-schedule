package com.sparta.springpersonalboard.dto;

import lombok.Getter;

@Getter
public class BoardRequestDto {
    private Long id;
    private String title;
    private String content;
    private String manager;
    private String password;
    private String date;
}
