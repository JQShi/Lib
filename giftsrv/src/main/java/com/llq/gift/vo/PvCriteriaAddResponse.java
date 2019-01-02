package com.llq.gift.vo;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.llq.gift.module.PvCriterion;

public class PvCriteriaAddResponse extends BaseResponse<Set<PvCriterion>> {

	private static final String PVCRITERIA_ADD_RESPONSE = "pvcriteria_add_response";

	public PvCriteriaAddResponse(Set<PvCriterion> body) {
		super(body);
	}

	@JsonProperty(PVCRITERIA_ADD_RESPONSE)
	@Override
	public Set<PvCriterion> getBody() {
		return super.getBody();
	}

}
