package com.jeongseok.board.service;

import com.jeongseok.board.domain.Board;
import com.jeongseok.board.dto.BoardDto;
import com.jeongseok.board.dto.BoardDto.Request;
import com.jeongseok.board.repository.BoardRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository boardRepository;

	public List<Board> getBoardList() {
		List<Board> boardList = boardRepository.findAll();

		return boardList;
	}

	public BoardDto.Response getBoard(Long id) {
		Board board = boardRepository.findBoardById(id).orElseThrow(() ->
			new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

		return BoardDto.Response.from(board);
	}

	@Transactional
	public void write(BoardDto.Request createBoard) {
		boardRepository.save(createBoard.toEntity());
	}

	@Transactional
	public void update(Long id, Request updateBoard) {
		Board board = boardRepository.findBoardById(id).orElseThrow(() ->
			new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

		board.setTitle(updateBoard.getTitle());
		board.setContent(updateBoard.getContent());

		boardRepository.save(board);
	}

	@Transactional
	public void delete(Long id) {
		Board board = boardRepository.findBoardById(id).orElseThrow(() ->
			new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

		board.setUseYn("N");
	}
}
