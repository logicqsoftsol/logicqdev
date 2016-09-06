package com.logicq.electionmgm.model.common;

import java.io.Serializable;

public class CommonProperty implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8978381770742166074L;
	
	private int pagenumber;
	private int pagesize;
	private int totalrecordcount;
	
	
	public int getPagenumber() {
		return pagenumber;
	}
	public void setPagenumber(int pagenumber) {
		this.pagenumber = pagenumber;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getTotalrecordcount() {
		return totalrecordcount;
	}
	public void setTotalrecordcount(int totalrecordcount) {
		this.totalrecordcount = totalrecordcount;
	}
	
	@Override
	public String toString() {
		return "CommonProperty [pagenumber=" + pagenumber + ", pagesize=" + pagesize + ", totalrecordcount="
				+ totalrecordcount + "]";
	}
	
	
	

}
