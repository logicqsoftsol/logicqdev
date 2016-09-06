 
package com.logicq.electionmgm.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.logicq.electionmgm.model.login.Login;

 

public class TestMySqlJDBCConnection {
	
	public static void main(String[] args) {
		Connection conn = null;
		final SessionFactory factory;
		 
		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sakila?" + "user=root&password=root");
System.out.println("conn is "+conn);

   	  factory=new Configuration().configure().buildSessionFactory();
   	  Session session=factory.openSession();
   	  
   	  Transaction tx=session.beginTransaction();
   	Criteria cr = session.createCriteria(Login.class);
   	
   	List employees = cr.list();
   	
   	System.out.println("list is "+employees);

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