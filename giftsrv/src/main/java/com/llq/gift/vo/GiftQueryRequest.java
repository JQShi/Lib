package com.llq.gift.vo;

public class GiftQueryRequest {

	private OrderVo order;

	public OrderVo getOrder() {
		return order;
	}

	public void setOrder(OrderVo order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "GiftQueryRequest [order=" + order + "]";
	}
	
	
	
}
