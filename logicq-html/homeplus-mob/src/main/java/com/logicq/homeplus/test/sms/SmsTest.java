package com.logicq.homeplus.test.sms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SmsTest {
	final static String URL_HOST="http://sms.hspsms.com";
	


	
	  public static String SMSSender(String user,String apikey,String sender,String service,String mobile,String message)
	    {
	        String strTemp = "";
	        try {
	            // Construct The Post Data
	            String data = "/sendSMS?username="+user;
	            data += "&" + "apikey="+apikey;
	            data += "&" + "smstype="+service;
	            data += "&" + "sendername="+sender;
	            data += "&" + "numbers="+mobile;
	            data += "&" + "message=" + URLEncoder.encode(message, "UTF-8");
	                        URL url = new URL(URL_HOST+data);
	                        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

	                          String line;
	                           while ((line = br.readLine()) != null) {

	                strTemp += line;
	            }

	                } catch (Exception ex) {
	                        ex.printStackTrace();
	                }


	        return  strTemp;
	    }
	  
	  public static void main(String[] args) {

	        String response = SMSSender("logicq softsol", "ce1ab1a0-0093-4063-8033-58c1f44b0cc2", "HOMPLS", "TRANS", "917057014118", "this issample message");
	        System.out.println(response);
	    }
}
