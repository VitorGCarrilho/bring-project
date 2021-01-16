package com.carrilho.vitor.client.response;

import java.math.BigDecimal;

import com.carrilho.vitor.dto.AccountDTO;
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

		if (transaction.getThisAccount() != null) {
			this.accountId = transaction.getThisAccount().getId();
		}

		AccountDTO otherAccountDTO = transaction.getOtherAccount();
		if (otherAccountDTO != null) {
			
			this.couterPartyAccount = otherAccountDTO.getNumber();
			
			if (otherAccountDTO.getHolder() != null) {
				this.counterPartyName = otherAccountDTO.getHolder().getName();
			}
			
			if (otherAccountDTO.getMetadata() != null) {
				this.counterPartyLogo = otherAccountDTO.getMetadata().getImageUrl();
			}
		}
		
		if (transaction.getDetails() != null && transaction.getDetails().getValue() != null) {
			
			this.instructedAmount = transaction.getDetails().getValue().getAmount();
			this.instructedCurrency = transaction.getDetails().getValue().getCurrency();
			this.transactionAmount = transaction.getDetails().getValue().getAmount();
			this.transactionCurrency = transaction.getDetails().getValue().getCurrency();
			
		}
		
		if (transaction.getDetails() != null) {
			this.transactionType = transaction.getDetails().getType();
			this.description = transaction.getDetails().getDescription();
		}		
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
