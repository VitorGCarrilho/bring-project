package com.carrilho.vitor.dto;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class ValueDTO {
	@SerializedName("amount")
	private BigDecimal amount;
	
	@SerializedName("currency")
	private String currency;
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
}