package com.sparta.springpersonalboard.repository;

import com.sparta.springpersonalboard.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
