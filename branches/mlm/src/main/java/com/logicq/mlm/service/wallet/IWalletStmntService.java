package com.logicq.mlm.service.wallet;

import com.logicq.mlm.model.profile.WalletDetails;
import com.logicq.mlm.model.wallet.WalletStatement;

public interface IWalletStmntService {

	WalletStatement fetchWalletStmntAccordingToAggregartion(WalletStatement walletStatement) throws Exception;
	
	void addWalletStmnt(WalletStatement walletStatement);
	
	void updateWalletStmnt(WalletStatement walletStatement) throws Exception;
	
     void createWallet(WalletDetails walletdetails);
	
	 WalletDetails fetchWalletDetails(WalletDetails walletdetails);
	
}
