package com.llq.gift.sale;

import java.io.Serializable;
import java.util.Set;

import com.llq.gift.sale.rule.Strategy;

public interface StrategyService {

	Strategy loadStrategy(Serializable strategyName);

	Set<Serializable> findStrategyNames();
}
