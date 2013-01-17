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
package com.db2eshop.gui.dialog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.err.orm.ConstraintVialotionTranslator;

@Component
/**
 * <p>Abstract ORMActionDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public abstract class ORMActionDialog extends ConfirmCancelDialog{
	private static final long serialVersionUID = 4389737938092046254L;

	@Autowired
	private ConstraintVialotionTranslator constraintVialotionTranslator;
	
	/**
	 * <p>onConstraintViolation.</p>
	 *
	 * @param throwable a {@link java.lang.Throwable} object.
	 * @return a {@link java.lang.String} object.
	 */
	public String onConstraintViolation(Throwable throwable){
		return constraintVialotionTranslator.translate(throwable);
	}
}
