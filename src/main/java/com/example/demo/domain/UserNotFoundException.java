package com.example.demo.domain;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(String errorMsg) {
		super(errorMsg);
	}
}
