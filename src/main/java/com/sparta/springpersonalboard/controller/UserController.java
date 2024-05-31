package com.sparta.springpersonalboard.controller;

import com.sparta.springpersonalboard.dto.SignupRequestDto;
import com.sparta.springpersonalboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    /* Signup */
    @PostMapping("/user/signup")
    public String signup( @RequestBody SignupRequestDto requestDto) {
        userService.signup(requestDto);
        return "signup";
    }


}
