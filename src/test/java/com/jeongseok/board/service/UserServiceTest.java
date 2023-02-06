package com.jeongseok.board.service;

import com.jeongseok.board.domain.User;
import com.jeongseok.board.dto.UserDto;
import com.jeongseok.board.dto.UserDto.Request;
import com.jeongseok.board.repository.UserRepository;
import com.jeongseok.board.type.UserRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

@WebMvcTest
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@MockBean
	UserRepository userRepository;

	@Test
	@DisplayName("회원가입 테스트")
	@Transactional
	void 회원가입_성공_테스트() {

		// given


		// when
	}


}
