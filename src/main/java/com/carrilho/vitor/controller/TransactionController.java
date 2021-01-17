package com.carrilho.vitor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrilho.vitor.client.domain.TotalAmount;
import com.carrilho.vitor.client.domain.Transaction;
import com.carrilho.vitor.service.TransactionService;

@RestController
@RequestMapping("api/v1/transactions")
public class TransactionController {
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	private final TransactionService transactionService;
	
	public TransactionController(final TransactionService transctionService) {
		this.transactionService = transctionService;		
	}
	
	@GetMapping("/accounts/{accountId}")
	public ResponseEntity<List<Transaction>> getTransactions(@PathVariable String accountId) {
		logger.info("action=getTransactions accountId={}", accountId);
		List<Transaction> transactionList = transactionService.getByAccountId(accountId);		
		return ResponseEntity.ok(transactionList);
	}
	
	@GetMapping("/accounts/{accountId}/type/{transactionType}")
	public ResponseEntity<List<Transaction>> getTransactionsFilteredByType(@PathVariable String accountId, @PathVariable String transactionType) {
		logger.info("action=getTransactionsFilteredByType accountId={} transactionType={}", accountId, transactionType);
		List<Transaction> transactionList = transactionService.getByAccountIdAndType(accountId, transactionType);		
		return ResponseEntity.ok(transactionList);
	}
	
	@GetMapping("/accounts/{accountId}/type/{transactionType}/amount")
	public ResponseEntity<TotalAmount> getTotalAmountFilteredByType(@PathVariable String accountId, @PathVariable String transactionType) {
		logger.info("action=getTotalAmountFilteredByType accountId={} transactionType={}", accountId, transactionType);
		TotalAmount totalAmount = transactionService.getTotalAmount(accountId, transactionType);		
		return ResponseEntity.ok(totalAmount);
	}

}
