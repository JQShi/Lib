package com.llq.gift.vo;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GiftQueryResponse extends BaseResponse<Set<GiftVo>> {

	private static final String GIFT_QUERY_RESPONSE = "gift_query_response";
	
	public GiftQueryResponse(Set<GiftVo> body) {
		super(body);
	}
	
	@JsonProperty(GIFT_QUERY_RESPONSE)
	@Override
	public Set<GiftVo> getBody() {
		return super.getBody();
	}

}
