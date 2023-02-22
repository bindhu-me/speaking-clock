package com.wl.speakingclock.exception;

import org.springframework.http.HttpStatus;

public class Error {
	private final HttpStatus httpStatus;
	private final String message;


	public Error(HttpStatus httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getMessage() {
		return message;
	}

}