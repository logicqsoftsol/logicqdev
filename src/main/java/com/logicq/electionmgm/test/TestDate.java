package com.logicq.electionmgm.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	
	public static void main(String args[]){
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
		String	converteddate = dateFormat.format(new Date());
		
		//DateTime dtOrg = new DateTime(dt);
		//DateTime plusoneday = dtOrg.minusDays(1);
	
		System.out.println(converteddate);
	}

}
