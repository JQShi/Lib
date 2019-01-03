package com.llq.gift.sale.rule;

import java.util.Collections;
import java.util.Set;

import com.llq.gift.sale.data.Gift;
import com.llq.gift.sale.data.Order;

/**
 * 多选一策略
 * 
 * @author Administrator
 *
 */
public class AnyoneStrategy implements Strategy {

	private Set<Strategy> strategies = Collections.emptySet();

	public AnyoneStrategy(Set<Strategy> strategies) {
		this.strategies = strategies;
	}

	@Override
	public Set<Gift> present(Order order) {

		return this.strategies.stream().map(s -> s.present(order)).filter(g -> !g.isEmpty()).findFirst()
				.orElse(Collections.emptySet());

		// for (Strategy strategy : strategies) {
		// Set<Gift> gifts = strategy.present(order);
		// if (!gifts.isEmpty()) {
		// return gifts;
		// }
		// }
		// return Collections.emptySet();
	}

}
