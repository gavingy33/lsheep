package com.lsheep.common.core.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContext.applicationContext = applicationContext;
	}

	public static Object getBean(String name) throws BeansException {
		if (!applicationContext.containsBean(name)) {
			return null;
		}
		return applicationContext.getBean(name);
	}

	public static <T> T getBean(String name, Class<T> requiredType) throws BeansException {
		if (!applicationContext.containsBean(name)) {
			return null;
		}
		return applicationContext.getBean(name, requiredType);
	}

}
