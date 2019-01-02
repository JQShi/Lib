package com.llq.gift.engine.predicate;

import com.llq.gift.engine.order.OrderInfo;

public class NonePredicate implements OrderPredicate {

	@Override
	public boolean test(OrderInfo t) {
		return false;
	}

	@Override
	public boolean isValidated() {
		return true;
	}

	@Override
	public String toString() {
		return "NonePredicate []";
	}
	
	

}
