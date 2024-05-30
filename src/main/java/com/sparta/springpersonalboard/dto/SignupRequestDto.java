package com.sparta.springpersonalboard.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

@Getter
@Setter
public class SignupRequestDto {
    private String nickname;

    @Size(min = 4, max = 10, message = "4자 이상, 10자 이하로 입력해주세요.")
    @Pattern(regexp = "^[a-z0-9]+$", message = "소문자와 숫자로만 구성되어야 합니다.")
    private String username;


    private String password;
    private boolean admin = false;
    private String adminToken = "";
}
