package com.jeongseok.board.controller;

import com.jeongseok.board.dto.UserDto;
import com.jeongseok.board.service.UserService;
import java.util.Map;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

	private final UserService userService;

	@GetMapping("/")
	public String index() {
		return "/board/board";
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
	public String join(@Valid UserDto.Request createUserDto, Errors errors, Model model) {

		if (errors.hasErrors()) {
			/* 유효성 통과 못한 필드와 메시지를 핸들링 */
			Map<String, String> validatorResult = userService.validateHandling(errors);
			for (String key : validatorResult.keySet()) {
				model.addAttribute(key, validatorResult.get(key));
			}
			return "/user/join";
		}

		userService.join(createUserDto);

		return "redirect:/login";
	}

}
