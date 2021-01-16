package com.carrilho.vitor.dto;

import com.google.gson.annotations.SerializedName;

class TransactionDTO {
	
	@SerializedName("id")
	private String id;
	
	@SerializedName("this_account")
	private ThisAccountDTO thisAccount;
	
	@SerializedName("other_account")
	private OtherAccountDTO otherAccount;
	
	@SerializedName("details")
	private DetailsDTO details;
	
	public ThisAccountDTO getThisAccount() {
		return thisAccount;
	}

	public void setThisAccount(ThisAccountDTO thisAccount) {
		this.thisAccount = thisAccount;
	}

	public OtherAccountDTO getOtherAccount() {
		return otherAccount;
	}

	public void setOtherAccount(OtherAccountDTO otherAccount) {
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
