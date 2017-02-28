package com.logicq.homeplus.helper;

import java.util.Properties;

public class PropertyHelper {
	
	public static Properties loadProperty(){
		Properties prop=new Properties();
		prop.put("filepath", "");
		return prop;
	}
	
	public static Properties loadMailProperty(){
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.port", 465);
		return props;
	}

}
