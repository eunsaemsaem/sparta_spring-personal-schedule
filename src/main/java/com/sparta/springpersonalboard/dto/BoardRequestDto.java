package com.sparta.springpersonalboard.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class BoardRequestDto {
    @NotNull
    private Long boardId;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private String manager;

    @NotNull
    private String password;
}
