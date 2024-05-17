package com.sparta.springpersonalboard.controller;

import com.sparta.springpersonalboard.dto.BoardRequestDto;
import com.sparta.springpersonalboard.dto.BoardResponseDto;
import com.sparta.springpersonalboard.service.BoardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/schedule")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto boardRequestDto) {
        return boardService.createBoard(boardRequestDto);
    }

    @GetMapping("/schedule/{id}")
    public BoardResponseDto getBoardById(@PathVariable Long id) {
        return boardService.getBoard(id);
    }



}
