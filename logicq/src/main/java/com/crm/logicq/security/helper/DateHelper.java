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
	
	public static Date convertStringtoDate(String inputdate) throws ParseException{
		return dateFormat.parse(inputdate);
	}
	

	public static Date convertDateAccordingToString(String datestring) throws Exception {
     Date simpledate=null;
		if (!StringUtil.isEmpty(datestring)) {
			String formatdatestring=datestring.replaceFirst("Last","").trim();
			Date sysdate = new Date();
			DateTime formateddate = new DateTime(sysdate);
			if (formatdatestring.contains("hours")) {
				String stringhour = formatdatestring.replace("hours", "").trim();
				int hour = Integer.valueOf(stringhour);
				simpledate=formateddate.minusHours(hour).toDate();
			}
			if (formatdatestring.contains("days")) {
				String stringdays = formatdatestring.replace("days", "").trim();
				int days = Integer.valueOf(stringdays);
				simpledate=formateddate.minusDays(days).toDate();
			}
			if (formatdatestring.contains("weeks")) {
				String stringweeks = formatdatestring.replace("weeks", "").trim();
				int weeks = Integer.valueOf(stringweeks);
				simpledate=formateddate.minusWeeks(weeks).toDate();
			}
			if (formatdatestring.contains("months")) {
				String stringmonths = formatdatestring.replace("months", "").trim();
				int months = Integer.valueOf(stringmonths);
				simpledate=formateddate.minusWeeks(months).toDate();
			}
			if (formatdatestring.contains("years")) {
				String stringyears = formatdatestring.replace("years", "").trim();
				int years = Integer.valueOf(stringyears);
				simpledate= formateddate.minusWeeks(years).toDate();
			
			}
			
		}
		
		return simpledate;
	}	
}
