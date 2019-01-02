package com.llq.gift.engine.order;

import java.math.BigDecimal;

public class OrderItem implements OrderItemInfo {

	private String goodsNo;

	private BigDecimal quantity;

	public OrderItem(String goodsNo, BigDecimal quantity) {
		super();
		this.goodsNo = goodsNo;
		this.quantity = quantity;
	}

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
		return "OrderItem [goodsNo=" + goodsNo + ", quantity=" + quantity + "]";
	}
}
