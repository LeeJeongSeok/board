package com.jeongseok.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class BoardController {

	@GetMapping("/board")
	public String board() {
		return "/board/board";
	}

}
