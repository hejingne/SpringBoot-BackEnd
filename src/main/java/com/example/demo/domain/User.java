package com.example.demo.domain;

import lombok.Getter;

@Getter
public class User {
	private final Long id;
	private String name;	// make it not final so we can put validations when updating the name

	public User(Long id, String name) throws DomainException {
		this.id = id;
		this.name = name;
	}

	public void updateName(String name) throws InvalidNameException {
		if (name.length() == 0) {
			throw new InvalidNameException("Username can not be empty");
		} else if (name.length() == 100) {
			throw new InvalidNameException("Length of Username can not be 100");
		}
		this.name = name;
	}
}
