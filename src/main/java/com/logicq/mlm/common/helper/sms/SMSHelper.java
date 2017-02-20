package com.logicq.mlm.common.helper.sms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;

import com.logicq.mlm.common.helper.StringFormatHelper;
import com.logicq.mlm.common.vendor.sms.SMSVendor;
import com.logicq.mlm.model.sms.SMSDetails;

public class SMSHelper {
	private final static Logger logger = Logger.getLogger(SMSHelper.class);
	private final static  SMSVendor smsvendor=SMSVendor.getInstance();
	
	/**
	 * 
	 * @param smsdetails
	 * @throws Exception 
	 * @throws Exception
	 */
	public static boolean sendSMS(SMSDetails smsdetails){

		HttpURLConnection httpconnection=null;
		try{
			StringBuilder smsurldetails=formSMSURL(smsdetails);
			
			URL url = new URL(smsurldetails.toString());
			httpconnection = (HttpURLConnection) url.openConnection();
			httpconnection.setRequestMethod("GET");
			httpconnection.setRequestProperty("Accept", "application/json");
			return smsLogStatus(httpconnection);
		}catch(Exception ex){
			logger.error("From  SMS URL Details "+ex.getMessage(),ex);
			
		}
		finally{
			if(null!=httpconnection){
			httpconnection.disconnect();
			}
		}
	
		return false;
	}
/**
 * 
 * @param smsdetails
 * @return
 * @throws Exception
 */
	private static StringBuilder formSMSURL(SMSDetails smsdetails) throws Exception{
		StringBuilder urlString =new StringBuilder();
		urlString.append(smsvendor.getUrl());
		urlString.append("user="+smsvendor.getUserid()+"&");
		urlString.append("password="+smsvendor.getPassword()+"&");
		urlString.append("msisdn="+smsdetails.getMobilenumber()+"&");
		urlString.append("sid="+smsvendor.getSid()+"&");
		urlString.append("msg="+StringFormatHelper.formatStringForSMS(smsdetails.getMessage())+"&");
		urlString.append("fl="+smsvendor.getFlag()+"&");
		urlString.append("gwid="+smsvendor.getGwid());
		return urlString;
	}
	
	/**
	 * 
	 * @param conn
	 * @throws Exception
	 */
	public static boolean smsLogStatus(HttpURLConnection conn) throws Exception {
		if (conn.getResponseCode() != 200) {
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			while ((output = br.readLine()) != null) {
				return true;
			}
		}
		return false;
	}
}