package com.jeongseok.board.controller;

import com.jeongseok.board.dto.UserDto;
import com.jeongseok.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

	private final UserService userService;

	@GetMapping(value = {"/", "/home"})
	public String index() {
		return "home";
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/login")
	public String login() {
		return "/user/login";
	}

	@GetMapping("/auth/join")
	public String join() {
		return "/user/join";
	}

	@PostMapping("/auth/join")
	public String join(UserDto userDto) {
		userService.join(userDto);

		return "redirect:/login";
	}

}
