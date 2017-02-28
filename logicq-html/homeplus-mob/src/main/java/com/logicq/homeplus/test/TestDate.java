package com.logicq.homeplus.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	
	public static void main(String args[]) throws Exception{
		 SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy");
			String currentdate="10/10/2016".replace("/", "-");
		 Date date=dateformat.parse(currentdate);
		 System.out.println(date );
	}

}
