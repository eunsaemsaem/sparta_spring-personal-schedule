package com.sparta.springpersonalboard.controller;

import com.sparta.springpersonalboard.dto.SignupRequestDto;
import com.sparta.springpersonalboard.dto.SignupResponseDto;
import com.sparta.springpersonalboard.dto.UserRequestDto;
import com.sparta.springpersonalboard.dto.UserResponseDto;
import com.sparta.springpersonalboard.entity.User;
import com.sparta.springpersonalboard.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sparta.springpersonalboard.jwt.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @PostMapping("/authenticate")
    public String CreateToken(@RequestBody UserRequestDto requestDto) throws Exception {
        if("user".equals(requestDto.getUsername()) && "password".equals(requestDto.getPassword())) {
            return JwtUtil.generateToken(requestDto.getUsername());
        } else {
            throw new Exception("유효하지 않은 자격증명");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestHeader("Authorization") String token) {
        String username = JwtUtil.extractUsername(token.substring(7));

        if (JwtUtil.validateToken(token.substring(7), username)) {
            return "유효한 토큰";
        } else {
            return "유효하지 않은 토큰";
        }
    }


    /* Signup */
    @PostMapping("/register")
    public ResponseEntity<SignupResponseDto> signup (@RequestBody @Valid SignupRequestDto requestDto) {
        try {
            userService.signup(requestDto);
            SignupResponseDto responseDto = new SignupResponseDto("유저 등록 성공");
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new SignupResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    /* Signin */
    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login (@RequestBody UserRequestDto requestDto) {
        try {
            User user = userService.login(requestDto.getUsername(), requestDto.getPassword());
            String token = JwtUtil.generateToken(user.getUsername());
            UserResponseDto responseDto = new UserResponseDto("로그인 성공", token);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new UserResponseDto("유효하지 않은 사용자 이름 혹은 비밀번호입니다.", null), HttpStatus.UNAUTHORIZED);
        }
    }


}
