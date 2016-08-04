package com.crm.logicq.common;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@PropertySource("classpath:MSAcessConnection.properties")
@Repository
public class MSAcessHelper {
	
	private static Connection msacessconnectio=null;
	
	@Value("${msacess.drivername}")
	private String drivername;
	@Value("${msacess.url}")
	private String url;
	@Value("${msacess.databasepath}")
	private String dbpath;
	
	@PostConstruct
	public void msAcessConnection() throws Exception {
		url="jdbc:ucanaccess://F:/Project/workspace/logicq-client/crm-logicq/logicq/src/main/resources/ontime_att.mdb;READONLY=true";
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		msacessconnectio=DriverManager.getConnection(url, "", "sss");
	}
	
	private Statement createStatement() throws Exception {
		return msacessconnectio.createStatement();
	}
	
	private ResultSet executeQueryWithResultSet(String query) throws Exception {
		Statement stmnt = createStatement();
		stmnt.execute(query);
		return stmnt.getResultSet();
	}
	
	public List<?> executeQuery(String query, Class claz) throws Exception {
		ResultSet resultset = executeQueryWithResultSet(query);
		List<Object> result = new ArrayList<Object>();
		Field[] fields = claz.getDeclaredFields();
		while ((resultset != null) && (resultset.next())) {
			Object newObject = claz.newInstance();
			for (Field field : fields) {
			 String fieldname=field.getAnnotation(MSColumn.class).name();
			 field.setAccessible(Boolean.TRUE);
				if (field.getType().isAssignableFrom(Integer.class)) {
					field.set(newObject, resultset.getInt(fieldname));
				}
				if (field.getType().isAssignableFrom(String.class)) {
					field.set(newObject, resultset.getString(fieldname));
				}
				if (field.getType().isAssignableFrom(Date.class)) {
					field.set(newObject, resultset.getTimestamp(fieldname));
				}
			}
			result.add(newObject);
		}
		return result;

	}
}
