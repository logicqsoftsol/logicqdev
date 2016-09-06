package com.logicq.electionmgm.security.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.hsqldb.lib.StringUtil;

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

	public static List<String> getSMSTemplateKey(String smstemplate) {
		List<String> keytokens = new ArrayList<String>();
		StringTokenizer smskeytokens = new StringTokenizer(smstemplate);
		while (smskeytokens.hasMoreTokens()) {
			String key = smskeytokens.nextToken();
			if (!StringUtil.isEmpty(key) && key.startsWith("#")) {
				key = key.replace("#", "").trim();
				keytokens.add(key);
			}
		}
		return keytokens;
	}
	
}
