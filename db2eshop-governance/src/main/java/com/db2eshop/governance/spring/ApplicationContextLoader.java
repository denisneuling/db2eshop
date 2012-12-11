package com.db2eshop.governance.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextLoader {

	public static final String classpathConfigurationLocation = "classpath*:applicationContext.xml";
	private ApplicationContext applicationContext;

	private static ApplicationContextLoader INSTANCE;

	public static ApplicationContextLoader getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ApplicationContextLoader();
		}
		return INSTANCE;
	}

	private ApplicationContextLoader() {
		applicationContext = new ClassPathXmlApplicationContext(classpathConfigurationLocation);
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public static void main(String[] args) {
		ApplicationContextLoader.getInstance();
	}
}
