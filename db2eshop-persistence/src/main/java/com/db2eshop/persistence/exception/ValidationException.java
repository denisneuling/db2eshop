package com.db2eshop.persistence.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

/**
 * 
 * @author Denis Neuling (denisneuling@gmail.com)
 *
 */
public class ValidationException extends RuntimeException {
	private static final long serialVersionUID = -4971115570135519005L;

	private static <T> String createMessage(Set<ConstraintViolation<T>> contraintViolations) {
		String message = "Invalid Bean found[\r\n";
		for (ConstraintViolation<?> violation : contraintViolations) {
			message += "\t" + violation.getLeafBean() + "#" + violation.getPropertyPath() + " " + violation.getMessage() + ",\r\n";
		}
		message += "]";
		return message;
	}

	public <T> ValidationException(Set<ConstraintViolation<T>> contraintViolations) {
		super(createMessage(contraintViolations));
	}

}