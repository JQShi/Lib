package com.llq.gift.vo;

import java.math.BigDecimal;

public class GiftItemVo {

	private String goodsNo;

	private BigDecimal quantity;

	public String getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "GiftItemDto [goodsNo=" + goodsNo + ", quantity=" + quantity + "]";
	}
	
	
	
}
