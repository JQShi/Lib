package com.llq.gift.engine.activity;

import com.llq.gift.engine.gift.GiftInfo;
import com.llq.gift.engine.order.OrderInfo;
import com.llq.gift.engine.predicate.OrderPredicate;

public class DefaultActivity implements Activity {

	private final OrderPredicate orderPredicate;

	private final GiftInfo gift;

	public DefaultActivity(OrderPredicate orderPredicate, GiftInfo gift) {
		super();
		this.orderPredicate = orderPredicate;
		this.gift = gift;
	}

	@Override
	public GiftInfo present(OrderInfo order) {
		if (order == null) {
			return null;
		}
		return orderPredicate.test(order) ? this.gift : null;
	}

	@Override
	public String toString() {
		return "DefaultActivity [orderPredicate=" + orderPredicate + ", gift=" + gift + "]";
	}
	
	
	
	

}
