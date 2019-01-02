package com.llq.gift.sale.rule;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.llq.gift.sale.data.Gift;
import com.llq.gift.sale.data.Order;

public class CompositeStrategy implements Strategy {

	private Map<Serializable, Strategy> map = Collections.emptyMap();

	public CompositeStrategy(Map<Serializable, Strategy> map) {
		this.map = new ConcurrentHashMap<>(map);
	}

	@Override
	public Set<Gift> present(Order order) {
		return this.map.entrySet().stream().map(s -> s.getValue().present(order)).reduce(new HashSet<>(), (a, b) -> {
			HashSet<Gift> set = new HashSet<>(a);
			set.addAll(b);
			return set;
		});
	}

}
