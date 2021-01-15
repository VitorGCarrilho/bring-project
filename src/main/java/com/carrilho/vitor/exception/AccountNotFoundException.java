package com.carrilho.vitor.exception;

public class AccountNotFoundException extends RuntimeException{
	
	public AccountNotFoundException(String message) {
		super(message);
	}

}
