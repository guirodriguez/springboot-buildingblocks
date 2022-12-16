package com.stacksimplify.restservices.exceptions;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// MethodArgumentNotValidException
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorDetails ced = new CustomErrorDetails(new Date(),
				"From MethodArgumentNotValid Exception in GEH(globalExceptionHandler)", ex.getMessage());

		return new ResponseEntity<>(ced, HttpStatus.BAD_REQUEST);
	}

	// HttpRequestMethodNotSupportedException
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorDetails ced = new CustomErrorDetails(new Date(),
				"From HttpRequestMethodNotSupported Exception in GEH(globalExceptionHandler) - Method not Allowed",
				ex.getMessage());

		return new ResponseEntity<>(ced, HttpStatus.METHOD_NOT_ALLOWED);
	}

	// UsernameNotFound
	@ExceptionHandler(UsernameNotFoundException.class)
	public final ResponseEntity<Object> handleUsernameNotFoundException(UsernameNotFoundException ex, WebRequest request){
		CustomErrorDetails ced = new CustomErrorDetails(new Date(),
				ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(ced, HttpStatus.NOT_FOUND);
	}
		
	//Constraint Violation Exception
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
		CustomErrorDetails ced = new CustomErrorDetails(new Date(),
				ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(ced, HttpStatus.BAD_REQUEST);
	}
	
}
