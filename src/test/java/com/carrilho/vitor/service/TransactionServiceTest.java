package com.carrilho.vitor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.carrilho.vitor.client.TransactionClient;
import com.carrilho.vitor.client.domain.TotalAmount;
import com.carrilho.vitor.client.domain.Transaction;
import com.carrilho.vitor.controller.helper.SampleFactory;
import com.carrilho.vitor.dto.TransactionDTO;
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
		List<Transaction> transactionList = transactionService.getByAccountId(accountId);
		
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
		List<Transaction> responseA = transactionService.getByAccountIdAndType(accountId, typeA);
		List<Transaction> responseB = transactionService.getByAccountIdAndType(accountId, typeB);
		List<Transaction> responseC = transactionService.getByAccountIdAndType(accountId, typeC);
		List<Transaction> responseD = transactionService.getByAccountIdAndType(accountId, typeD);
		
		// THEN
		assertEquals(2, responseA.size());
		assertEquals(1, responseB.size());
		assertEquals(0, responseC.size());
		assertEquals(1, responseD.size());
		
		
	}
	
	@Test
	public void getTotalAmount() {
		// GIVEN
		String accountId = "10";
		String type = "TYPE";
		String myId = "My_id";
		TransactionsDTO transactionsDTO = SampleFactory.sampleTransactionsDTO();		
		
		TransactionDTO t1 = SampleFactory.sampleTransaction(accountId, type);
		t1.getDetails().getValue().setAmount(BigDecimal.valueOf(10L));		
		t1.getThisAccount().setId(myId);
		TransactionDTO t2 = SampleFactory.sampleTransaction(accountId, type);
		t2.getDetails().getValue().setAmount(BigDecimal.valueOf(15L));
		t2.getThisAccount().setId(myId);
		
		transactionsDTO.getTransactions().add(t1);
		transactionsDTO.getTransactions().add(t2);	
		
		// WHEN
		when(transactionClient.getTransctions(accountId)).thenReturn(transactionsDTO);
		TotalAmount totalAmount = transactionService.getTotalAmount(accountId, type);
		
		// THEN
		assertEquals(BigDecimal.valueOf(25), totalAmount.getValue());
		assertEquals(myId, totalAmount.getAccountId());
		
	}

}
