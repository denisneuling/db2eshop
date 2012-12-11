package com.db2eshop.governance.spring;

import java.util.Observable;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SuppressWarnings("rawtypes")
public class ApplicationContextObserver extends Observable implements BeanPostProcessor, ApplicationContextAware, ApplicationListener {

	private final Logger log = Logger.getLogger(this.getClass());
	private static ApplicationContextObserver INSTANCE;
	private volatile boolean refreshed = false;

	public static ApplicationContextObserver getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ApplicationContextObserver();
		}
		return INSTANCE;
	}

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		log.info(String.format("On %s Bean {%s} initialized.", applicationContext.getDisplayName(), beanName));
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		log.info("###############################" + event.getClass().getName() + "###############################");

		if (event instanceof ContextRefreshedEvent) {
			this.setChanged();
			this.notifyObservers();
			refreshed = true;
		}
	}

	public boolean isRefreshed() {
		return refreshed;
	}

	public void setRefreshed(boolean refreshed) {
		this.refreshed = refreshed;
	}
}