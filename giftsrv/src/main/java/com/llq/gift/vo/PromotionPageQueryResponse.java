package com.llq.gift.vo;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.llq.gift.module.Promotion;

public class PromotionPageQueryResponse extends BaseResponse<Page<Promotion>> {

	private static final String PROMOTION_PAGE_QUERY_RESPONSE = "promotion_page_query_response";

	public PromotionPageQueryResponse(Page<Promotion> body) {
		super(body);
	}

	@JsonProperty(PROMOTION_PAGE_QUERY_RESPONSE)
	@Override
	public Page<Promotion> getBody() {
		return super.getBody();
	}
	
	
}
