package com.carrilho.vitor.domain;

import java.math.BigDecimal;

public class TotalAmount {
	private String accountId;
	private BigDecimal value;
	
	public TotalAmount() {
		this.accountId = "";
		this.value = BigDecimal.ZERO;
	}
	
	private TotalAmount(String accountId, BigDecimal value) {
		this.accountId = accountId;
		this.value = value;
	}

	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	public static TotalAmount addTransaction(TotalAmount total, Transaction transaction) {
		return new TotalAmount(transaction.getAccountId(), total.value.add(transaction.getTransactionAmount()));
	}
	
	public static TotalAmount sum(TotalAmount total1, TotalAmount total2) {
		return new TotalAmount(total2.accountId, total1.value.add(total2.value));
	}
	
}
