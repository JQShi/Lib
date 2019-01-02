package com.llq.gift.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.llq.gift.module.Promotion;

public class PromotionAddResponse extends BaseResponse<Promotion> {

	public PromotionAddResponse(Promotion body) {
		super(body);
	}

	@JsonProperty("promotion_add_response")
	@Override
	public Promotion getBody() {
		return super.getBody();
	}
	
	

}
