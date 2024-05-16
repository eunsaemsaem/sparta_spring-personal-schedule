package com.sparta.springpersonalboard.service;

import com.sparta.springpersonalboard.dto.BoardRequestDto;
import com.sparta.springpersonalboard.dto.BoardResponseDto;
import com.sparta.springpersonalboard.entity.Board;
import com.sparta.springpersonalboard.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardResponseDto createBoard(BoardRequestDto boardRequestDto) {
        Board board = new Board();
        Board saveBoard = boardRepository.save(board);
        BoardResponseDto boardResponseDto = new BoardResponseDto(board);
        return boardResponseDto;
    }
}
