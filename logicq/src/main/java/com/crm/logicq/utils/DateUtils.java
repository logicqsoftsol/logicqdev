package com.crm.logicq.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.crm.logicq.security.service.UserService;
/**
 * 
 * @author SudhanshuLenka
 *
 */
public class DateUtils {
	final static Logger logger = Logger.getLogger(DateUtils.class);
	
	/**
	 * THsi method convert String to date 
	 * @param datestring
	 * @return
	 */
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

	/**
	 * This method convert date to string.
	 * @param inputdate
	 * @return
	 */
	public static String convertDateToString(Date inputdate) {
		String converteddate = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		converteddate = dateFormat.format(inputdate);
		return converteddate;
	}

}
