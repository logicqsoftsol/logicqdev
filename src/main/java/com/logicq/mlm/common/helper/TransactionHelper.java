package com.logicq.mlm.common.helper;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.logicq.mlm.model.admin.TransactionDetails;
import com.logicq.mlm.model.wallet.WalletStatement;
import com.logicq.mlm.service.wallet.ITransactionDetailsService;
import com.logicq.mlm.service.wallet.IWalletStmntService;

@Component
public class TransactionHelper {

	@Autowired
	IWalletStmntService walletservice;
	
	@Autowired
	ITransactionDetailsService transactionDetailsService;
	
	public void debitFromWallet(WalletStatement walletstment, BigDecimal amount, TransactionDetails txnDetails)
			throws Exception {
		int comapreValue = walletstment.getCurrentbalance().compareTo(amount);
		if (comapreValue == 1 || comapreValue==0) {
			walletstment.setCurrentbalance(walletstment.getCurrentbalance().subtract(amount));
			walletstment.setMaxencashable(walletstment.getMaxencashable().subtract(amount));
			walletstment.setPayout(walletstment.getPayout().subtract(amount));
			walletstment.setWalletlastupdate(new Date());
			walletservice.updateWalletStmnt(walletstment);
			transactionDetailsService.save(txnDetails);
		} else {
			throw new Exception("Insufficient balance for ");
		}
	}

	public void creditToWallet(WalletStatement walletstment,BigDecimal amount, TransactionDetails txnDetails) throws Exception {
		walletstment.setCurrentbalance(walletstment.getCurrentbalance().subtract(amount));
		walletstment.setMaxencashable(walletstment.getMaxencashable().subtract(amount));
		walletstment.setPayout(walletstment.getPayout().subtract(amount));
		walletstment.setWalletlastupdate(new Date());
		walletservice.updateWalletStmnt(walletstment);
		transactionDetailsService.save(txnDetails);
	}


}
