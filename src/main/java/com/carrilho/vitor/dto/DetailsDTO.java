package com.carrilho.vitor.dto;

import com.google.gson.annotations.SerializedName;

public class DetailsDTO {
	@SerializedName("new_balance")
	private ValueDTO newBalance;
	
	@SerializedName("value")
	private ValueDTO value;
	
	@SerializedName("type")
	private String type;
	
	@SerializedName("description")
	private String description;
	
	public ValueDTO getValue() {
		return value;
	}

	public void setValue(ValueDTO value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
