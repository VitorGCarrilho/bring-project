package com.carrilho.vitor.dto;

import com.google.gson.annotations.SerializedName;

class HolderDTO{
	@SerializedName("name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}