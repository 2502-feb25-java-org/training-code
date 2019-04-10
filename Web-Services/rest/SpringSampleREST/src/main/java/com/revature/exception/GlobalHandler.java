/*
* @author Peter Alagna
*/ 

package com.revature.exception;

import static com.revature.util.ClientMessageUtil.*;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.revature.ajax.ClientMessage;

/**
 * Since we are handling exceptions globally in our application,
 * we need to specify that this class is an Advisor for Controllers,
 * with the @ControllerAdvice
 *
 * If a specific exception gets thrown, and there is a Handler for it, it will execute.
 * Everything else will go to the global handler.
 */
@ControllerAdvice
public class GlobalHandler {
	private static Logger logger = Logger.getLogger(GlobalHandler.class);
	
	/**
	 * Global Exception Handler
	 */
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ClientMessage> handleAnyException(Throwable t) {
		logger.error("Internal error.", t);
		return new ResponseEntity<>(SOMETHING_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Specific Exception Handler
	 */
	@ExceptionHandler(InvalidFormException.class)
	public ResponseEntity<ClientMessage> handleInvalidFormException(InvalidFormException e) {
		logger.error("Invalid form data.", e);
		return new ResponseEntity<>(INVALID_DATA, HttpStatus.BAD_REQUEST);
	}
}
