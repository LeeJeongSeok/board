package com.jeongseok.board.service;

import com.jeongseok.board.domain.User;
import com.jeongseok.board.dto.CustomUserDetails;
import com.jeongseok.board.dto.UserDto;
import com.jeongseok.board.repository.UserRepository;
import com.jeongseok.board.type.UserRole;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

@RequiredArgsConstructor
@Component
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder encoder;
	private final HttpSession session;

	@Transactional
	public Long join(UserDto.Request createUserDto) {
		createUserDto.setPassword(encoder.encode(createUserDto.getPassword()));
		createUserDto.setRole(UserRole.USER);

		return userRepository.save(createUserDto.toEntity()).getId();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).orElseThrow(() ->
			new UsernameNotFoundException("해당 사용자가 존재하지 않습니다. : " + username));

		session.setAttribute("user", UserDto.Response.from(user));

		return new CustomUserDetails(user);
	}

	public Map<String, String> validateHandling(Errors errors) {
		Map<String, String> validatorResult = new HashMap<>();

		/* 유효성 검사에 실패한 필드 목록을 받음 */
		for (FieldError error : errors.getFieldErrors()) {
			String validKeyName = String.format("valid_%s", error.getField());
			validatorResult.put(validKeyName, error.getDefaultMessage());
		}
		return validatorResult;
	}
}
