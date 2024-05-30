package com.sparta.springpersonalboard.controller;

import com.sparta.springpersonalboard.dto.UserRequestDto;
import com.sparta.springpersonalboard.dto.UserResponseDto;
import com.sparta.springpersonalboard.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /* Signup */
    @PostMapping("/user/signup")
    public UserResponseDto signup(@RequestBody UserRequestDto requestDto) {
        System.out.println("here");
//        userService.signup(requestDto);
        return userService.signup(requestDto);
    }


}
