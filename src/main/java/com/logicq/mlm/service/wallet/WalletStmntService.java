package com.logicq.mlm.service.wallet;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logicq.mlm.dao.wallet.IWalletDetailsDAO;
import com.logicq.mlm.dao.wallet.IWalletStmntDAO;
import com.logicq.mlm.dao.wallet.WalletStmntDAO;
import com.logicq.mlm.model.profile.WalletDetails;
import com.logicq.mlm.model.wallet.WalletStatement;

@Service
@Transactional
public class WalletStmntService  implements IWalletStmntService{

	@Autowired
	IWalletStmntDAO walletStmntDAO;
	
	@Autowired
	IWalletDetailsDAO walletDetailsDAO;
	
	
	@Override
	public WalletStatement fetchWalletStmntAccordingToAggregartion(WalletStatement walletStatement) throws Exception {
		
		
		return walletStmntDAO.fetchWalletStmntAccordingToAggregartion(walletStatement);
	}


	@Override
	public void createWallet(WalletDetails walletdetails) {
		walletDetailsDAO.createWallet(walletdetails);
	}


	@Override
	public WalletDetails fetchWalletDetails(WalletDetails walletdetails) {
		return walletDetailsDAO.fetchWalletDetails(walletdetails);
	}


	@Override
	public void addWalletStmnt(WalletStatement walletStatement) {
		walletStmntDAO.addWalletStmnt(walletStatement);
	}


	@Override
	public void updateWalletStmnt(WalletStatement walletStatement) throws Exception {
		walletStmntDAO.updateWalletStmnt(walletStatement);
	}

}
