package com.llq.gift.sale.rule;

import java.util.Set;

import com.llq.gift.sale.data.Gift;
import com.llq.gift.sale.data.Order;

public interface Strategy {

	/**
	 * 计算赠品
	 * 
	 * @param order
	 * @return 无赠品，返回emptySet
	 */
	public Set<Gift> present(Order order);
}
