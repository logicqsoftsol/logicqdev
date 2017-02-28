package com.logicq.homeplus.common.vendor.sms;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PropertiesLoaderUtils;


@PropertySource("classpath:SMSVendor.properties")
public class SMSVendor {
	
   private static  SMSVendor instance=getInstance();
	
	@Value("smsvendor.url")
	public  String url;
	
	@Value("smsvendor.userid")
	public   String userid;
	
	@Value("smsvendor.password")
	public  String password;
	
	@Value("smsvendor.sid")
	public  String sid;
	
	@Value("smsvendor.flag")
	public  String flag;
	
	@Value("smsvendor.gwid")
	public  String gwid;
	
	@Value("admin.smsnumber")
	public  String adminmob;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getGwid() {
		return gwid;
	}
	public void setGwid(String gwid) {
		this.gwid = gwid;
	}

	public String getAdminmob() {
		return adminmob;
	}

	public void setAdminmob(String adminmob) {
		this.adminmob = adminmob;
	}

	private SMSVendor(){}
	
	public static SMSVendor getInstance() {
		try {
			if (null == instance) {
				instance = new SMSVendor();
				Properties prop = PropertiesLoaderUtils
						.loadAllProperties("SMSVendor.properties");
				
				setPropertyValue(instance,prop);
			}
		} catch (Exception ex) {
             ex.printStackTrace();
		}
		return instance;
	}
	
	private static void setPropertyValue(SMSVendor instance, Properties prop) throws Exception {
		Field[] fields = instance.getClass().getDeclaredFields();
		for (Field field : fields) {
			Annotation valueanotation = field.getAnnotation(Value.class);
			String propvalue=null;
			if(null!=valueanotation){
			propvalue = ((Value) valueanotation).value();
			}
			field.setAccessible(Boolean.TRUE);
			if (field.getType().isAssignableFrom(String.class)) {
				field.set(instance, (String) prop.get(propvalue));
			}
		}

	}

	
	@Override
	public String toString() {
		return "SMSVendor [url=" + url + ", userid=" + userid + ", password=" + password + ", sid=" + sid + ", flag="
				+ flag + ", gwid=" + gwid + ", adminmob=" + adminmob + "]";
	}

	

}
