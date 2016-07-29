package com.crm.logicq.common.vendor.sms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:SMSVendor.properties")
public class SMSVendor {
	
	@Value("${smsvendor.url}")
	public static String url="http://login.cheapsmsbazaar.com/vendorsms/pushsms.aspx?";
	
	@Value("${smsvendor.userid}")
	public static String userid="logicqsoftsol";
	
	@Value("${smsvendor.password}")
	public static String password="babu@0701402098";
	
	@Value("${smsvendor.sid}")
	public static String sid="LOGICQ";
	
	@Value("${smsvendor.flag}")
	public static int flag=0;
	
	@Value("${smsvendor.gwid}")
	public static int gwid=2;

	public String getUrl() {
		return url;
	}


	public String getUserid() {
		return userid;
	}

	
	public String getPassword() {
		return password;
	}

	
	public String getSid() {
		return sid;
	}


	public int getFlag() {
		return flag;
	}

	public int getGwid() {
		return gwid;
	}

	
	@Override
	public String toString() {
		return "SMSVendor [url=" + url + ", userid=" + userid + ", password=" + password + ", sid=" + sid + ", flag="
				+ flag + ", gwid=" + gwid + "]";
	}
	
	
	

}
