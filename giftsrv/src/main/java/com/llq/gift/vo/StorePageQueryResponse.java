package com.llq.gift.vo;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.llq.gift.module.Store;

public class StorePageQueryResponse extends BaseResponse<Page<Store>> {

	public StorePageQueryResponse(Page<Store> body) {
		super(body);
	}

	private final static String STORE_PAGE_QUERY_RESPONSE = "store_page_query_response";

	@JsonProperty(STORE_PAGE_QUERY_RESPONSE)
	@Override
	public Page<Store> getBody() {
		return super.getBody();
	}

}
