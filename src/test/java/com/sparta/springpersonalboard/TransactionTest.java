package com.sparta.springpersonalboard;

import com.sparta.springpersonalboard.entity.Board;
import com.sparta.springpersonalboard.repository.BoardRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TransactionTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    BoardRepository boardRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    @DisplayName("생성 성공")
    void test1() {
        Board board = new Board();
        board.setTitle("titleb");
        board.setContent("contentb");
        board.setManager("managerb");
        board.setPassword("passwordb");

        em.persist(board);
    }
}
