package com.crm.logicq.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	
	public static void main(String args[]){
	//	DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
		//String	converteddate = dateFormat.format(new Date());
		
		//DateTime dtOrg = new DateTime(dt);
		//DateTime plusoneday = dtOrg.minusDays(1);
	
		//System.out.println(converteddate);
//		try{
//		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//		Connection	msacessconnectio=DriverManager.getConnection("jdbc:ucanaccess://F:/Project/workspace/test/ontime_att.mdb;READONLY=true", "", "sss");
//	   System.out.println(msacessconnectio);
//		}catch(Exception ex){
//			ex.printStackTrace();
//		}
		
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
        System.out.println(simpleDateformat.format(new Date()));
	
	
	}

}
