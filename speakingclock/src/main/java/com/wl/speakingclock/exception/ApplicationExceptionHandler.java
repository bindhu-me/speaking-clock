package com.wl.speakingclock.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.ServiceUnavailableException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ApplicationExceptionHandler extends Exception {

	@ResponseStatus(value = HttpStatus.GATEWAY_TIMEOUT, reason = "Service Not Responding, Try Again")
	@ExceptionHandler(ServiceUnavailableException.class)
	public ResponseEntity<Error> handleException(ServiceUnavailableException e) {
		Error error = new Error(HttpStatus.GATEWAY_TIMEOUT, 
			      e.getLocalizedMessage());
			  return new ResponseEntity<>(error, error.getHttpStatus());
	}
	
	
	@ExceptionHandler({
	    BindException.class,
	    MethodArgumentNotValidException.class
	})
	public ResponseEntity<Error> 
	    handleException(BindException e) {
	        

		Error error = new Error(HttpStatus.BAD_REQUEST, 
			      e.getLocalizedMessage());
			  return new ResponseEntity<>(error, error.getHttpStatus());
	}
}
