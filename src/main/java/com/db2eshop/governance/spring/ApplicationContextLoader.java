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
package com.db2eshop.governance.spring;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * ApplicationContextLoader class.
 * </p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class ApplicationContextLoader {
	protected Logger log = Logger.getLogger(getClass());

	/**
	 * Constant
	 * <code>classpathConfigurationLocation="classpath*:applicationContext.xml"</code>
	 */
	public static final String classpathConfigurationLocation = "classpath*:applicationContext.xml";
	private ApplicationContext applicationContext;

	private static ApplicationContextLoader INSTANCE;

	/**
	 * <p>
	 * getInstance.
	 * </p>
	 *
	 * @return a {@link com.db2eshop.governance.spring.ApplicationContextLoader}
	 *         object.
	 */
	public static ApplicationContextLoader getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ApplicationContextLoader();
		}
		return INSTANCE;
	}

	private ApplicationContextLoader() {
		try{
			applicationContext = new ClassPathXmlApplicationContext(classpathConfigurationLocation);
		}catch(BeanCreationException beanCreationException){
			onApplicationInitializationError(beanCreationException);
		}
	}
	
	/**
	 * <p>onApplicationInitializationError.</p>
	 *
	 * @param beanCreationException a {@link org.springframework.beans.factory.BeanCreationException} object.
	 */
	protected void onApplicationInitializationError(BeanCreationException beanCreationException){
		throw beanCreationException;
	}

	/**
	 * <p>
	 * Getter for the field <code>applicationContext</code>.
	 * </p>
	 *
	 * @return a {@link org.springframework.context.ApplicationContext} object.
	 */
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * <p>
	 * Setter for the field <code>applicationContext</code>.
	 * </p>
	 *
	 * @param applicationContext
	 *            a {@link org.springframework.context.ApplicationContext}
	 *            object.
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
}
