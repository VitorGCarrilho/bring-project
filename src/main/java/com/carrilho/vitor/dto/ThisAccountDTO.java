package com.carrilho.vitor.dto;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ThisAccountDTO extends AccountDTO {
	@SerializedName("holders")
	private List<HolderDTO> holders;

	public List<HolderDTO> getHolders() {
		return holders;
	}

	public void setHolders(List<HolderDTO> holders) {
		this.holders = holders;
	}
}