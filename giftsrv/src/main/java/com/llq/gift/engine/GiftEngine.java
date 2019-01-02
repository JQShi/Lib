package com.llq.gift.engine;

import java.util.List;
import java.util.Set;

import com.llq.gift.engine.activity.Activity;
import com.llq.gift.engine.gift.GiftInfo;
import com.llq.gift.engine.order.OrderInfo;

public interface GiftEngine {

	public boolean refresh();

	public Set<GiftInfo> present(OrderInfo order);
	
	public List<Activity> getActivities();

}
