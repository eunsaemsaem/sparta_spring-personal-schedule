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
    @PutMapping("/board/{boardId}/comment/{commentId}")
    public String updateComment (@PathVariable("boardId") Long boardId,
                               @PathVariable("commentId") Long commentId,
                               @RequestBody CommentRequestDto requestDto) {
        return commentService.updateComment(boardId, commentId, requestDto);
    }

    /* Delete */
    @DeleteMapping("/board/{boardId}/comment/{commentId}")
    public Long deleteComment (@PathVariable("boardId") Long boardId,
                               @PathVariable("commentId") Long commentId,
                               @RequestBody CommentRequestDto requestDto) {
        return commentService.deleteComment(boardId, commentId, requestDto);
    }


}
