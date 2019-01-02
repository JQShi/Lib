package com.llq.gift.vo;

import java.util.Set;

public class StoresAddRequest {

	private Set<String> storeNames;

	public Set<String> getStoreNames() {
		return storeNames;
	}

	@Override
	public String toString() {
		return "StoresAddRequest [storeNames=" + storeNames + "]";
	}
	
	
}
