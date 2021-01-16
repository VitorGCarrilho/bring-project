package com.carrilho.vitor.dto;

import com.google.gson.annotations.SerializedName;

class OtherAccountDTO extends AccountDTO {
	@SerializedName("holder")
	private HolderDTO holder;

	public HolderDTO getHolder() {
		return holder;
	}

	public void setHolder(HolderDTO holder) {
		this.holder = holder;
	}
}