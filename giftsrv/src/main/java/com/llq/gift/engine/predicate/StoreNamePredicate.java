package com.llq.gift.engine.predicate;

import java.util.Set;

import com.llq.gift.engine.order.OrderInfo;

public class StoreNamePredicate implements OrderPredicate {

	private final Set<String> storeNames;

	public StoreNamePredicate(Set<String> storeNames) {
		super();
		this.storeNames = storeNames;
	}

	@Override
	public boolean test(OrderInfo t) {
		if (!isValidated() || t.getStoreName() == null || t.getStoreName().length() == 0) {
			return false;
		}
		return this.storeNames.contains(t.getStoreName());
	}

	@Override
	public boolean isValidated() {
		return storeNames != null && !storeNames.isEmpty();
	}

	@Override
	public String toString() {
		return "StoreNamePredicate [storeNames=" + storeNames + "]";
	}

}
