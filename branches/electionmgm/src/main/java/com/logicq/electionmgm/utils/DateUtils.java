package com.logicq.electionmgm.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 
 * @author SudhanshuLenka
 *
 */
public class DateUtils {
	final static Logger logger = Logger.getLogger(DateUtils.class);
	final static DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
	final static DateFormat dateFormatwithtime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	final static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	/**
	 * THsi method convert String to date 
	 * @param datestring
	 * @return
	 */
	public static Date convertStringToDate(String datestring){
		try {
			return dateFormat.parse(datestring);
		} catch (ParseException ex) {
			logger.error(" Unable to parse string to date : Date String " +datestring,ex);
		}
		return null;
	}

	/**
	 * This method convert date to string.
	 * @param inputdate
	 * @return
	 */
	public static String convertDateToString(Date inputdate) {
		return dateFormatwithtime.format(inputdate);
	}

	
	public static String getTimeFromDate(Date inputdate) {
		return timeFormat.format(inputdate);
	}
}
