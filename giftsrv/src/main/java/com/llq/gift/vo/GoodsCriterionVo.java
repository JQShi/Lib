package com.llq.gift.vo;

import java.math.BigDecimal;

public class GoodsCriterionVo {

	private String goodsNo;

	private BigDecimal minQuantity;

	private BigDecimal maxQuantity;
	
	private GiftVo gift;

	public String getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public BigDecimal getMinQuantity() {
		return minQuantity;
	}

	public void setMinQuantity(BigDecimal minQuantity) {
		this.minQuantity = minQuantity;
	}

	public BigDecimal getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(BigDecimal maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public GiftVo getGift() {
		return gift;
	}

	public void setGift(GiftVo gift) {
		this.gift = gift;
	}

	@Override
	public String toString() {
		return "GoodsCriterionDto [goodsNo=" + goodsNo + ", minQuantity=" + minQuantity + ", maxQuantity=" + maxQuantity
				+ ", gift=" + gift + "]";
	}
	
	
	
}
