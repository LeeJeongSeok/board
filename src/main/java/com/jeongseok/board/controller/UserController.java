package com.jeongseok.board.controller;

import com.jeongseok.board.model.UserDto;
import com.jeongseok.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

	private final UserService userService;
	@PostMapping("/user/join")
	public String userRegister(UserDto userDto) {
		userService.join(userDto);

		return "/";
	}
}
