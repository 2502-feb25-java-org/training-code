/*
* @author Peter Alagna
*/ 

package com.revature.exception;

/**
 * @ResponseStatus might not be useful for RESTful web services.
 * It would be mostly used if views are managed on the Server side with MVC.
 *
 */
//@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason="INVALID DATA")
public class InvalidFormException extends RuntimeException {
	private static final long serialVersionUID = -1010351405897764923L;

	public InvalidFormException(String message) {
		super(message);
	}
}
