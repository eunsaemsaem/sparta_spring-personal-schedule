package com.sparta.springpersonalboard.repository;

import com.sparta.springpersonalboard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByNickname(String nickname);
}
