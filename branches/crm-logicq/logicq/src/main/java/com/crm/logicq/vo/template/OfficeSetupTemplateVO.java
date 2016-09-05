package com.crm.logicq.vo.template;

public class OfficeSetupTemplateVO {
	
	//These values are temporary hard code need to setup from data base.
	private String entityname="Vikash Convent School";
	private String entityemail="info@vcs.com";
	private String entityaddresses=" Karanjia, Odisha 757037 ";
	private String contactdetails=" 0675-2445670";
	private String faxnumber=" 001-23456";
	private String webaddress="www.vcs.in";
	public String getEntityname() {
		return entityname;
	}
	public void setEntityname(String entityname) {
		this.entityname = entityname;
	}
	public String getEntityemail() {
		return entityemail;
	}
	public void setEntityemail(String entityemail) {
		this.entityemail = entityemail;
	}
	public String getEntityaddresses() {
		return entityaddresses;
	}
	public void setEntityaddresses(String entityaddresses) {
		this.entityaddresses = entityaddresses;
	}
	public String getContactdetails() {
		return contactdetails;
	}
	public void setContactdetails(String contactdetails) {
		this.contactdetails = contactdetails;
	}
	public String getFaxnumber() {
		return faxnumber;
	}
	public void setFaxnumber(String faxnumber) {
		this.faxnumber = faxnumber;
	}
	public String getWebaddress() {
		return webaddress;
	}
	public void setWebaddress(String webaddress) {
		this.webaddress = webaddress;
	}
	
	@Override
	public String toString() {
		return "OfficeSetupTemplateVO [entityname=" + entityname + ", entityemail=" + entityemail + ", entityaddresses="
				+ entityaddresses + ", contactdetails=" + contactdetails + ", faxnumber=" + faxnumber + ", webaddress="
				+ webaddress + "]";
	}
	
	

}
