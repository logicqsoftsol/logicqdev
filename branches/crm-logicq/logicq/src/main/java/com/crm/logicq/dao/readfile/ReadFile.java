package com.crm.logicq.dao.readfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crm.logicq.model.CardReadDetails;
@Service("ReadFile")
public class ReadFile {
	public List<CardReadDetails> readAccessFileInTime() {

		List<CardReadDetails> list = new ArrayList<CardReadDetails>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			//Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/NIHAR/Documents/CARDINFO.accdb");
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/new/logicq/src/main/resources/CARDINFO.accdb");
			Statement s = conn.createStatement();
			String selTable = "SELECT CARDID,INTIME,INPUTDATE FROM CARDINFO";
			s.execute(selTable);
			ResultSet rs = s.getResultSet();
			while ((rs != null) && (rs.next())) {
				System.out.println(rs.getInt("CARDID"));
				System.out.println(rs.getInt("INTIME"));
				System.out.println(rs.getDate("INPUTDATE"));
				CardReadDetails cardDetails = new CardReadDetails();
				cardDetails.setCardid(rs.getInt("CARDID"));
				cardDetails.setIntime(rs.getInt("INTIME"));
				list.add(cardDetails);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<CardReadDetails> readAccessFileOutTime() {

		List<CardReadDetails> list = new ArrayList<CardReadDetails>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/new/logicq/src/main/resources/CARDINFO.accdb");
			Statement s = conn.createStatement();
			String selTable = "SELECT CARDID,INTIME,OUTTIME,INPUTDATE FROM CARDINFO";
			s.execute(selTable);
			ResultSet rs = s.getResultSet();
			while ((rs != null) && (rs.next())) {
				System.out.println(rs.getInt("CARDID"));
				System.out.println(rs.getInt("INTIME"));
				System.out.println(rs.getInt("OUTTIME"));
				System.out.println(rs.getDate("INPUTDATE"));
				CardReadDetails cardDetails = new CardReadDetails();
				cardDetails.setCardid(rs.getInt("CARDID"));
				cardDetails.setIntime(rs.getInt("INTIME"));
				cardDetails.setOuttime(rs.getInt("OUTTIME"));
				list.add(cardDetails);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void specialJob() {
          System.out.println("define special job");
          //Database Query to get all special jobs
		 
	}
}
/**
 * NIHAR 04-Jul-2016 1:28:39 am
 */
