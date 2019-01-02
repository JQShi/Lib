package com.llq.gift.engine.predicate;

import com.llq.gift.engine.order.OrderInfo;

public class DevPredicate implements OrderPredicate {

	@Override
	public boolean test(OrderInfo t) {
		return t != null && t.getDev();
	}

	@Override
	public boolean isValidated() {
		return true;
	}

	@Override
	public String toString() {
		return "DevPredicate []";
	}

	
	
}
