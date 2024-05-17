package com.sparta.springpersonalboard.service;

import com.sparta.springpersonalboard.dto.BoardRequestDto;
import com.sparta.springpersonalboard.dto.BoardResponseDto;
import com.sparta.springpersonalboard.entity.Board;
import com.sparta.springpersonalboard.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

//    @Transactional
    public BoardResponseDto createBoard(BoardRequestDto boardRequestDto) {
        Board board = new Board(boardRequestDto);

        Board saveBoard = boardRepository.save(board);
        BoardResponseDto boardResponseDto = new BoardResponseDto(saveBoard);

        return boardResponseDto;
    }

    public BoardResponseDto getBoard(Long id) {
        Optional<Board> optionalBoard = boardRepository.findById(id);
        BoardResponseDto boardResponseDto = new BoardResponseDto(optionalBoard.get());
        return boardResponseDto;
    }

    public List<BoardResponseDto> getBoards() {
        return boardRepository.findAllByOrderByDate().stream().map(BoardResponseDto::new).toList();
    }




}
