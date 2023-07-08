package com.masai.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotAvailableException.class)
	public ResponseEntity<MyErrorDetails> notAvail(NotAvailableException e, WebRequest we) {


		return new ResponseEntity<MyErrorDetails>(
				new MyErrorDetails(LocalDateTime.now(), e.getMessage(), we.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<MyErrorDetails> notFound(NotFoundException e, WebRequest we) {

		return new ResponseEntity<MyErrorDetails>(
				new MyErrorDetails(LocalDateTime.now(), e.getMessage(), we.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> notException(Exception e, WebRequest we) {

		return new ResponseEntity<MyErrorDetails>(
				new MyErrorDetails(LocalDateTime.now(), e.getMessage(), we.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noHandler(NoHandlerFoundException e, WebRequest we) {

		return new ResponseEntity<MyErrorDetails>(
				new MyErrorDetails(LocalDateTime.now(), e.getMessage(), we.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> methodValid(MethodArgumentNotValidException e, WebRequest we) {

		return new ResponseEntity<MyErrorDetails>(
				new MyErrorDetails(LocalDateTime.now(), "No Valid Entries", we.getDescription(false)),
				HttpStatus.BAD_REQUEST);
	}
	
}
