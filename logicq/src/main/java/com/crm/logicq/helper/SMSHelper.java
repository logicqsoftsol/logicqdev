package com.crm.logicq.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.crm.logicq.common.vendor.sms.SMSVendor;
import com.crm.logicq.model.alert.SMSDetails;
import com.crm.logicq.model.communication.PhoneCommunication;
import com.crm.logicq.model.user.CardReadDetails;
import com.crm.logicq.model.user.User;
import com.crm.logicq.security.helper.StringFormatHelper;

public class SMSHelper {
	
	/**
	 * 
	 * @param user
	 * @param communication
	 * @param cardetails
	 * @return
	 */
	public static SMSDetails prepareSMSDetailsFromUser(String name, PhoneCommunication communication,
			CardReadDetails cardetails, String messageText) {
		SMSDetails smsdetails = new SMSDetails();
		ConcurrentMap<String,Object> concurrentMap = new ConcurrentHashMap<String,Object>();
		smsdetails.setMobileNumber(communication.getMobilenumber());
		smsdetails.setSmsdate(cardetails.getCardswappdate());
		smsdetails.setContactType(communication.getContactType());
		concurrentMap.put("Name", name);
		concurrentMap.put("InTime", cardetails.getIntime());
		concurrentMap.put("OutTime", cardetails.getOuttime());
		String text=formSMSText(concurrentMap, messageText);
		smsdetails.setText(text);
		return smsdetails;
	}
	
	/**
	 * 
	 * @param smsdetails
	 * @throws Exception
	 */
	public static void sendSMS(SMSDetails smsdetails) throws Exception {
		HttpURLConnection httpconnection=null;
		try{
			StringBuilder smsurldetails=formSMSURL(smsdetails);
			URL url = new URL(smsurldetails.toString());
			httpconnection = (HttpURLConnection) url.openConnection();
			httpconnection.setRequestMethod("GET");
			httpconnection.setRequestProperty("Accept", "application/json");
			smsLogStatus(httpconnection);
		}finally{
			httpconnection.disconnect();
		}
	

	}
/**
 * 
 * @param smsdetails
 * @return
 * @throws Exception
 */
	private static StringBuilder formSMSURL(SMSDetails smsdetails) throws Exception{
		StringBuilder urlString =new StringBuilder();
		urlString.append(SMSVendor.url);
		urlString.append("user="+SMSVendor.userid+"&");
		urlString.append("password="+SMSVendor.password+"&");
		urlString.append("msisdn="+smsdetails.getMobileNumber()+"&");
		urlString.append("sid="+SMSVendor.sid+"&");
		urlString.append("msg="+StringFormatHelper.formatStringForSMS(smsdetails.getText())+"&");
		urlString.append("fl="+SMSVendor.flag+"&");
		urlString.append("gwid="+SMSVendor.gwid);
		return urlString;
	}
	
	/**
	 * 
	 * @param conn
	 * @throws Exception
	 */
	public static void smsLogStatus(HttpURLConnection conn) throws Exception{
		if (conn.getResponseCode() != 200) {
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
				while ((output = br.readLine()) != null) {
							System.out.println(output);
				}
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
	}
	
	private static String formSMSText(ConcurrentMap<String, Object> concurrentMap, String text) {
		
		for(String key : concurrentMap.keySet()){
			text = text.replace("#"+key, String.valueOf(concurrentMap.get(key)));
		}
		return text.toString();

	}
}
