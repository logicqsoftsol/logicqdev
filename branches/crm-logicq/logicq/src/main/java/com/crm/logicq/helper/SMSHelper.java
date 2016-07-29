package com.crm.logicq.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.crm.logicq.common.vendor.sms.SMSVendor;
import com.crm.logicq.constant.SMSType;
import com.crm.logicq.model.alert.SMSDetails;
import com.crm.logicq.model.communication.PhoneCommunication;
import com.crm.logicq.model.user.CardReadDetails;
import com.crm.logicq.model.user.User;
import com.crm.logicq.security.helper.StringFormatHelper;
import com.crm.logicq.service.event.impl.EventService;
import com.crm.logicq.ui.alert.NotificationParamVO;
import com.crm.logicq.vo.user.UserVO;


public class SMSHelper {
	private final static Logger logger = Logger.getLogger(SMSHelper.class);
 
	/**
	 * 
	 * @param user
	 * @param communication
	 * @param cardetails
	 * @return
	 * @throws Exception 
	 */
	public static SMSDetails prepareSMSDetailsFromUser(UserVO userdetails,
			CardReadDetails cardetails, String templaet,List<String> templatekeys) throws Exception {
		SMSDetails smsdetails = new SMSDetails();
		NotificationParamVO paramvo=new NotificationParamVO();
		paramvo.setIntime(String.valueOf(cardetails.getIntime()));
		paramvo.setOuttime(String.valueOf(cardetails.getOuttime()));
		paramvo.setName(userdetails.getFirstName());
		smsdetails.setMobileNumber(userdetails.getMobilenumber());
		smsdetails.setSmsdate(cardetails.getCardswappdate());
		smsdetails.setType(SMSType.ATTENDANCE);
		String text=formSMSText(paramvo,templaet,templatekeys);
		smsdetails.setText(text);
		return smsdetails;
	}
	
	/**
	 * 
	 * @param smsdetails
	 * @throws Exception 
	 * @throws Exception
	 */
	public static SMSDetails sendSMS(SMSDetails smsdetails) throws Exception{
		
		HttpURLConnection httpconnection=null;
		try{
			StringBuilder smsurldetails=formSMSURL(smsdetails);
			URL url = new URL(smsurldetails.toString());
			httpconnection = (HttpURLConnection) url.openConnection();
			httpconnection.setRequestMethod("GET");
			httpconnection.setRequestProperty("Accept", "application/json");
			smsLogStatus(httpconnection,smsdetails);
		}
		finally{
			httpconnection.disconnect();
		}
	
		return smsdetails;
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
	public static void smsLogStatus(HttpURLConnection conn,SMSDetails smsdetails) throws Exception{
		if (conn.getResponseCode() != 200) {
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
				while ((output = br.readLine()) != null) {
					smsdetails.setStatus(output);
					smsdetails.setStatuscode(String.valueOf(conn.getResponseCode()));
				}
		}
	}
	
	private static String formSMSText(NotificationParamVO parameter, String template,List<String> templatekeys) throws Exception {
		
		for(String tempkey:templatekeys){
		Field field = parameter.getClass().getDeclaredField(tempkey);
		field.setAccessible(Boolean.TRUE);
	    String keyvalue=String.valueOf(field.get(parameter)) ;
	    template=template.replace("#"+tempkey, keyvalue);
		};
		return template;

	}
}
