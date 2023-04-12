package com.supermap.msdelete.utils;

import org.json.JSONArray;

public class SphMDItem {

	private JSONArray itemListarr;
	private String token;
	
	public SphMDItem() {}
	
	public JSONArray getItemListarr() {
		return itemListarr;
	}

	public void setItemListarr(JSONArray itemListarr) {
		this.itemListarr = itemListarr;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	


}
