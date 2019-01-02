package com.llq.gift.vo;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.llq.gift.module.Store;

public class StoresAddResponse extends BaseResponse<Set<Store>> {

	private final static String STORE_ADD_RESPONSE = "store_add_response";
	
	public StoresAddResponse(Set<Store> body) {
		super(body);
	}

	@JsonProperty(STORE_ADD_RESPONSE)
	@Override
	public Set<Store> getBody() {
		return super.getBody();
	}

}
