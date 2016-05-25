package com.logicq.logicq.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.beanutils.BeanUtils;

public class LogicqConversion {

	@SuppressWarnings("unchecked")
	public  static Object objectConversion(Object inputObject, Class outputClass) {

		Object bean = null;
		try {
			if (inputObject != null) {
				if (outputClass.isAnnotationPresent(ConvertClass.class)) {
					Field[] inputfields = inputObject.getClass().getDeclaredFields();
					Field[] fields = outputClass.getDeclaredFields();
					bean = outputClass.newInstance();
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
		} catch (Exception ex) {

		}

		return bean;
	}

	@SuppressWarnings("unchecked")
	public static Collection<?> objectConversionForList(Collection<?> inputlist, Class outputClass){
		
		Collection<Object> outputList = null;
		try {
			Field[] inputfields = null;
			for (Object inobject : inputlist) {
				if (outputClass.isAnnotationPresent(ConvertClass.class)) {
					if (null == inputfields) {
						inputfields = inobject.getClass().getDeclaredFields();
					}
					Field[] fields = outputClass.getDeclaredFields();
					Object bean;

					bean = outputClass.newInstance();

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
						outputList = new ArrayList<Object>();
					}
					outputList.add(bean);
				}
			}
		} catch (Exception e) {

		}
		return outputList;
	}

}
