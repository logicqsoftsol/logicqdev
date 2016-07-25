package com.crm.logicq.test;

import java.time.LocalDateTime;
import java.util.Date;

import org.joda.time.DateTime;

public class TestDate {
	
	public static void main(String args[]){
		Date dt=new Date();
   //   LocalDateTime.from(dt.toInstant()).plusDays(1);	
	 
		DateTime dtOrg = new DateTime(dt);
		DateTime plusoneday = dtOrg.plusDays(1);
		
		//DateTime dtOrg = new DateTime(dt);
		//DateTime plusoneday = dtOrg.minusDays(1);
	
		System.out.println(plusoneday);
	}

}
