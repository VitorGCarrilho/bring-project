package com.carrilho.vitor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carrilho.vitor.client.response.TransactionResponse;
import com.carrilho.vitor.service.TransactionService;

@RestController
@RequestMapping("api/v1/transactions")
public class TransactionController {
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	private final TransactionService transactionService;
	
	public TransactionController(final TransactionService transctionService) {
		this.transactionService = transctionService;		
	}
	
	@GetMapping("/{accountId}")
	public ResponseEntity<List<TransactionResponse>> get(@PathVariable String accountId) {
		logger.info("receiving hello get");
		List<TransactionResponse> transactionList = transactionService.getByAccountId(accountId);		
		return ResponseEntity.ok(transactionList);
	}

}
