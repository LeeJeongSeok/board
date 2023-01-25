package com.jeongseok.board.service;

import com.jeongseok.board.model.UserDto;
import com.jeongseok.board.repository.UserRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder encoder;

	@Transactional
	public Long join(UserDto userDto) {
		userDto.setPassword(encoder.encode(userDto.getPassword()));

		return userRepository.save(userDto.toEntity()).getId();
	}
}
