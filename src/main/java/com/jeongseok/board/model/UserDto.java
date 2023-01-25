package com.jeongseok.board.model;

import com.jeongseok.board.entity.User;
import com.jeongseok.board.type.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

	private String username;
	private String password;
	private String nickname;
	private String phone;
	private String profile;
	private Role role;

	public User toEntity() {
		return User.builder()
			.username(username)
			.password(password)
			.nickname(nickname)
			.phone(phone)
			.profile(profile)
			.role(role)
			.build();
	}

}
