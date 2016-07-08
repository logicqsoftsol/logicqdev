package com.crm.logicq.security.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
	
	private static  DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	
	public static String convertDatetoString(Date inputdate){
		return dateFormat.format(inputdate);
	}

	
	public static Date convertStringtoDate(String inputdate) throws ParseException{
		return dateFormat.parse(inputdate);
	}
}
