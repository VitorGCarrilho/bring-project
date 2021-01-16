package com.carrilho.vitor.dto;

import com.google.gson.annotations.SerializedName;

public class TransactionDTO {
	
	@SerializedName("id")
	private String id;
	
	@SerializedName("this_account")
	private AccountDTO thisAccount;
	
	@SerializedName("other_account")
	private AccountDTO otherAccount;
	
	@SerializedName("details")
	private DetailsDTO details;
	
	public AccountDTO getThisAccount() {
		return thisAccount;
	}

	public void setThisAccount(AccountDTO thisAccount) {
		this.thisAccount = thisAccount;
	}

	public AccountDTO getOtherAccount() {
		return otherAccount;
	}

	public void setOtherAccount(AccountDTO otherAccount) {
		this.otherAccount = otherAccount;
	}

	public DetailsDTO getDetails() {
		return details;
	}

	public void setDetails(DetailsDTO details) {
		this.details = details;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
}
