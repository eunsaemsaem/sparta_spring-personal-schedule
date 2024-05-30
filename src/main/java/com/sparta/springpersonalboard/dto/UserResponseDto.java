package com.sparta.springpersonalboard.dto;

import com.sparta.springpersonalboard.entity.User;

import java.time.LocalDateTime;

public class UserResponseDto {
    private Long id;
    private String nickname;
    private String username;
    private String password;
    private LocalDateTime userTime;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.userTime = user.getUserTime();
    }
}
