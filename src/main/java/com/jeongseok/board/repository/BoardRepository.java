package com.jeongseok.board.repository;

import com.jeongseok.board.domain.Board;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BoardRepository extends JpaRepository<Board, Long> {


	Optional<Board> findBoardById(Long id);
}
