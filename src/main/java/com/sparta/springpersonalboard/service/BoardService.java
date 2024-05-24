package com.sparta.springpersonalboard.service;

import com.sparta.springpersonalboard.dto.BoardRequestDto;
import com.sparta.springpersonalboard.dto.BoardResponseDto;
import com.sparta.springpersonalboard.entity.Board;
import com.sparta.springpersonalboard.repository.BoardRepository;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    /* initialize */
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    /* Create */
    public BoardResponseDto createBoard(BoardRequestDto boardRequestDto) {
        Board board = new Board(boardRequestDto);

        Board saveBoard = boardRepository.save(board);
        BoardResponseDto boardResponseDto = new BoardResponseDto(saveBoard);

        return boardResponseDto;
    }

    /* Read */
    public BoardResponseDto getBoard(Long id) {
        Optional<Board> optionalBoard = boardRepository.findById(id);
        BoardResponseDto boardResponseDto = new BoardResponseDto(optionalBoard.get());
        return boardResponseDto;
    }

    public List<BoardResponseDto> getBoards() {
        return boardRepository.findAllByOrderByDate().stream().map(BoardResponseDto::new).toList();
    }


    /* Update */
    @Transactional
    public Long updateBaord(Long id, BoardRequestDto requestDto) {
        Board board = findBoard(id);
        String password = requestDto.getPassword();

        if (password.equals(board.getPassword())) {
            board.update(requestDto);
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
        }
        return id;
    }

    /* Delete */
    public Long deleteBaord(Long id, BoardRequestDto requestDto) {
        Board board = findBoard(id);
        String password = requestDto.getPassword();

        if (password.equals(board.getPassword())) {
            boardRepository.delete(board);
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
        }
        return id;
    }

    /* id로 일정 조회 메서드 */
    private Board findBoard (Long id) {
        return boardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 일정은 존재하지 않습니다.")
        );
    }

}
