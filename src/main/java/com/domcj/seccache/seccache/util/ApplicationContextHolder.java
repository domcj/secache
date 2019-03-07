package com.domcj.seccache.seccache.util;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description: This is a class!
 * @author: chenjian
 * @date: 2019/03/07 11:33
 */

@Component
public class ApplicationContextHolder implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ApplicationContextHolder.applicationContext = applicationContext;
	}
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) {
		checkApplicationContext();
		return (T) applicationContext.getBean(beanName);
	}
	@SuppressWarnings("unchecked")
	public static <T> Map<String, T> getBean(Class<T> clazz) {
		checkApplicationContext();
		return applicationContext.getBeansOfType(clazz);
	}
	private static void checkApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
		}
	}

}
