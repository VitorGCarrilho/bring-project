package com.carrilho.vitor.client;

import com.carrilho.vitor.dto.TransactionsDTO;

import feign.RequestLine;

public interface TransactionClient {

	@RequestLine("GET ")
	TransactionsDTO getTransctions();

}
