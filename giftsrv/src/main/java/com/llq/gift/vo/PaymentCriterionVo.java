package com.llq.gift.vo;

import java.math.BigDecimal;

public class PaymentCriterionVo {

	private BigDecimal minPayment;

	private BigDecimal maxPayment;
	
	private GiftVo gift;

	public BigDecimal getMinPayment() {
		return minPayment;
	}

	public void setMinPayment(BigDecimal minPayment) {
		this.minPayment = minPayment;
	}

	public BigDecimal getMaxPayment() {
		return maxPayment;
	}

	public void setMaxPayment(BigDecimal maxPayment) {
		this.maxPayment = maxPayment;
	}

	public GiftVo getGift() {
		return gift;
	}

	public void setGift(GiftVo gift) {
		this.gift = gift;
	}

	@Override
	public String toString() {
		return "PaymentCriteriaVo [minPayment=" + minPayment + ", maxPayment=" + maxPayment + ", gift=" + gift + "]";
	}
	
	
	
	
}
