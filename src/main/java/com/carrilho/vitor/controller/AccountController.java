package com.carrilho.vitor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrilho.vitor.exception.AccountNotFoundException;

@RestController
@RequestMapping("bank")
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@GetMapping
	public String get() {
		logger.info("receiving hello get");
		System.out.println("Test print \n");
		throw new AccountNotFoundException("account for user 10 not found");
	}

}
