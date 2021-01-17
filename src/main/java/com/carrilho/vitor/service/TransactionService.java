package com.carrilho.vitor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrilho.vitor.client.TransactionClient;
import com.carrilho.vitor.client.domain.TotalAmount;
import com.carrilho.vitor.client.domain.Transaction;

@Service
public class TransactionService {
	
	private final TransactionClient transactionClient;
	
	@Autowired
	public TransactionService(TransactionClient transactionClient) {
		this.transactionClient = transactionClient;
	}
	
	public List<Transaction> getByAccountId(String accountId) {
		return transactionClient
				.getTransctions(accountId)
				.getTransactions()
				.stream()
				.map(Transaction::new)
				.collect(Collectors.toList());
	}
	
	public List<Transaction> getByAccountIdAndType(String accountId, String Type) {
		List<Transaction> response = getByAccountId(accountId);
		response.removeIf(transaction -> !transaction.getTransactionType().equals(Type));
		return response;		
	}
	
	public TotalAmount getTotalAmount(String accountId, String type) {
		TotalAmount zeroTotalAmount = new TotalAmount();
		
		return transactionClient
			.getTransctions(accountId)
			.getTransactions()
			.stream()
			.map(Transaction::new)
			.filter(t -> t.getTransactionType().equals(type))
			.reduce(zeroTotalAmount, TotalAmount::addTransaction, TotalAmount::sum);
	}

}
