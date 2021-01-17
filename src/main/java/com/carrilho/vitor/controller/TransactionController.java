package com.carrilho.vitor.controller;

import java.util.List;

import java.util.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrilho.vitor.domain.TotalAmount;
import com.carrilho.vitor.domain.Transaction;
import com.carrilho.vitor.service.TransactionService;

@RestController
@RequestMapping("api/v1/transactions")
public class TransactionController {
	
	private static final Logger logger = Logger.getLogger(TransactionController.class.getName());
	
	private final TransactionService transactionService;
	
	public TransactionController(final TransactionService transctionService) {
		this.transactionService = transctionService;		
	}
	
	@GetMapping("/accounts/{accountId}")
	public ResponseEntity<List<Transaction>> getTransactions(@PathVariable String accountId) {
		logger.info("action=getTransactions accountId="+accountId);
		List<Transaction> transactionList = transactionService.getByAccountId(accountId);		
		return ResponseEntity.ok(transactionList);
	}
	
	@GetMapping("/accounts/{accountId}/type/{transactionType}")
	public ResponseEntity<List<Transaction>> getTransactionsFilteredByType(@PathVariable String accountId, @PathVariable String transactionType) {
		logger.info("action=getTransactionsFilteredByType accountId="+accountId+" transactionType="+transactionType);
		List<Transaction> transactionList = transactionService.getByAccountIdAndType(accountId, transactionType);		
		return ResponseEntity.ok(transactionList);
	}
	
	@GetMapping("/accounts/{accountId}/type/{transactionType}/amount")
	public ResponseEntity<TotalAmount> getTotalAmountFilteredByType(@PathVariable String accountId, @PathVariable String transactionType) {
		logger.info("action=getTotalAmountFilteredByType accountId="+accountId+" transactionType="+transactionType);
		TotalAmount totalAmount = transactionService.getTotalAmount(accountId, transactionType);		
		return ResponseEntity.ok(totalAmount);
	}

}
