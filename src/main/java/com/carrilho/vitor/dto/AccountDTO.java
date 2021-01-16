package com.carrilho.vitor.dto;

import com.google.gson.annotations.SerializedName;

public class AccountDTO{
	@SerializedName("id")
	private String id;
	
	@SerializedName("number")
	private String number;
	
	@SerializedName("metadata")
	private MetadataDTO metadata;
	
	@SerializedName("holder")
	private HolderDTO holder;
	
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
	
	public HolderDTO getHolder() {
		return holder;
	}

	public void setHolder(HolderDTO holder) {
		this.holder = holder;
	}
}