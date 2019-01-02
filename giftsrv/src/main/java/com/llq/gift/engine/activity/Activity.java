package com.llq.gift.engine.activity;

import com.llq.gift.engine.gift.GiftInfo;
import com.llq.gift.engine.order.OrderInfo;

public interface Activity {

	public GiftInfo present(OrderInfo order);
}
