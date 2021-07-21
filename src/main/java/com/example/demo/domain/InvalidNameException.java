package com.example.demo.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidNameException extends DomainException {

	public InvalidNameException(String errorMsg) {
		super(errorMsg);
	}
}
