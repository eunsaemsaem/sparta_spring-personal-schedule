package com.sparta.springpersonalboard.service;

import com.sparta.springpersonalboard.dto.CommentRequestDto;
import com.sparta.springpersonalboard.dto.CommentResponseDto;
import com.sparta.springpersonalboard.entity.Comment;
import com.sparta.springpersonalboard.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    /* Create */
    public CommentResponseDto createComment(CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.save(new Comment(commentRequestDto));

        // 예외처리
        // 선택한 일정의 ID를 입력 받지 않은 경우
        if (comment.getId() == null) {
            throw new IllegalArgumentException("선택한 일정의 아이디를 입력해주세요.");
        }
        // 댓글 내용이 비어 있는 경우
        else if (comment.getContent().isEmpty()) {
            throw new IllegalArgumentException("댓글 내용을 작성해주세요");
        }
        else if (comment.getBoard() == null) {
            throw new IllegalArgumentException("등록된 일정을 선택해주세요.");
        }

        return new CommentResponseDto(comment);
    }
}
