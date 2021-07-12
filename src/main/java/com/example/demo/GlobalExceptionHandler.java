package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {DomainException.class})
	public ResponseEntity<String> handleException(DomainException domainException) {
		return new ResponseEntity<>(domainException.getMessage(), HttpStatus.BAD_REQUEST);		// will throw BAD_REQUEST instead of
	}

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<String> handleException(Exception exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	// will throw the self designed error msg
	}

	@ExceptionHandler(value = {InvalidNameException.class})
	public String handleException(InvalidNameException invalidNameException) {
		return invalidNameException.getMessage();		// won't throw the self designed error msg
	}

}
