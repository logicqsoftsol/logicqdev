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

	
	public static Date convertStringtoDate(String inputdate) throws ParseException{
		return dateFormat.parse(inputdate);
	}
	

	public static Date convertDateAccordingToString(String datestring) {

		if (!StringUtil.isEmpty(datestring)) {
			Date sysdate = new Date();
			DateTime formateddate = new DateTime(sysdate);
			if (datestring.contains("hours")) {
				String stringhour = datestring.replace("hours", "").trim();
				int hour = Integer.valueOf(stringhour);
				return formateddate.minusHours(hour).toDate();
			}
			if (datestring.contains("days")) {
				String stringdays = datestring.replace("days", "").trim();
				int days = Integer.valueOf(stringdays);
				return formateddate.minusDays(days).toDate();
			}
			if (datestring.contains("weeks")) {
				String stringweeks = datestring.replace("weeks", "").trim();
				int weeks = Integer.valueOf(stringweeks);
				return formateddate.minusWeeks(weeks).toDate();
			}
			if (datestring.contains("months")) {
				String stringmonths = datestring.replace("months", "").trim();
				int months = Integer.valueOf(stringmonths);
				return formateddate.minusWeeks(months).toDate();
			}
			if (datestring.contains("years")) {
				String stringyears = datestring.replace("years", "").trim();
				int years = Integer.valueOf(stringyears);
				return formateddate.minusWeeks(years).toDate();
			}
		}

		return null;
	}	
}
