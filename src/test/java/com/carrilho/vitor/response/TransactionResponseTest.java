package com.carrilho.vitor.response;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.carrilho.vitor.client.response.TransactionResponse;
import com.carrilho.vitor.controller.helper.SampleFactory;
import com.carrilho.vitor.dto.TransactionDTO;

@ExtendWith(MockitoExtension.class)
public class TransactionResponseTest {

	@Test
	public void shouldSetTheFiledsGivenAnDTO() {
		// GIVEN
		String accountId = "10";
		TransactionDTO dto = SampleFactory.sampleTransaction(accountId, "TYPE");

		// WHEN
		TransactionResponse response = new TransactionResponse(dto);

		// THEN
		assertEquals(dto.getId(), response.getId());
		assertEquals(dto.getThisAccount().getId(), response.getAccountId());
		assertEquals(dto.getOtherAccount().getNumber(), response.getCouterPartyAccount());
		assertEquals(dto.getOtherAccount().getHolder().getName(), response.getCounterPartyName());
		assertEquals(dto.getOtherAccount().getMetadata().getImageUrl(), response.getCounterPartyLogo());
		assertEquals(dto.getDetails().getValue().getAmount(), response.getInstructedAmount());
		assertEquals(dto.getDetails().getValue().getAmount(), response.getTransactionAmount());
		assertEquals(dto.getDetails().getValue().getCurrency(), response.getInstructedCurrency());
		assertEquals(dto.getDetails().getValue().getCurrency(), response.getTransactionCurrency());
		assertEquals(dto.getDetails().getType(), response.getTransactionType());
		assertEquals(dto.getDetails().getDescription(), response.getDescription());
	}

	@Test
	public void shouldNotThrowExceptionOnThisAccountNull() {

		// GIVEN
		String accountId = "10";
		TransactionDTO dto = SampleFactory.sampleTransaction(accountId, "TYPE");
		dto.setThisAccount(null);

		// THEN		
		
		assertDoesNotThrow(() -> {
			new TransactionResponse(dto);
		});

	}
	
	@Test
	public void shouldNotThrowExceptionOnOtherAccountNull() {

		// GIVEN
		String accountId = "10";
		TransactionDTO dto = SampleFactory.sampleTransaction(accountId, "TYPE");
		dto.setOtherAccount(null);

		// THEN		
		
		assertDoesNotThrow(() -> {
			new TransactionResponse(dto);
		});

	}
	
	@Test
	public void shouldNotThrowExceptionOnOtherAccountHolderNull() {

		// GIVEN
		String accountId = "10";
		TransactionDTO dto = SampleFactory.sampleTransaction(accountId, "TYPE");
		dto.getOtherAccount().setHolder(null);

		// THEN		
		
		assertDoesNotThrow(() -> {
			new TransactionResponse(dto);
		});

	}
	
	@Test
	public void shouldNotThrowExceptionOnThisMetadataNull() {

		// GIVEN
		String accountId = "10";
		TransactionDTO dto = SampleFactory.sampleTransaction(accountId, "TYPE");
		dto.getOtherAccount().setMetadata(null);

		// THEN		
		
		assertDoesNotThrow(() -> {
			new TransactionResponse(dto);
		});

	}
	
	@Test
	public void shouldNotThrowExceptionOnDetailsNull() {

		// GIVEN
		String accountId = "10";
		TransactionDTO dto = SampleFactory.sampleTransaction(accountId, "TYPE");
		dto.setDetails(null);

		// THEN		
		
		assertDoesNotThrow(() -> {
			new TransactionResponse(dto);
		});

	}
	
	@Test
	public void shouldNotThrowExceptionOnDetailValuesNull() {

		// GIVEN
		String accountId = "10";
		TransactionDTO dto = SampleFactory.sampleTransaction(accountId, "TYPE");
		dto.getDetails().setValue(null);

		// THEN		
		
		assertDoesNotThrow(() -> {
			new TransactionResponse(dto);
		});

	}

}
