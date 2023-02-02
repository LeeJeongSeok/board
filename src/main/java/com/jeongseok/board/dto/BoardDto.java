package com.jeongseok.board.dto;

import com.jeongseok.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class BoardDto {

	@Getter @Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class Request {

		private String title;
		private String content;
		private String username;

		/**
		 * DTO -> Entity
		 */
		public Board toEntity() {
			return Board.builder()
				.title(title)
				.content(content)
				.username(username)
				.build();
		}
	}

	@Getter
	@Builder
	public static class Response {

		private Long id;
		private String title;
		private String content;

		public static Response from(Board board) {
			return Response.builder()
				.id(board.getId())
				.title(board.getTitle())
				.content(board.getContent())
				.build();
		}
	}

}
