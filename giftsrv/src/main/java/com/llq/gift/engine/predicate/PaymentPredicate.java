package com.llq.gift.engine.predicate;

import java.math.BigDecimal;

import com.llq.gift.engine.order.OrderInfo;

public class PaymentPredicate implements OrderPredicate {

	private final BigDecimal min;

	private final BigDecimal max;

	public PaymentPredicate(BigDecimal min, BigDecimal max) {
		super();
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean test(OrderInfo t) {
		if (!isValidated() || t == null || t.getPayment() == null) {
			return false;
		}
		return min.compareTo(t.getPayment()) <= 0 && max.compareTo(t.getPayment()) > 0;
	}

	@Override
	public boolean isValidated() {
		return min != null && max != null && min.compareTo(max) == -1;
	}

	@Override
	public String toString() {
		return "PaymentPredicate [min=" + min + ", max=" + max + "]";
	}

	
	
}
