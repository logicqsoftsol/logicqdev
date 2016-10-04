package com.logicq.commonproject.helper;

import java.util.Properties;

public class PropertyHelper {
	
	public static Properties loadProperty(){
		Properties prop=new Properties();
		prop.put("filepath", "");
		return prop;
	}

}
