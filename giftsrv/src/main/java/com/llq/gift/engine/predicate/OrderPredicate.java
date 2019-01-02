package com.llq.gift.engine.predicate;

import java.util.function.Predicate;

import com.llq.gift.engine.order.OrderInfo;

public interface OrderPredicate extends Predicate<OrderInfo> {

	public boolean isValidated();
}
