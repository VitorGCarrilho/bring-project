package com.carrilho.vitor.client.response;

import java.math.BigDecimal;

import com.carrilho.vitor.dto.TransactionDTO;

public class TransactionResponse {
	private String id;
	private String accountId;
	private String couterPartyAccount;
	private String counterPartyName;
	private String counterPartyLogo;
	private BigDecimal instructedAmount;
	private String instructedCurrency;
	private BigDecimal transactionAmount;
	private String transactionCurrency;
	private String transactionType;
	private String description;
	
	public TransactionResponse(final TransactionDTO transaction) {
		this.id = transaction.getId();
		this.accountId = transaction.getThisAccount().getId();
		this.couterPartyAccount = transaction.getOtherAccount().getNumber();
		this.counterPartyName = transaction.getOtherAccount().getHolder().getName();
		this.counterPartyLogo = transaction.getOtherAccount().getMetadata().getImageUrl();
		this.instructedAmount = transaction.getDetails().getValue().getAmount();
		this.instructedCurrency = transaction.getDetails().getValue().getCurrency();
		this.transactionAmount = transaction.getDetails().getValue().getAmount();
		this.transactionCurrency = transaction.getDetails().getValue().getCurrency();
		this.transactionType = transaction.getDetails().getType();
		this.description = transaction.getDetails().getDescription();
	}
	
	public String getId() {
		return id;
	}
	public String getAccountId() {
		return accountId;
	}
	public String getCouterPartyAccount() {
		return couterPartyAccount;
	}
	public String getCounterPartyName() {
		return counterPartyName;
	}
	public String getCounterPartyLogo() {
		return counterPartyLogo;
	}
	public BigDecimal getInstructedAmount() {
		return instructedAmount;
	}
	public String getInstructedCurrency() {
		return instructedCurrency;
	}
	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}
	public String getTransactionCurrency() {
		return transactionCurrency;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public String getDescription() {
		return description;
	}

}
