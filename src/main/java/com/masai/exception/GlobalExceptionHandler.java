package com.masai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> GeneralExceptionHandler(Exception se){
		return new ResponseEntity<>(se.getMessage() , HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(SwiggyException.class)
	public ResponseEntity<String> swiggyExceptionHandler(SwiggyException se){
		return new ResponseEntity<>(se.getMessage() , HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<String> NoHandelerExceptionHandler(NoHandlerFoundException se){
		return new ResponseEntity<>("There is no handler for this endpoint" , HttpStatus.BAD_REQUEST) ;
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> NotValidExceptionHandler(MethodArgumentNotValidException se){
		return new ResponseEntity<>(se.getMessage() , HttpStatus.BAD_REQUEST) ;
	}
	// 1.05

}
