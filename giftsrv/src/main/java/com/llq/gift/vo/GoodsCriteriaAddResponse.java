package com.llq.gift.vo;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.llq.gift.module.GoodsCriterion;

public class GoodsCriteriaAddResponse extends BaseResponse<Set<GoodsCriterion>> {

	private static final String GOODSCRITERIA_ADD_RESPONSE = "goodscriteria_add_response";

	public GoodsCriteriaAddResponse(Set<GoodsCriterion> body) {
		super(body);
	}

	@JsonProperty(GOODSCRITERIA_ADD_RESPONSE)
	@Override
	public Set<GoodsCriterion> getBody() {
		return super.getBody();
	}
	
	
	
}
