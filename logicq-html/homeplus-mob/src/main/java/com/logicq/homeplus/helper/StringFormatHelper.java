package com.logicq.homeplus.helper;

import java.util.StringTokenizer;

public class StringFormatHelper {

	private static final String SMS_MESSAGE_FORMAT_FOR_VENDOR = "%20";

	public static String formatStringForSMS(String message) {
		StringBuilder smsMsgString = new StringBuilder();
		StringTokenizer tokens = new StringTokenizer(message);
		while (tokens.hasMoreTokens()) {
			smsMsgString.append(tokens.nextToken() + SMS_MESSAGE_FORMAT_FOR_VENDOR);
		}
		return smsMsgString.toString();
	}

	
}
