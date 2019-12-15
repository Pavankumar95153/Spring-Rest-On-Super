package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SuperExceptionHandler {

	
	@ExceptionHandler
	public ResponseEntity<SuperErrorResponse>handleExceptionEntity(SuperNotFound exe){
		
		SuperErrorResponse error = new SuperErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exe.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<SuperErrorResponse>handleExceptionEntity(Exception exe){
		
		SuperErrorResponse error = new SuperErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("unable to procced your request");
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}
}
