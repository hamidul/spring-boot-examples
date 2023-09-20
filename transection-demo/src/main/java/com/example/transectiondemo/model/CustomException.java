package com.example.transectiondemo.model;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomException() {

	}

	public CustomException(String errorMessage) {
		super(errorMessage);
	}

}
