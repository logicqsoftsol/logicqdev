package com.crm.logicq.test;

import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.crm.logicq.common.vendor.sms.SMSVendor;

public class TestSMSProperty {

	
	public static void main(String args[]){
		SMSVendor instance = SMSVendor.getInstance();
		//System.out.println(instance);
	}
}
