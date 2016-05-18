package com.logicq.logicq.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.logicq.logicq.service.user.impl.UserService;

public class DateUtils {
	final static Logger logger = Logger.getLogger(UserService.class);
	
	public static Date convertStringToDate(String datestring){
		Date converteddate = null;

		try {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			converteddate = df.parse(datestring);
		} catch (ParseException ex) {
			logger.error(" Unable to parse string to date : Date String " +datestring,ex);
		}
		return converteddate;
	}

	
	public static String convertDateToString(Date inputdate) {
		String converteddate = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		converteddate = dateFormat.format(inputdate);
		return converteddate;
	}

}
