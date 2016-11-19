package com.logicq.mlm.service.wallet;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logicq.mlm.dao.wallet.WalletStmntDAO;
import com.logicq.mlm.model.wallet.WalletStatement;

@Service
@Transactional
public class WalletStmntService  implements IWalletStmntService{

	@Autowired
	WalletStmntDAO walletStmntDAO;
	
	
	@Override
	public WalletStatement fetchWalletStmntAccordingToAggregartion(WalletStatement walletStatement) throws Exception {
		
		
		return walletStmntDAO.fetchWalletStmntAccordingToAggregartion(walletStatement);
	}

}
