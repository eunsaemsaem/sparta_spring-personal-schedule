package com.sparta.springpersonalboard.controller;

import com.sparta.springpersonalboard.dto.BoardRequestDto;
import com.sparta.springpersonalboard.dto.BoardResponseDto;
import com.sparta.springpersonalboard.service.BoardService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardController {

    /* initialize */
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    /* Create */
    @PostMapping("/schedule")
    public BoardResponseDto createBoard(@Valid @RequestBody BoardRequestDto boardRequestDto) {
        return boardService.createBoard(boardRequestDto);
    }

    /* Read */
    @GetMapping("/schedule/{id}")
    public BoardResponseDto getBoardById(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    @GetMapping("/schedule")
    public List<BoardResponseDto> getBoards() {
        return boardService.getBoards();
    }

    /* Update */
    @PutMapping("/schedule/{id}")
    public Long updateBoard(@PathVariable Long id, @Valid @RequestBody BoardRequestDto requestDto) {
        return boardService.updateBaord(id, requestDto);
    }

    /* Delete */
    @DeleteMapping("/schedule/{id}")
    public Long deleteBoard(@PathVariable Long id, @Valid @RequestBody BoardRequestDto requestDto) {
        return boardService.deleteBaord(id, requestDto);
    }

}
