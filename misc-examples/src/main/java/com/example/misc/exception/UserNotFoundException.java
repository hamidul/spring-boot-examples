package com.example.misc.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4620323770207157476L;

	public UserNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
