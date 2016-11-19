package com.logicq.mlm.dao.wallet;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.logicq.mlm.dao.AbstractDAO;
import com.logicq.mlm.model.wallet.WalletStatement;

@Repository
public class WalletStmntDAO extends AbstractDAO<WalletStatement> implements IWalletStmntDAO {

	@Override
	public WalletStatement fetchWalletStmntAccordingToAggregartion(WalletStatement walletStatement) throws Exception {
		walletStatement.setCurrentbalance(new BigDecimal(60000.67));
		walletStatement.setMaxencashable(new BigDecimal(60000.67));
		walletStatement.setPayout(new BigDecimal(60000.67));
		walletStatement.setWalletid("SUD-7057014118");
		walletStatement.setWalletlastupdate(new Date());
		return walletStatement;
	}
	
	

}
