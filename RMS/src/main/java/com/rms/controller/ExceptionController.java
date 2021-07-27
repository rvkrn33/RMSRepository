package com.rms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rms.exceptions.BusinessException;
import com.rms.exceptions.DataNotFoundException;

@RestControllerAdvice
public class ExceptionController {

	
	@ExceptionHandler(value =BusinessException.class)
	public ResponseEntity<Object> handleBusinessExceptions(BusinessException exception) {
		      return new ResponseEntity<>("Internal Server Error. Please contact admin", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value =DataNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(DataNotFoundException exception) {
		      return new ResponseEntity<>("Rate Not found in RMS", HttpStatus.NOT_FOUND);
	}
	
}
