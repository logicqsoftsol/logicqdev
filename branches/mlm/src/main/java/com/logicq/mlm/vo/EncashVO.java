package com.logicq.mlm.vo;

import java.math.BigDecimal;
import java.util.Date;

public class EncashVO extends StatusVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2275774364728648409L;
	private String wallentnumber;
	private BigDecimal encashamount;
	private String walletid;
	private Date requestdate;
	private String username;
	private String encashtype;
	private String refrencenumber;

	public String getWallentnumber() {
		return wallentnumber;
	}
	public void setWallentnumber(String wallentnumber) {
		this.wallentnumber = wallentnumber;
	}
	public BigDecimal getEncashamount() {
		return encashamount;
	}
	public void setEncashamount(BigDecimal encashamount) {
		this.encashamount = encashamount;
	}
	public String getWalletid() {
		return walletid;
	}
	public void setWalletid(String walletid) {
		this.walletid = walletid;
	}
	public Date getRequestdate() {
		return requestdate;
	}
	public void setRequestdate(Date requestdate) {
		this.requestdate = requestdate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEncashtype() {
		return encashtype;
	}
	public void setEncashtype(String encashtype) {
		this.encashtype = encashtype;
	}
	public String getRefrencenumber() {
		return refrencenumber;
	}
	public void setRefrencenumber(String refrencenumber) {
		this.refrencenumber = refrencenumber;
	}
	
	@Override
	public String toString() {
		return "EncashVO [wallentnumber=" + wallentnumber + ", encashamount=" + encashamount + ", walletid=" + walletid
				+ ", requestdate=" + requestdate + ", username=" + username + ", encashtype=" + encashtype
				+ ", refrencenumber=" + refrencenumber + "]";
	}
	
	


}
