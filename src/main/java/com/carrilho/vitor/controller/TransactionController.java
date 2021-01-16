package com.carrilho.vitor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrilho.vitor.dto.TransactionsDTO;
import com.carrilho.vitor.service.TransactionService;

@RestController
@RequestMapping("api/v1/transactions")
public class TransactionController {
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	private final TransactionService transactionService;
	
	public TransactionController(final TransactionService transctionService) {
		this.transactionService = transctionService;		
	}
	
	@GetMapping
	public ResponseEntity<TransactionsDTO> get() {
		logger.info("receiving hello get");
		TransactionsDTO value = transactionService.findAll();		
		return ResponseEntity.ok(value);
	}

}
