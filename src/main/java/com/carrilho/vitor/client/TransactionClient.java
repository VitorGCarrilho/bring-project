package com.carrilho.vitor.client;

import com.carrilho.vitor.dto.TransactionsDTO;

import feign.Param;
import feign.RequestLine;

public interface TransactionClient {

	@RequestLine("GET /v1.2.1/banks/rbs/accounts/{accountId}/public/transactions")
	TransactionsDTO getTransctions(@Param("accountId") String accountId);

}
