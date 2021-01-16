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
	public void test() {
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

}
