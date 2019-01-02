package com.llq.gift.engine.predicate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.llq.gift.engine.order.OrderInfo;

public class CompositePredicate implements OrderPredicate {

	private final List<OrderPredicate> orderPredicates;

	public CompositePredicate(List<OrderPredicate> orderPredicates) {
		super();
		this.orderPredicates = Collections.unmodifiableList(orderPredicates);
	}

	@Override
	public boolean test(OrderInfo t) {
		if (!isValidated()) {
			return false;
		}
		Optional<Boolean> opt = orderPredicates.stream().map(p -> p.test(t)).reduce((a, b) -> a && b);
		return opt.isPresent() ? opt.get() : false;
	}

	@Override
	public boolean isValidated() {
		return orderPredicates != null && !orderPredicates.isEmpty()
				&& orderPredicates.stream().map(p -> p.isValidated()).reduce((a, b) -> a && b).get();
	}

	@Override
	public String toString() {
		return "CompositePredicate [orderPredicates=" + orderPredicates + "]";
	}
	
	

}
