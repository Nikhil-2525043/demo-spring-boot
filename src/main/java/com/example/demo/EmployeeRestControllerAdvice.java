package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.EmployeeException;

@RestControllerAdvice
public class EmployeeRestControllerAdvice {

	@ExceptionHandler(EmployeeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleException(EmployeeException e) {
		return e.getMessage();
		
	}
	
//	@ExceptionHandler(EmployeeException.class)
	
}
