package com.llq.gift.engine.gift;

import java.util.Set;

import com.llq.gift.engine.order.OrderItemInfo;

public interface GiftInfo {

	public String getComment();
	
	public Set<OrderItemInfo> getItems();
	
}
