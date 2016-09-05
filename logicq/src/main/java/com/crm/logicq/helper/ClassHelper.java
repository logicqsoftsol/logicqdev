package com.crm.logicq.helper;

import java.lang.reflect.Field;

public class ClassHelper {

	public static void undefinedCheck(Object inputobj) throws Exception {
		Field[] fields = inputobj.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(Boolean.TRUE);
			Object value = field.get(inputobj);
			if (null != value && value.equals("undefined")) {
				field.set(inputobj, null);
			}
		}
	}
	
}
