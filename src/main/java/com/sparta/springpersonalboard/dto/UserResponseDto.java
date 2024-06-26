package com.sparta.springpersonalboard.dto;

import lombok.Getter;

@Getter
public class UserResponseDto {
    private String message;
    private String token;

    public UserResponseDto(String message, String token) {
        this.message = message;
        this.token = token;
    }
}
