package com.logicq.mlm.service.wallet;

import java.util.List;

import com.logicq.mlm.model.admin.TransactionDetails;

public interface ITransactionDetailsService {
	
	void save(TransactionDetails transactionDetails);
	List<TransactionDetails> getTransactionDetails(String username);

}
