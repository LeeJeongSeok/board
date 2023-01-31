package com.jeongseok.board.dto;

import com.jeongseok.board.domain.User;
import com.jeongseok.board.type.UserRole;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserDto {

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

	public User toEntity(CreateUserDto createUserDto) {
		return User.builder()
			.username(createUserDto.username)
			.password(createUserDto.password)
			.name(createUserDto.name)
			.phone(createUserDto.phone)
			.role(createUserDto.role)
			.build();
	}

}
