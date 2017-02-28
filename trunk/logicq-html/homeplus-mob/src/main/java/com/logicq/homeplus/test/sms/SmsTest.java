package com.logicq.homeplus.test.sms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SmsTest {
	
	public static void main(String[] args) {
		sendSMS();
	}
	
	public static boolean sendSMS(){

		HttpURLConnection httpconnection=null;
		try{
			StringBuilder smsurldetails=formSMSURL();
			
			URL url = new URL(smsurldetails.toString());
			httpconnection = (HttpURLConnection) url.openConnection();
			httpconnection.setRequestMethod("GET");
			httpconnection.setRequestProperty("Accept", "application/json");
			return smsLogStatus(httpconnection);
		}catch(Exception ex){
			ex.printStackTrace();
			
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
	private static StringBuilder formSMSURL() throws Exception{
		StringBuilder urlString =new StringBuilder();
		urlString.append("http://sudhanshulenka.com/vendorsms/pushsms.aspx?");
		urlString.append("user="+"logicqsoftsol"+"&");
		urlString.append("password="+"babu@0701402098"+"&");
		urlString.append("msisdn="+"7057014118"+"&");
		urlString.append("sid="+"HOMPLS"+"&");
		urlString.append("msg="+"Demo"+"&");
		urlString.append("fl="+"0"+"&");
		urlString.append("gwid="+2);
		System.out.println(urlString.toString());
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
				return false;
			}
		}
		return true;
	}
}
