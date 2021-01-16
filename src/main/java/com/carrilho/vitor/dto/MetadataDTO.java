package com.carrilho.vitor.dto;

import com.google.gson.annotations.SerializedName;

class MetadataDTO{
	@SerializedName("image_URL")
	private String imageUrl;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}