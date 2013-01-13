package com.db2eshop.governance.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * ApplicationContextLoader class.
 * </p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public class ApplicationContextLoader {

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
		applicationContext = new ClassPathXmlApplicationContext(classpathConfigurationLocation);
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
