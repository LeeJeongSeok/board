package com.jeongseok.board.repository;

import com.jeongseok.board.domain.Board;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Long> {

	List<Board> findAllByUseYn(String flag);

	Optional<Board> findBoardById(Long id);
}
