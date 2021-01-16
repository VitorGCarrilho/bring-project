package com.carrilho.vitor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<String> get() {
		logger.info("receiving hello get");
		String value = transactionService.findAll();		
		return ResponseEntity.ok(value);
	}
	
	@GetMapping("teste")
	public ResponseEntity<String> test() {
		logger.info("receiving hello get");
		String value = transactionService.findAll();		
		return ResponseEntity.ok(value);
	}

}
