package com.sparta.springpersonalboard.service;

import com.sparta.springpersonalboard.dto.SignupRequestDto;
import com.sparta.springpersonalboard.dto.UserResponseDto;
import com.sparta.springpersonalboard.entity.User;
import com.sparta.springpersonalboard.entity.UserRoleEnum;
import com.sparta.springpersonalboard.jwt.JwtUtil;
import com.sparta.springpersonalboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    // ADMIN_TOKEN : 관리자 구분
    private final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";


    public UserResponseDto signup(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String nickname = requestDto.getNickname();
        String password = requestDto.getPassword();

        // username 중복 확인
        Optional<User> checkUsername = userRepository.findByUsername(username);
        if (checkUsername.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        // nickname 중복 확인
        Optional<User> checkNickname = userRepository.findByNickname(nickname);
        if (checkNickname.isPresent()) {
            throw new IllegalArgumentException("중복된 닉네임이 존재합니다.");
        }

        // 사용자 role 확인
        UserRoleEnum role = UserRoleEnum.USER;
        if (requestDto.isAdmin()) {
            if (!ADMIN_TOKEN.equals(requestDto.getAdminToken())) {
                throw new IllegalArgumentException("관리자 암호자 일치하지 않습니다.");
            }
            role = UserRoleEnum.ADMIN;
        }

        // 사용자 등록
        User user = new User (username, nickname, password, role);
        User saveUser = userRepository.save(user);

        return new UserResponseDto(saveUser);
    }


}
