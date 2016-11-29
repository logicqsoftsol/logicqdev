package com.logicq.mlm.vo;

import com.logicq.mlm.model.performance.UserPerformance;
import com.logicq.mlm.model.profile.NetWorkDetails;
import com.logicq.mlm.model.profile.UserProfile;
import com.logicq.mlm.model.wallet.WalletStatement;

public class UserDetailsVO extends StatusVO {
	
	private UserProfile userprofile;
	
	private WalletStatement walletStatement;
	
	private UserPerformance userperformance;
	
	private NetWorkDetails networkjson;

	public UserProfile getUserprofile() {
		return userprofile;
	}

	public void setUserprofile(UserProfile userprofile) {
		this.userprofile = userprofile;
	}

	public WalletStatement getWalletStatement() {
		return walletStatement;
	}

	public void setWalletStatement(WalletStatement walletStatement) {
		this.walletStatement = walletStatement;
	}

	public UserPerformance getUserperformance() {
		return userperformance;
	}

	public void setUserperformance(UserPerformance userperformance) {
		this.userperformance = userperformance;
	}

	public NetWorkDetails getNetworkjson() {
		return networkjson;
	}

	public void setNetworkjson(NetWorkDetails networkjson) {
		this.networkjson = networkjson;
	}

	@Override
	public String toString() {
		return "UserDetailsVO [userprofile=" + userprofile + ", walletStatement=" + walletStatement
				+ ", userperformance=" + userperformance + ", networkjson=" + networkjson + "]";
	}

	
	
}
