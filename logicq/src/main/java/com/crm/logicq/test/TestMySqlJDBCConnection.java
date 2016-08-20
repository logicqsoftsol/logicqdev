 
package com.crm.logicq.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//import com.crm.logicq.model.login.Login;

 

public class TestMySqlJDBCConnection {
	
	public static void main(String[] args) {
		Connection conn = null;
		
		try{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection	msacessconnectio=DriverManager.getConnection("jdbc:ucanaccess://F:/Project/workspace/test/ontime_att.mdb;READONLY=true", "", "sss");
	   System.out.println(msacessconnectio);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		 
		try {
			
			
		    conn =DriverManager.getConnection("jdbc:mysql://45.113.136.152:3306/docathouse_locigq", "logicqdb", "logicq123");
		     
		    //Never possible : Because my code running in different system
		      // DriverManager.getConnection("jdbc:mysql://localhost:3306/docathou_prod?user=docathou_prod&password=J-(=N9zd1vD)");

		    System.out.println("conn is "+conn);

   	 

		    // Do something with the Connection

		   
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
}


/**
NIHAR
02-Jan-2016
12:33:01 am
*/