package com.jeongseok.board.dto;

import com.jeongseok.board.domain.User;
import com.jeongseok.board.type.UserRole;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

	private String username;
	private String password;
	private String name;
	private String phone;
	private UserRole role;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	/**
	 * DTO -> Entity
	 */
	public User toEntity(UserDto userDto) {
		return User.builder()
					.username(userDto.username)
					.password(userDto.password)
					.name(userDto.name)
					.phone(userDto.phone)
					.role(userDto.role)
					.createAt(userDto.createdAt)
					.updatedAt(userDto.updatedAt)
					.build();
	}
}
