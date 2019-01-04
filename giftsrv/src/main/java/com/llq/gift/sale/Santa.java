package com.llq.gift.sale;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.llq.gift.sale.data.Gift;
import com.llq.gift.sale.data.Order;
import com.llq.gift.sale.rule.Strategy;

public class Santa {

	private final Map<Serializable, Strategy> map = new ConcurrentHashMap<>();

	private StrategyService strategyService;
	
	public Santa(StrategyService strategyService) {
		super();
		this.strategyService = strategyService;
	}

	public void loadAll() {
		Set<Serializable> strategyNames = this.strategyService.findStrategyNames();
		strategyNames.stream().forEach(s -> this.map.put(s, this.strategyService.loadStrategy(s)));
	}

	public void loadOne(Serializable strategyName) {
		Strategy strategy = this.strategyService.loadStrategy(strategyName);
		this.map.put(strategyName, strategy);
	}

	public Set<Gift> present(Order order) {
		return this.map.entrySet().stream().map(s -> s.getValue().present(order)).reduce((a, b) -> {
			HashSet<Gift> set = new HashSet<>(a);
			set.addAll(b);
			return set;
		}).orElse(Collections.emptySet());
	}

}
