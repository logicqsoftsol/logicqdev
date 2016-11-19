package com.logicq.mlm.service.wallet;

import com.logicq.mlm.model.wallet.WalletStatement;

public interface IWalletStmntService {

	WalletStatement fetchWalletStmntAccordingToAggregartion(WalletStatement walletStatement) throws Exception;
	
}
