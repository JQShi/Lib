package com.llq.gift.engine.predicate;

import java.math.BigDecimal;

import com.llq.gift.engine.order.OrderInfo;

public class PurchasedValuePredicate implements OrderPredicate {

	private final BigDecimal min;

	private final BigDecimal max;

	public PurchasedValuePredicate(BigDecimal min, BigDecimal max) {
		super();
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean test(OrderInfo t) {
		if (!isValidated() || t == null || t.getPurchasedValue() == null) {
			return false;
		}
		return min.compareTo(t.getPurchasedValue()) <= 0 && max.compareTo(t.getPurchasedValue()) > 0;
	}

	@Override
	public boolean isValidated() {
		return min == null || max == null || min.compareTo(max) > -1;
	}

	@Override
	public String toString() {
		return "PurchasedValuePredicate [min=" + min + ", max=" + max + "]";
	}

}
