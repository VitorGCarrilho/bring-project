package com.carrilho.vitor.service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrilho.vitor.client.TransactionClient;
import com.carrilho.vitor.domain.TotalAmount;
import com.carrilho.vitor.domain.Transaction;

@Service
public class TransactionService {
	
	private static final Logger logger = Logger.getLogger(TransactionService.class.getName());
	
	private final TransactionClient transactionClient;
	
	@Autowired
	public TransactionService(TransactionClient transactionClient) {
		this.transactionClient = transactionClient;
	}
	
	public List<Transaction> getByAccountId(String accountId) {
		logger.info("action=getByAccountId accountId="+accountId);
		return transactionClient
				.getTransctions(accountId)
				.getTransactions()
				.stream()
				.map(Transaction::new)
				.collect(Collectors.toList());
	}
	
	public List<Transaction> getByAccountIdAndType(String accountId, String type) {
		logger.info("action=getByAccountIdAndType accountId=" + accountId +" type="+ type);
		List<Transaction> response = getByAccountId(accountId);
		response.removeIf(transaction -> !transaction.getTransactionType().equals(type));
		return response;		
	}
	
	public TotalAmount getTotalAmount(String accountId, String type) {
		logger.info("action=getTotalAmount accountId=" + accountId +" type="+ type);
				
		return transactionClient
			.getTransctions(accountId)
			.getTransactions()
			.stream()
			.map(Transaction::new)
			.filter(t -> t.getTransactionType().equals(type))
			.reduce(new TotalAmount(), TotalAmount::addTransaction, TotalAmount::sum);
	}

}
