package com.crm.logicq.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.crm.logicq.model.alert.SMSDetails;
import com.crm.logicq.model.communication.PhoneCommunication;
import com.crm.logicq.model.user.CardReadDetails;
import com.crm.logicq.model.user.User;

public class SMSHelper {
	
	
	public static SMSDetails prepareSMSDetailsFromUser(User user, PhoneCommunication communication,
			CardReadDetails cardetails) {
		SMSDetails smsdetails = new SMSDetails();
		smsdetails.setMobileNumber(communication.getMobilenumber());
		smsdetails.setFirstName(user.getFirstName());
		smsdetails.setLastName(user.getLastName());
		smsdetails.setSmsdate(cardetails.getCardswappdate());
		smsdetails.setIntime(cardetails.getIntime());
		smsdetails.setOuttime(cardetails.getOuttime());
		smsdetails.setContactType(communication.getContactType());
		return smsdetails;
	}
	
	public static void sendSMS(SMSDetails smsdetails) {

		try {
			StringBuilder string =new StringBuilder();
			string.append("http://login.cheapsmsbazaar.com/vendorsms/pushsms.aspx?user=demo&password=demo&");
			string.append("msisdn=").append(smsdetails.getMobileNumber()).append("&sid=DEMOOO&msg=").append(smsdetails.getText().trim()).append("%20message&fl=0&gwid=2");
		//	URL url = new URL(
		//			"http://login.cheapsmsbazaar.com/vendorsms/pushsms.aspx?user=demo&password=demo&msisdn=917276484647&sid=DEMOOO&msg=test%20message&fl=0&gwid=2");
			
			URL url = new URL(string.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
