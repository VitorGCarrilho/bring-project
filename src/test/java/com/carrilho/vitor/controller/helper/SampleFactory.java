package com.carrilho.vitor.controller.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.carrilho.vitor.client.response.TransactionResponse;
import com.carrilho.vitor.dto.AccountDTO;
import com.carrilho.vitor.dto.DetailsDTO;
import com.carrilho.vitor.dto.HolderDTO;
import com.carrilho.vitor.dto.MetadataDTO;
import com.carrilho.vitor.dto.TransactionDTO;
import com.carrilho.vitor.dto.TransactionsDTO;
import com.carrilho.vitor.dto.ValueDTO;

public class SampleFactory {
	
	public static TransactionDTO sampleTransaction(String transactionId, String transactionType) {
		ValueDTO value = new ValueDTO();
		value.setAmount(BigDecimal.TEN);
		value.setCurrency("BRL");
		
		DetailsDTO details = new DetailsDTO();
		details.setType(transactionType);
		details.setDescription("payment");
		details.setValue(value);
		
		HolderDTO holder = new HolderDTO();
		holder.setName("My name");
		
		MetadataDTO metadata = new MetadataDTO();
		metadata.setImageUrl("url");
		
		
		AccountDTO thisAccount = new AccountDTO();
		thisAccount.setId("Xpto");
		
		AccountDTO otherAccount = new AccountDTO();
		otherAccount.setNumber("123");
		otherAccount.setHolder(holder);
		otherAccount.setMetadata(metadata);
		
		
		TransactionDTO transaction = new TransactionDTO();
		transaction.setId(transactionId);
		transaction.setDetails(details);
		transaction.setThisAccount(thisAccount);
		transaction.setOtherAccount(otherAccount);
		
		return transaction;
	}
	
	public static TransactionsDTO sampleTransactionsDTO() {
		List<TransactionDTO> transactionList = new ArrayList<>();
		transactionList.add(sampleTransaction("1", "TYPE_A"));
		transactionList.add(sampleTransaction("2", "TYPE_B"));
		transactionList.add(sampleTransaction("3", "TYPE_A"));
		transactionList.add(sampleTransaction("4", "TYPE_D"));
		
		TransactionsDTO transactions = new TransactionsDTO();
		transactions.setTransactions(transactionList);
		
		return transactions; 
	}
	
	public static List<TransactionResponse> sampleTransactionResponseList(String transactionId, String transactionType) {
		return Arrays.asList(new TransactionResponse(sampleTransaction(transactionId, transactionType)));
	}

}
