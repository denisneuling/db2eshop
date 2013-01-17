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
package com.db2eshop.err.orm;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
/**
 * <p>ConstraintVialotionTranslator class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class ConstraintVialotionTranslator {
	protected Logger log = Logger.getLogger(getClass());

	/**
	 * <p>translate.</p>
	 *
	 * @param throwable a {@link java.lang.Throwable} object.
	 * @return a {@link java.lang.String} object.
	 */
	public String translate(Throwable throwable){
		if(throwable instanceof org.hibernate.exception.ConstraintViolationException){
			return ((org.hibernate.exception.ConstraintViolationException)throwable).getMessage();
		}else if(throwable instanceof javax.validation.ConstraintViolationException){
			Set<ConstraintViolation<?>> constraintViolations = ((javax.validation.ConstraintViolationException)throwable).getConstraintViolations();
			return createMessage(constraintViolations);
		}else if(throwable instanceof org.springframework.dao.DataIntegrityViolationException){
			return translate(((org.springframework.dao.DataIntegrityViolationException)throwable).getMostSpecificCause());
		}else if(throwable instanceof org.postgresql.util.PSQLException){
			return ((org.postgresql.util.PSQLException)throwable).getMessage();
		}
		return null;
	}
	
	private static <T> String createMessage(Set<ConstraintViolation<?>> contraintViolations) {
		String message = "";
		for(ConstraintViolation<?> violation : contraintViolations) {
			message += violation.getLeafBean().getClass().getSimpleName()+"."+violation.getPropertyPath()+": "+violation.getMessage()+"<br>";
		}
		return message;
	}
	
}
