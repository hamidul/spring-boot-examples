package com.example.misc.exception;

public class UserAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = -7332422792292830912L;

	public UserAlreadyExistsException(String errorMessage) {
		super(errorMessage);
	}

}
