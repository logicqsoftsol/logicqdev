package com.crm.logicq.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LogicqContextProvider implements ApplicationContextAware {

	private static ApplicationContext context;
	private static Map<String, Object> conversationMap;
	private static Map<String, Object> employeeMap;
	private static Map<String, Object> studentMap;

	public void setApplicationContext(ApplicationContext appcontext) throws BeansException {

		context = appcontext;
		conversationMap = new HashMap<String, Object>();
		employeeMap = new HashMap<String, Object>();
		studentMap = new HashMap<String, Object>();
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
	
	public static Object getElementFromEmployeeMap(String key){
		Object element=null;
		if(employeeMap.containsKey(key)){
			element=employeeMap.get(key);
		}
	return element;
	}
	
	public static Object removeElementFromEmployeeMap(String key){
		Object element=null;
		if(employeeMap.containsKey(key)){
			element=employeeMap.remove(key);
		}
	return element;
	}

	public static void addElementToEmployeeMap(String key ,Object value){
		employeeMap.put(key, value);
	}
	
	public static Object getElementFromStudentMap(String key){
		Object element=null;
		if(studentMap.containsKey(key)){
			element=studentMap.get(key);
		}
	return element;
	}
	
	public static Object removeElementFromStudentMap(String key){
		Object element=null;
		if(studentMap.containsKey(key)){
			element=studentMap.remove(key);
		}
	return element;
	}

	public static void addElementToStudentMap(String key ,Object value){
		studentMap.put(key, value);
	}
}
