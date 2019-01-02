package com.llq.gift.vo;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.llq.gift.module.PaymentCriterion;

public class PaymentCriteriaAddResponse extends BaseResponse<Set<PaymentCriterion>> {

	private static final String PAYMENTCRITERIA_ADD_RESPONSE = "paymentcriteria_add_response";

	public PaymentCriteriaAddResponse(Set<PaymentCriterion> body) {
		super(body);
	}

	@JsonProperty(PAYMENTCRITERIA_ADD_RESPONSE)
	@Override
	public Set<PaymentCriterion> getBody() {
		return super.getBody();
	}
	
	
	
}
