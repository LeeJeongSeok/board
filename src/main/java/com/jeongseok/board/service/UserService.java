package com.jeongseok.board.service;

import com.jeongseok.board.domain.User;
import com.jeongseok.board.dto.CreateUserDto;
import com.jeongseok.board.dto.CustomUserDetails;
import com.jeongseok.board.repository.UserRepository;
import com.jeongseok.board.type.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;

	private final BCryptPasswordEncoder encoder;

	/**
	 *
	 * @param createUserDto
	 * @return
	 */
	@Transactional
	public Long join(CreateUserDto createUserDto) {
		createUserDto.setPassword(encoder.encode(createUserDto.getPassword()));
		createUserDto.setRole(UserRole.USER);

		return userRepository.save(createUserDto.toEntity(createUserDto)).getId();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).orElseThrow(() ->
			new UsernameNotFoundException("해당 사용자가 존재하지 않습니다. : " + username));

		return new CustomUserDetails(user);
	}
}
