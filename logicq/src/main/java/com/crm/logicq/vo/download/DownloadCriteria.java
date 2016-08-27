package com.crm.logicq.vo.download;

public class DownloadCriteria {
	private String reporttype;
	private String applicableto;
	private String uniqueid;
	private String exportfor;
	private String exporttype;
	public String getReporttype() {
		return reporttype;
	}
	public void setReporttype(String reporttype) {
		this.reporttype = reporttype;
	}
	public String getApplicableto() {
		return applicableto;
	}
	public void setApplicableto(String applicableto) {
		this.applicableto = applicableto;
	}
	public String getUniqueid() {
		return uniqueid;
	}
	public void setUniqueid(String uniqueid) {
		this.uniqueid = uniqueid;
	}
	public String getExportfor() {
		return exportfor;
	}
	public void setExportfor(String exportfor) {
		this.exportfor = exportfor;
	}
	public String getExporttype() {
		return exporttype;
	}
	public void setExporttype(String exporttype) {
		this.exporttype = exporttype;
	}
	
	@Override
	public String toString() {
		return "DownloadCriteria [reporttype=" + reporttype + ", applicableto=" + applicableto + ", uniqueid="
				+ uniqueid + ", exportfor=" + exportfor + ", exporttype=" + exporttype + "]";
	}
	
	

}
