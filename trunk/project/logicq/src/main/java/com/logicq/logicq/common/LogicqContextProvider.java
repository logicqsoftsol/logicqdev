
package com.logicq.logicq.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class LogicqContextProvider implements ApplicationContextAware {

	private static ApplicationContext context;
	private static Map<String, Object> notificationMap;

	public static ApplicationContext getApplicationContext() {

		return context;
	}

	public static Map<String, Object> getApplicationmap() {

		return notificationMap;
	}

	public static void setApplicationmap(Map<String, Object> applicationmap) {

		LogicqContextProvider.notificationMap = applicationmap;
	}

	public void setApplicationContext(ApplicationContext appcontext) throws BeansException {

		context = appcontext;
		notificationMap = new HashMap<String, Object>();
	}
}
