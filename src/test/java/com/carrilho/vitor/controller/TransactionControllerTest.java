package com.carrilho.vitor.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.carrilho.vitor.client.response.TransactionResponse;
import com.carrilho.vitor.controller.helper.SampleFactory;
import com.carrilho.vitor.service.TransactionService;

@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {
	
	@Mock
	private TransactionService transactionService;
	
	@InjectMocks
	private TransactionController transactionController;
	
	@Test
	public void getByIdTest() {
		// GIVEN
		String accountId = "10";
		List<TransactionResponse> transactionList = SampleFactory.sampleTransactionResponseList(accountId, "TYPE_A");
		
		
		// WHEN
		when(transactionService.getByAccountId(accountId)).thenReturn(transactionList);
		ResponseEntity<List<TransactionResponse>> response = transactionController.getTransactions(accountId);
		
		
		// THEN
		verify(transactionService).getByAccountId(accountId);
		assertEquals(response.getBody(), transactionList);
		assertEquals(response.getStatusCode(), HttpStatus.OK);		
	}
	
	@Test
	public void getByIdAndTypeTest() {
		// GIVEN
		String accountId = "10";
		String type = "TYPE_A";
		List<TransactionResponse> transactionList = SampleFactory.sampleTransactionResponseList(accountId, type);
		
		
		// WHEN
		when(transactionService.getByAccountIdAndType(accountId, type)).thenReturn(transactionList);
		ResponseEntity<List<TransactionResponse>> response = transactionController.getTransactionsFilteredByType(accountId, type);
		
		
		// THEN
		verify(transactionService).getByAccountIdAndType(accountId, type);
		assertEquals(response.getBody(), transactionList);
		assertEquals(response.getStatusCode(), HttpStatus.OK);		
	}

}
