package kr.co.kafkaplayground.error.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {

	BASE("======= Error!! =======\n"),
	INTERRUPTED("======= Thread was interrupted: ");

	private final String message;
}
