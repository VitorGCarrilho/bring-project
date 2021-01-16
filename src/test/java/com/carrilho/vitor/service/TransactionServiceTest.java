package com.carrilho.vitor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.carrilho.vitor.client.TransactionClient;
import com.carrilho.vitor.client.response.TransactionResponse;
import com.carrilho.vitor.controller.helper.SampleFactory;
import com.carrilho.vitor.dto.TransactionsDTO;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {
	
	@Mock
	private TransactionClient transactionClient;
	
	@InjectMocks
	private TransactionService transactionService;
	
	@Test
	public void getByIdTest() {
		// GIVEN
		String accountId = "10";
		TransactionsDTO transactionsDTO = SampleFactory.sampleTransactionsDTO();
		
		
		// WHEN
		when(transactionClient.getTransctions(accountId)).thenReturn(transactionsDTO);
		List<TransactionResponse> transactionList = transactionService.getByAccountId(accountId);
		
		// THEN
		assertEquals(transactionsDTO.getTransactions().size(), transactionList.size());
		for (int i=0; i< transactionsDTO.getTransactions().size(); i++) {
			assertEquals(transactionsDTO.getTransactions().get(i).getId(), transactionList.get(i).getId());
		}
		
	}
	
	@Test
	public void getByIdAndType() {
		// GIVEN
		String accountId = "10";
		String typeA = "TYPE_A";
		String typeB = "TYPE_B";
		String typeC = "TYPE_C";
		String typeD = "TYPE_D";
		TransactionsDTO transactionsDTO = SampleFactory.sampleTransactionsDTO();
		
		
		// WHEN
		when(transactionClient.getTransctions(accountId)).thenReturn(transactionsDTO);
		List<TransactionResponse> responseA = transactionService.getByAccountIdAndType(accountId, typeA);
		List<TransactionResponse> responseB = transactionService.getByAccountIdAndType(accountId, typeB);
		List<TransactionResponse> responseC = transactionService.getByAccountIdAndType(accountId, typeC);
		List<TransactionResponse> responseD = transactionService.getByAccountIdAndType(accountId, typeD);
		
		// THEN
		assertEquals(2, responseA.size());
		assertEquals(1, responseB.size());
		assertEquals(0, responseC.size());
		assertEquals(1, responseD.size());
		
		
	}

}
