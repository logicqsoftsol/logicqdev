package com.crm.logicq.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class LogicqContextProvider implements ApplicationContextAware {

	private static ApplicationContext context;
	private static Map<String, Object> conversationMap;

	public void setApplicationContext(ApplicationContext appcontext) throws BeansException {

		context = appcontext;
		conversationMap = new HashMap<String, Object>();
	}
	
	public static ApplicationContext getApplicationContext() {

		return context;
	}
	
	public static Object getElementFromApplicationMap(String key){
		Object element=null;
		if(conversationMap.containsKey(key)){
			element=conversationMap.get(key);
		}
	return element;
	}
	
	public static Object removeElementFromApplicationMap(String key){
		Object element=null;
		if(conversationMap.containsKey(key)){
			element=conversationMap.remove(key);
		}
	return element;
	}

	public static void addElementToApplicationMap(String key ,Object value){
		conversationMap.put(key, value);
	}
	
	
}
