package com.logicq.logicq.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class LogicqConversion {

	@SuppressWarnings("unchecked")
	public  static Object objectConversion(Object inputObject, Class outputClass) {

		Object bean = null;
		try {
			if (inputObject != null) {
				if (outputClass.isAnnotationPresent(ConvertClass.class)) {
					String columnName = null;
					Object columnValue = null;
					Field[] inputfields = inputObject.getClass().getDeclaredFields();
					Field[] parentinputfields = inputObject.getClass().getSuperclass().getDeclaredFields();
					Map<String, Object> allfieldmap = new HashMap<String, Object>();
					for (Field inputfield : parentinputfields) {
						inputfield.setAccessible(Boolean.TRUE);
						columnName = inputfield.getName();
						columnValue = inputfield.get(inputObject);
						allfieldmap.put(columnName, columnValue);
					}
					for (Field inputfield : inputfields) {
						inputfield.setAccessible(Boolean.TRUE);
						columnName = inputfield.getName();
						columnValue = inputfield.get(inputObject);
						allfieldmap.put(columnName, columnValue);
					}
					Field[] fields = outputClass.getDeclaredFields();
					bean = outputClass.newInstance();
					if (null != allfieldmap && !allfieldmap.isEmpty()) {
						for (Field field : fields) {
							if (allfieldmap.containsKey(field.getName())) {
								BeanUtils.setProperty(bean, field.getName(), allfieldmap.get(field.getName()));
							}

						}

					}

				}
			}
		} catch (Exception ex) {
			System.out.println("fail");

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
