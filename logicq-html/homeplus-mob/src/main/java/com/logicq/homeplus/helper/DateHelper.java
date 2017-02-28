package com.logicq.homeplus.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.util.StringUtils;

/**
 * 
 * @author SudhanshuLenka
 *
 */
public class DateHelper {
	final static Logger logger = Logger.getLogger(DateHelper.class);
	final static DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
	final static DateFormat dateFormatwithtime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	final static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * THsi method convert String to date 
	 * @param datestring
	 * @return
	 */
	public static Date convertStringToDate(String datestring) {
		try {
			String currentdate = null;
			if (!StringUtils.isEmpty(datestring) && datestring.contains("/")) {
				currentdate = datestring.replace("/", "-");
			} else {
				currentdate = datestring;
			}
			return dateFormat.parse(currentdate);
		} catch (ParseException ex) {
			logger.error(" Unable to parse string to date : Date String " + datestring, ex);
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
	
	
	
	public static Date getDateAccordingToInterval(String dateinterval) {
		LocalDateTime inputDate=null;
		if(!StringUtils.isEmpty(dateinterval) ){
			if (dateinterval.startsWith("LAST")) {
				if (dateinterval.contains("HOUR")) {
					String hour = dateinterval.replace("LAST", "").replace("HOUR", "").trim();
					inputDate = LocalDateTime.now().minusHours(Integer.valueOf(hour));
				}
				if (dateinterval.contains("DAYS")) {
					String day = dateinterval.replace("LAST", "").replace("DAYS", "").trim();
					inputDate = LocalDateTime.now().minusDays(Integer.valueOf(day));
				}
				if (dateinterval.contains("MONTHS")) {
					String month = dateinterval.replace("LAST", "").replace("MONTHS", "").trim();
					inputDate = LocalDateTime.now().minusMonths(Integer.valueOf(month));
				}
			}
		}
	return inputDate.toDate();
	}
}
