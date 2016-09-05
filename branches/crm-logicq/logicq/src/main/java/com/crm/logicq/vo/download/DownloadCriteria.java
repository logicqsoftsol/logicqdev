package com.crm.logicq.vo.download;

import java.util.Date;

public class DownloadCriteria {
	private String reporttype;
	private String reportname;
	private String reportof;
	private Date fromdate;
	private Date todate;
	private String applicableto;
	private String exporttype;
	public String getReporttype() {
		return reporttype;
	}
	public void setReporttype(String reporttype) {
		this.reporttype = reporttype;
	}
	public String getReportname() {
		return reportname;
	}
	public void setReportname(String reportname) {
		this.reportname = reportname;
	}
	public String getReportof() {
		return reportof;
	}
	public void setReportof(String reportof) {
		this.reportof = reportof;
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
	public String getApplicableto() {
		return applicableto;
	}
	public void setApplicableto(String applicableto) {
		this.applicableto = applicableto;
	}
	public String getExporttype() {
		return exporttype;
	}
	public void setExporttype(String exporttype) {
		this.exporttype = exporttype;
	}
	
	
	@Override
	public String toString() {
		return "DownloadCriteria [reporttype=" + reporttype + ", reportname=" + reportname + ", reportof=" + reportof
				+ ", fromdate=" + fromdate + ", todate=" + todate + ", applicableto=" + applicableto + ", exporttype="
				+ exporttype + "]";
	}
	
	

}
