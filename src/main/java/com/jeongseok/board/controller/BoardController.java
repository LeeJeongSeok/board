package com.jeongseok.board.controller;

import com.jeongseok.board.domain.Board;
import com.jeongseok.board.dto.BoardDto;
import com.jeongseok.board.dto.BoardDto.Response;
import com.jeongseok.board.service.BoardService;
import java.security.Principal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class BoardController {

	private final BoardService boardService;

	@GetMapping("/board")
	public String board(Model model) {
		List<Board> boardList = boardService.getBoardList();

		model.addAttribute("list", boardList);

		return "/board/board";
	}

	@GetMapping("/board/{id}")
	public String boardDetails(@PathVariable("id") Long id, Model model) {

		Response board = boardService.getBoard(id);
		model.addAttribute("board", board);

		return "/board/detail";
	}

	@GetMapping("/board/write")
	public String write() {
		return "/board/write";
	}


	@PostMapping("/board/write")
	public String write(BoardDto.Request createBoard, Principal principal) {
		createBoard.setUsername(principal.getName());
		boardService.write(createBoard);

		return "redirect:/board";
	}

	@PostMapping("/board/update/{id}")
	public String update(@PathVariable("id") Long id, BoardDto.Request updateBoard) {
		boardService.update(id, updateBoard);

		return "redirect:/board";
	}

	@DeleteMapping("/board/delete/{id}")
	public String delete(@PathVariable Long id) {
		boardService.delete(id);

		return "redirect:/board";
	}

}
