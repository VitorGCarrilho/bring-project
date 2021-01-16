package com.carrilho.vitor.dto;

import com.google.gson.annotations.SerializedName;

public abstract class AccountDTO{
	@SerializedName("id")
	private String id;
	
	@SerializedName("number")
	private String number;
	
	@SerializedName("metadata")
	private MetadataDTO metadata;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public MetadataDTO getMetadata() {
		return metadata;
	}
	public void setMetadata(MetadataDTO metadata) {
		this.metadata = metadata;
	}
}