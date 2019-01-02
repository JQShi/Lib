package com.llq.gift.vo;

import java.util.Collections;
import java.util.Set;

public class PaymentCriteriaAddRequest {

	private Long promotionCode;
	
	private Set<PaymentCriterionVo> paymentCriteria = Collections.emptySet();

	public Long getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(Long promotionCode) {
		this.promotionCode = promotionCode;
	}

	public Set<PaymentCriterionVo> getPaymentCriteria() {
		return paymentCriteria;
	}

	public void setPaymentCriteria(Set<PaymentCriterionVo> paymentCriteria) {
		this.paymentCriteria = paymentCriteria;
	}

	@Override
	public String toString() {
		return "PaymentCriteriaAddRequest [promotionCode=" + promotionCode + ", paymentCriteria=" + paymentCriteria
				+ "]";
	}
	
	
	
}
