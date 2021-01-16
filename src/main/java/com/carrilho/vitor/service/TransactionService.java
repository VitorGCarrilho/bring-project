package com.carrilho.vitor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrilho.vitor.client.TransactionClient;
import com.carrilho.vitor.client.response.TransactionResponse;

@Service
public class TransactionService {
	
	private final TransactionClient transactionClient;
	
	@Autowired
	public TransactionService(TransactionClient transactionClient) {
		this.transactionClient = transactionClient;
	}
	
	public List<TransactionResponse> getByAccountId(String accountId) {
		return transactionClient
				.getTransctions(accountId)
				.getTransactions()
				.stream()
				.map(TransactionResponse::new)
				.collect(Collectors.toList());
	}

}
