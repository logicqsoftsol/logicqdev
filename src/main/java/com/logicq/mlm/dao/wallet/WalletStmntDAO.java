package com.logicq.mlm.dao.wallet;

import org.springframework.stereotype.Repository;

import com.logicq.mlm.dao.AbstractDAO;
import com.logicq.mlm.model.wallet.WalletStatement;

@Repository
public class WalletStmntDAO extends AbstractDAO<WalletStatement> implements IWalletStmntDAO {

	@Override
	public WalletStatement fetchWalletStmntAccordingToAggregartion(WalletStatement walletStatement) throws Exception {
		StringBuilder query=new StringBuilder();
		query.append(" from WalletStatement ws where ws.walletid='"+walletStatement.getWalletid()+"'");
		return (WalletStatement) execcuteQuery(query.toString());
	}

	@Override
	public void addWalletStmnt(WalletStatement walletStatement) {
		save(walletStatement);
	}

	@Override
	public void updateWalletStmnt(WalletStatement walletStatement){
		update(walletStatement);
	}
	
	

}
