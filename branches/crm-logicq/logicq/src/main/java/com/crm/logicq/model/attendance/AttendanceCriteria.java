package com.crm.logicq.model.attendance;

import java.util.Date;

import com.crm.logicq.model.common.CommonProperty;

public class AttendanceCriteria extends CommonProperty {
	private String userid;
	private String mobileno;
	private String cardno;
	private Date fromdate;
	private Date todate;
	private String applicablefor;
	private String reporttype;
	private String reportFor;
	private String applicableto;
	private String className;
	private String sectionName;
	private String exporttype;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public Date getFromdate() {
		return fromdate;
	}
	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}
	public Date getTodate() {
		return todate;
	}
	public void setTodate(Date todate) {
		this.todate = todate;
	}
	public String getApplicablefor() {
		return applicablefor;
	}
	public void setApplicablefor(String applicablefor) {
		this.applicablefor = applicablefor;
	}
	
	
    public String getReporttype() {
    
    	return reporttype;
    }
	
    public void setReporttype(String reporttype) {
    
    	this.reporttype = reporttype;
    }
	
    public String getReportFor() {
    
    	return reportFor;
    }
	
    public void setReportFor(String reportFor) {
    
    	this.reportFor = reportFor;
    }
	
    public String getApplicableto() {
    
    	return applicableto;
    }
	
    public void setApplicableto(String applicableto) {
    
    	this.applicableto = applicableto;
    }
	
    public String getClassName() {
    
    	return className;
    }
	
    public void setClassName(String className) {
    
    	this.className = className;
    }
	
    public String getSectionName() {
    
    	return sectionName;
    }
	
    public void setSectionName(String sectionName) {
    
    	this.sectionName = sectionName;
    }
	
    public String getExporttype() {
    
    	return exporttype;
    }
	
    public void setExporttype(String exporttype) {
    
    	this.exporttype = exporttype;
    }
	@Override
	public String toString() {
		return "AttendanceCriteria [userid=" + userid + ", mobileno=" + mobileno + ", cardno=" + cardno + ", fromdate="
				+ fromdate + ", todate=" + todate + ", applicablefor=" + applicablefor + "]";
	}

	
}
