package com.logicq.mlm.dao.wallet;

import com.logicq.mlm.model.wallet.WalletStatement;

public interface IWalletStmntDAO {
	
	WalletStatement fetchWalletStmntAccordingToAggregartion(WalletStatement walletStatement) throws Exception;

}
