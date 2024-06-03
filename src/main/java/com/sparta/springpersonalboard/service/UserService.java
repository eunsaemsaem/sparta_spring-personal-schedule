package com.sparta.springpersonalboard.service;

import com.sparta.springpersonalboard.dto.SignupRequestDto;
import com.sparta.springpersonalboard.entity.User;
import com.sparta.springpersonalboard.entity.UserRoleEnum;
import com.sparta.springpersonalboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // ADMIN_TOKEN : 관리자 구분
    private final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";


    @Transactional
    public void signup(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String nickname = requestDto.getNickname();
        String password = requestDto.getPassword();

        // username 중복 확인
        User checkUsername = userRepository.findByUsername(username);
        if (!Objects.equals(checkUsername.getUsername(), username)) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        // nickname 중복 확인
        User checkNickname = userRepository.findByNickname(nickname);
        if (!Objects.equals(checkNickname.getNickname(), nickname)) {
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
        userRepository.save(user);
    }


    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user == null || !Objects.equals(user.getPassword(), password)) {
            throw new IllegalArgumentException("유효하지 않은 사용자 이름 혹은 잘못된 비밀번호");
        }
        return user;
    }
}
