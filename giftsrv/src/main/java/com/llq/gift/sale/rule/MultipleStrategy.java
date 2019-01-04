package com.llq.gift.sale.rule;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.llq.gift.sale.data.Gift;
import com.llq.gift.sale.data.Order;

public class MultipleStrategy implements Strategy {

	private Set<Strategy> strategies = Collections.emptySet();

	public MultipleStrategy(Set<Strategy> strategies) {
		this.strategies = strategies;
	}

	@Override
	public Set<Gift> present(Order order) {

		return this.strategies.stream().map(s -> s.present(order)).reduce((a, b) -> {
			HashSet<Gift> set = new HashSet<>(a);
			set.addAll(b);
			return set;
		}).orElse(Collections.emptySet());
	}

}
