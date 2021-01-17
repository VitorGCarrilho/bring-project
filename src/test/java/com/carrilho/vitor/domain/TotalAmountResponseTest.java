package com.carrilho.vitor.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.carrilho.vitor.client.domain.TotalAmount;
import com.carrilho.vitor.client.domain.Transaction;
import com.carrilho.vitor.controller.helper.SampleFactory;

@ExtendWith(MockitoExtension.class)
public class TotalAmountResponseTest {

	@Test
	public void shouldSumActualTotalValueToTransaction() {
		// GIVEN
		String accountId = "10";
		TotalAmount actualTotal = new TotalAmount();
		actualTotal.setValue(BigDecimal.valueOf(12L));
		
		Transaction transaction = SampleFactory.sampleTransactionResponse(accountId, "Type", BigDecimal.valueOf(105L));
		
		// WHEN
		TotalAmount total = TotalAmount.addTransaction(actualTotal, transaction);
		

		// THEN
		assertEquals(BigDecimal.valueOf(117), total.getValue());
	}
	
	@Test
	public void shouldSumTwoTotalAmount() {
		// GIVEN
		TotalAmount total1 = new TotalAmount();
		total1.setValue(BigDecimal.valueOf(29L));
		
		TotalAmount total2 = new TotalAmount();
		total2.setValue(BigDecimal.valueOf(299L));
		
		
		
		// WHEN
		TotalAmount total = TotalAmount.sum(total1, total2);
		

		// THEN
		assertEquals(BigDecimal.valueOf(328), total.getValue());
	}


}
