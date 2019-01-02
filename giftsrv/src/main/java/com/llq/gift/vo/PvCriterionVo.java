package com.llq.gift.vo;

import java.math.BigDecimal;

public class PvCriterionVo {

	private BigDecimal minPv;

	private BigDecimal maxPv;

	private GiftVo gift;

	public BigDecimal getMinPv() {
		return minPv;
	}

	public void setMinPv(BigDecimal minPv) {
		this.minPv = minPv;
	}

	public BigDecimal getMaxPv() {
		return maxPv;
	}

	public void setMaxPv(BigDecimal maxPv) {
		this.maxPv = maxPv;
	}

	public GiftVo getGift() {
		return gift;
	}

	public void setGift(GiftVo gift) {
		this.gift = gift;
	}

	@Override
	public String toString() {
		return "PvCriterionVo [minPv=" + minPv + ", maxPv=" + maxPv + ", gift=" + gift + "]";
	}

}
