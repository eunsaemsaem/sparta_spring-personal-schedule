package com.sparta.springpersonalboard.service;

import com.sparta.springpersonalboard.dto.CommentRequestDto;
import com.sparta.springpersonalboard.dto.CommentResponseDto;
import com.sparta.springpersonalboard.entity.Board;
import com.sparta.springpersonalboard.entity.Comment;
import com.sparta.springpersonalboard.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardService boardService; ////

    /* Create */
    public CommentResponseDto createComment(CommentRequestDto commentRequestDto, Long boardId) {
        Board board = boardService.findBoard(boardId); // DB에 있는지 먼저 확인
        Comment comment = new Comment(commentRequestDto, board); // 있으면 -> 연관관계 맺기

        commentRepository.save(comment); // 저장
        return new CommentResponseDto(comment);
    }

    /* Update */
    @Transactional
    public String updateComment(Long boardId, Long commentId, CommentRequestDto requestDto) {
        Board board = boardService.findBoard(boardId);
        // board와 연관관계? - 선택한 일정의 댓글이어야 하는데, 일정과 상관없이 수정됨
        // requestDto에 boardId를 추가
        Comment comment = findComment(commentId);

        // 예외처리
        String user = requestDto.getUserId();
        if (board.getId() != comment.getBoard().getId()) { // 선택한 일정과 댓글이 연관관계가 아닐 경우
            throw new IllegalArgumentException ("올바르지 않은 선택입니다.");
        }
        else if (comment.getBoard() == null) { // 일정이나 댓글이 DB에 저장되지 않은 경우
            throw new IllegalArgumentException("등록된 일정 혹은 댓글을 선택해주세요.");
        }
        else if (!user.equals(comment.getUserId())) { // 선택한 댓글의 사용자가 현재 사용자와 일치하지 않은 경우
            throw new IllegalArgumentException("작성자가 일치하지 않습니다.");
        }

        comment.update(requestDto);

        CommentResponseDto responseDto = new CommentResponseDto(comment);
        return responseDto.getContent();
    }

    /* Delete */
    public Long deleteComment(Long boardId, Long commentId, CommentRequestDto requestDto) {
        Board board = boardService.findBoard(boardId);
        Comment comment = findComment(commentId);

        // 예외처리
        String user = requestDto.getUserId();
        if (board.getId() != comment.getBoard().getId()) { // 선택한 일정과 댓글이 연관관계가 아닐 경우
            throw new IllegalArgumentException ("올바르지 않은 선택입니다.");
        }
        else if (comment.getId() == null) { // 선택한 일정이나 댓글의 ID를 입력받지 않은 경우
            throw new IllegalArgumentException("일정 혹은 댓글의 ID를 입력해주세요.");
        }
        else if (comment.getBoard() == null) { // 일정이나 댓글이 DB에 저장되지 않은 경우
            throw new IllegalArgumentException("등록된 일정 혹은 댓글을 선택해주세요.");
        }
        else if (!user.equals(comment.getUserId())) { // 선택한 댓글의 사용자가 현재 사용자와 일치하지 않은 경우
            throw new IllegalArgumentException("작성자가 일치하지 않습니다.");
        }

        commentRepository.delete(comment);

        String value = HttpStatus.valueOf(200).toString();
        System.out.println("삭제를 성공했습니다." + "status: " + value);

        return commentId;
    }



    /* comment 조회 */
    // commentId
    private Comment findComment (Long id) {
        return commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 댓글은 존재하지 않습니다.")
        );
    }

    // boardId + commentId
    private Comment findByBoardIdAndCommentId (Long boardId, Long commentId) {
        Board board = boardService.findBoard(boardId);
        Comment comment = findComment(commentId);
        return comment;
    }


}
