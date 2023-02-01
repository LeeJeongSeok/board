package com.jeongseok.board.dto;

import com.jeongseok.board.domain.User;
import com.jeongseok.board.type.UserRole;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserDto {

	@Getter @Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Request {
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
				.username(username)
				.password(password)
				.name(name)
				.phone(phone)
				.role(role)
				.build();
		}
	}


	/**
	 * 인증된 사용자 정보를 세션에 저장하기 위한 responseDto 클래스 생성
	 */
	@Getter
	@Builder
	public static class Response {

		private String username;
		private String name;
		private String phone;
		private UserRole role;

		public static Response from
			(User user) {
			return Response.builder()
				.username(user.getUsername())
				.name(user.getName())
				.phone(user.getPhone())
				.role(user.getRole())
				.build();
		}
	}


}
