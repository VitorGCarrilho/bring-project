package com.carrilho.vitor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrilho.vitor.client.TransactionClient;
import com.carrilho.vitor.dto.TransactionsDTO;

@Service
public class TransactionService {
	
	private final TransactionClient transactionClient;
	
	@Autowired
	public TransactionService(TransactionClient transactionClient) {
		this.transactionClient = transactionClient;
	}
	
	public TransactionsDTO findAll() {
		return transactionClient.getTransctions();
	}

}
