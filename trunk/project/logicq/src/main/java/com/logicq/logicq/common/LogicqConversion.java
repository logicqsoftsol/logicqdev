package com.logicq.logicq.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;


public class LogicqConversion<T> {

	
	@SuppressWarnings("unchecked")
	public T objectConversion(Object inputObject, Class outputClass){
 
		T bean = null;
		try{
		if (inputObject != null) {
			if (outputClass.isAnnotationPresent(ConvertClass.class)) {
				Field[] inputfields = inputObject.getClass().getDeclaredFields();
				Field[] fields = outputClass.getDeclaredFields();
				bean = (T) outputClass.newInstance();
				for (Field inputfield : inputfields) {
					inputfield.setAccessible(Boolean.TRUE);
					String columnName = inputfield.getName();
					Object columnValue = inputfield.get(inputObject);
					for (Field field : fields) {
						if (columnName.equalsIgnoreCase(field.getName()) && columnValue != null) {
							BeanUtils.setProperty(bean, field.getName(), columnValue);
							break;
						}

					}
				}

			}
		}
		}catch(Exception ex){
			
		}
		
		return bean;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<T> objectConversionForList(Collection<?> inputlist, Class outputClass) throws Exception {
		Collection<T> outputList = null;
		Field[] inputfields = null;
		for(Object inobject:inputlist){
			if (outputClass.isAnnotationPresent(ConvertClass.class)) {
				if (null == inputfields) {
					inputfields = inobject.getClass().getDeclaredFields();
				}
				Field[] fields = outputClass.getDeclaredFields();
				T bean = (T) outputClass.newInstance();
				for (Field inputfield : inputfields) {
					inputfield.setAccessible(Boolean.TRUE);
					String columnName = inputfield.getName();
					Object columnValue = inputfield.get(inobject);
					for (Field field : fields) {
						if (columnName.equalsIgnoreCase(field.getName()) && columnValue != null) {
							BeanUtils.setProperty(bean, field.getName(), columnValue);
							break;
						}

					}
				}
				if (outputList == null) {
					outputList = new ArrayList<T>();
				}
				outputList.add(bean);
			}
		}
		return outputList;
	}


}
