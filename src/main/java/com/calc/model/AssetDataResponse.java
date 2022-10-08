package com.calc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AssetDataResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2172603719595328573L;
	
	@JsonIgnore
	private String message;

	private List<AssetDataDTO> assetList =new ArrayList<>();
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<AssetDataDTO> getAssetList() {
		return assetList;
	}

	public void setAssetList(List<AssetDataDTO> assetList) {
		this.assetList = assetList;
	}

	@Override
	public String toString() {
		return "AssetDataResponse [message=" + message + ", assetList=" + assetList + "]";
	}
	
}
