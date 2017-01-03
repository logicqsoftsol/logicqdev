package com.logicq.mlm.common.helper;

import java.math.BigDecimal;
import java.util.Date;

import com.logicq.mlm.model.wallet.WalletStatement;

public class WalletAmountCalculator {
	
	
	public static WalletStatement calculateCurrentBalance(WalletStatement walletstmnt){
		//Fetch amount according to level
	  BigDecimal currentbalance= walletstmnt.getCurrentbalance().add(new BigDecimal(60));
	  BigDecimal maxencashbalance= walletstmnt.getMaxencashable().add(new BigDecimal(60));
	  BigDecimal payoutbalance= walletstmnt.getPayout().add(new BigDecimal(60));
	  walletstmnt.setCurrentbalance(currentbalance);
	  walletstmnt.setMaxencashable(maxencashbalance);	
	  walletstmnt.setPayout(payoutbalance);
	  walletstmnt.setWalletlastupdate(new Date());
	  return walletstmnt;
	}

	public static WalletStatement calculateCurrentBalanceAfterEncashed(WalletStatement walletstmnt,BigDecimal enasedamount){
		//Fetch amount according to level
	  BigDecimal currentbalance= walletstmnt.getCurrentbalance().subtract(enasedamount);
	  BigDecimal maxencashbalance= walletstmnt.getMaxencashable().subtract(enasedamount);
	  BigDecimal payoutbalance= walletstmnt.getPayout().subtract(enasedamount);
	  walletstmnt.setCurrentbalance(currentbalance);
	  walletstmnt.setMaxencashable(maxencashbalance);	
	  walletstmnt.setPayout(payoutbalance);
	  walletstmnt.setWalletlastupdate(new Date());
	  return walletstmnt;
	}
	
}
