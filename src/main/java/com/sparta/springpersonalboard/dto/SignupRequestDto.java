package com.sparta.springpersonalboard.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

@Getter
public class SignupRequestDto {
    @Size(min = 4, max = 10, message = "4자 이상, 10자 이하로 입력해주세요.")
    @Pattern(regexp = "^[a-z0-9]+$", message = "소문자와 숫자로만 구성되어야 합니다.")
    @NotBlank(message = "사용자 이름은 필수입니다.")
    private String username;

    @NotBlank(message = "비밀번호는 필수입니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+$", message = "영어와 숫자 조합만 가능합니다.")
    private String password;

    private String nickname;

    private boolean admin = false;
    private String adminToken = "";
}
