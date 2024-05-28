package com.sparta.springpersonalboard.controller;

import com.sparta.springpersonalboard.dto.CommentRequestDto;
import com.sparta.springpersonalboard.dto.CommentResponseDto;
import com.sparta.springpersonalboard.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    /* Create */
    @PostMapping("/board/{boardId}/comment")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long boardId) {
        return commentService.createComment(requestDto, boardId);
    }

    /* Read */

    /* Update */
    @PutMapping("/comment/{id}")
    public Long updateComment (@PathVariable("id") Long id, @RequestBody CommentRequestDto requestDto) {
        return commentService.updateComment(id, requestDto);
    }

    /* Delete */
    @DeleteMapping("/comment/{id}")
    public Long deleteComment (@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        return commentService.deleteComment(id, requestDto);
    }


}
