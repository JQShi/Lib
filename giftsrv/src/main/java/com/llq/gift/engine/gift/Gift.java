package com.llq.gift.engine.gift;

import java.util.Set;

import com.llq.gift.engine.order.OrderItemInfo;

public class Gift implements GiftInfo {

	private String comment;

	private Set<OrderItemInfo> items;

	public Gift(String comment, Set<OrderItemInfo> items) {
		super();
		this.comment = comment;
		this.items = items;
	}

	public String getComment() {
		return comment;
	}

	public Set<OrderItemInfo> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "Gift [comment=" + comment + ", items=" + items + "]";
	}

	
	
}
