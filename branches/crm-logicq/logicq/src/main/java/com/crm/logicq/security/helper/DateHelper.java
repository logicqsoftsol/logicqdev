package com.crm.logicq.security.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hsqldb.lib.StringUtil;
import org.joda.time.DateTime;

public class DateHelper {
	
	private static  DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	
	public static String convertDatetoString(Date inputdate){
		return dateFormat.format(inputdate);
	}

	public static String convertDatetoStringWituoutTime(Date inputdate){
		return new SimpleDateFormat("yyyy-MM-dd").format(inputdate);
	}
	
	public static String convertTodayDatetoStringWituoutTime(){
		return new SimpleDateFormat("dd-mm-yyyy").format(new Date());
	}
	
	public static Date convertStringtoDate(String inputdate) throws ParseException{
		return dateFormat.parse(inputdate);
	}
	

	public static Date convertDateAccordingToString(String datestring) throws Exception {
     Date simpledate=null;
		if (!StringUtil.isEmpty(datestring)) {
			String formatdatestring = null;
			if (datestring.contains("Last")) {
				formatdatestring = datestring.replaceFirst("Last", "").trim();
				
			} else if (datestring.contains("Next")) {
				formatdatestring = datestring.replaceFirst("Next", "").trim();
			}
			DateTime formateddate = new DateTime(new Date());
			if (formatdatestring.contains("hours")) {
				String stringhour = formatdatestring.replace("hours", "").trim();
				int hour = Integer.valueOf(stringhour);
				if (datestring.contains("Last")) {
				simpledate=formateddate.minusHours(hour).toDate();
				}
				if (datestring.contains("Next")){
					simpledate=formateddate.plusHours(hour).toDate();
				}
			}
			if (formatdatestring.contains("days")) {
				String stringdays = formatdatestring.replace("days", "").trim();
				int days = Integer.valueOf(stringdays);
				if (datestring.contains("Last")) {
					simpledate = formateddate.minusDays(days).toDate();
				}
				if (datestring.contains("Next")) {
					simpledate = formateddate.plusDays(days).toDate();
				}
			}
			if (formatdatestring.contains("weeks")) {
				String stringweeks = formatdatestring.replace("weeks", "").trim();
				int weeks = Integer.valueOf(stringweeks);
				if (datestring.contains("Last")) {
					simpledate = formateddate.minusWeeks(weeks).toDate();
				}
				if (datestring.contains("Next")) {
					simpledate = formateddate.plusWeeks(weeks).toDate();
				}
			}
			if (formatdatestring.contains("months")) {
				String stringmonths = formatdatestring.replace("months", "").trim();
				int months = Integer.valueOf(stringmonths);
				if (datestring.contains("Last")) {
					simpledate = formateddate.minusMonths(months).toDate();
				}
				if (datestring.contains("Next")) {
					simpledate = formateddate.plusMonths(months).toDate();
				}
			}
			if (formatdatestring.contains("years")) {
				String stringyears = formatdatestring.replace("years", "").trim();
				int years = Integer.valueOf(stringyears);
				if (datestring.contains("Last")) {
					simpledate = formateddate.minusYears(years).toDate();
				}
				if (datestring.contains("Next")) {
					simpledate = formateddate.plusYears(years).toDate();
				}
			}
			
		}
		
		return simpledate;
	}	
}
