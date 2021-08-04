package com.example.demo.domain;

public class UserAlreadyExistsException extends RuntimeException{
	public UserAlreadyExistsException(String errorMsg) {super(errorMsg);}
}
