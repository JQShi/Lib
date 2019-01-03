package com.llq.gift.sale;

import java.util.Collections;
import java.util.Set;

import com.llq.gift.sale.data.Gift;
import com.llq.gift.sale.data.Order;
import com.llq.gift.sale.rule.MultipleStrategy;
import com.llq.gift.sale.rule.Strategy;

public class Santa {
	// TODO

	private Strategy strategy = new MultipleStrategy(Collections.emptyMap());
	
	
	public Set<Gift> present(Order order) {
		return this.strategy.present(order);
	}
	
	
}
