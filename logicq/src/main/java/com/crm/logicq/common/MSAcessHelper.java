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


@Repository
@PropertySource("classpath:MSAcessConnection.properties")
public class MSAcessHelper {
	
	private static Connection msacessconnectio=null;
	
	@Value("${msacess.drivername}")
	private String drivername;
	@Value("${msacess.url}")
	private String url;
	@Value("${msacess.databasepath}")
	private String dbpath;
	
	@Value("${msacess.password}")
	private String password;
	
	
	
	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDbpath() {
		return dbpath;
	}

	public void setDbpath(String dbpath) {
		this.dbpath = dbpath;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@PostConstruct
	public void msAcessConnection() throws Exception {
		Class.forName(drivername);
		msacessconnectio=DriverManager.getConnection(url, "", password);
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
