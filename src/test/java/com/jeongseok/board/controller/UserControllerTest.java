package com.jeongseok.board.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.jeongseok.board.config.SecurityConfig;
import com.jeongseok.board.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
@Import(SecurityConfig.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	UserService userService;


	@Test
	@DisplayName("인덱스 페이지 요청 성공")
	void 인덱스_페이지_요청_성공() throws Exception {

		// given
		String url = "http://localhost:8080/";

		mockMvc.perform(get(url))
			.andExpect(status().isOk());
	}

	@Test
	@DisplayName("로그인 페이지 요청 성공")
	void 로그인_페이지_요청_성공() throws Exception {

		// given
		String url = "http://localhost:8080/login";

		mockMvc.perform(get(url))
			.andExpect(status().isOk());
	}

	@Test
	@DisplayName("회원가입 페이지 요청 성공 테스트")
	void 회원가입_페이지_요청_성공() throws Exception {

		// given
		String url = "http://localhost:8080/auth/join";

		mockMvc.perform(get(url))
			.andExpect(status().isOk());
	}
}
