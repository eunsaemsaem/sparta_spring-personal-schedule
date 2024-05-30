package com.sparta.springpersonalboard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto {
    private String nickname;
    private String username;
    private String password;
    private boolean admin = false;
    private String adminToken = "";
}
