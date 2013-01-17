/*
 * Copyright 2012 Denis Neuling, Dennis Wieding, Mateusz Wozniak
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.db2eshop.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

/**
 * <p>
 * ValidationException class.
 * </p>
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

	/**
	 * <p>
	 * Constructor for ValidationException.
	 * </p>
	 *
	 * @param contraintViolations
	 *            a {@link java.util.Set} object.
	 * @param <T>
	 *            a T object.
	 */
	public <T> ValidationException(Set<ConstraintViolation<T>> contraintViolations) {
		super(createMessage(contraintViolations));
	}

}
