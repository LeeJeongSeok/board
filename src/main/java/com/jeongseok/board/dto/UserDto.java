package com.jeongseok.board.dto;

import com.jeongseok.board.domain.User;
import com.jeongseok.board.type.UserRole;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
		@NotBlank(message = "아이디는 필수 입력 값입나다.")
		private String username;

		@NotBlank(message = "비밀번호는 필수 입력 값입니다.")
		@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
		private String password;

		@NotBlank(message = "이름은 필수 입력 값입니다.")
		private String name;

		@NotBlank(message = "전화번호는 필수 입력 값입니다.")
		private String phone;
		private UserRole role;
		private LocalDateTime createdAt;
		private LocalDateTime updatedAt;

		/**
		 * DTO -> Entity
		 */
		public User toEntity() {
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

		public static Response from(User user) {
			return Response.builder()
				.username(user.getUsername())
				.name(user.getName())
				.phone(user.getPhone())
				.role(user.getRole())
				.build();
		}
	}


}
