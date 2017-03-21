package com.logicq.mlm.dao.wallet;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.logicq.mlm.dao.AbstractDAO;
import com.logicq.mlm.model.admin.TransactionDetails;

@Repository
public class TransactionDetailsDAO extends AbstractDAO<TransactionDetails> implements ITransactionDetailsDAO{

	@Override
	public void saveTransactionDetails(TransactionDetails transactionDetails) {
	   save(transactionDetails);
		
	}

	@Override
	public List<TransactionDetails> getTransactionDetails(String walletid) {
		StringBuilder selectQuery=new StringBuilder();
		selectQuery.append(" from TransactionDetails where walletid='"+walletid+"' order by txndate desc");
		return (List<TransactionDetails>) executeQueryWithPagination(selectQuery.toString(),1,20);
	}

	@Override
	public List<TransactionDetails> getTransactionDetailsAccordingToRefrenceNumber(String refrenceNumber) {
		StringBuilder selectQuery=new StringBuilder();
		selectQuery.append(" from TransactionDetails where refrenceno='"+refrenceNumber+"'");
		return (List<TransactionDetails>) execcuteQuery(selectQuery.toString());
	}

}
