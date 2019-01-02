package com.llq.gift.sale.rule;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.llq.gift.sale.data.Gift;
import com.llq.gift.sale.data.GoodsItem;
import com.llq.gift.sale.data.Order;

public class RangePaymentStrategy extends AbstractStrategy {

	private BigDecimal min;

	private BigDecimal max;

	private Gift gift;

	public RangePaymentStrategy(Date startTime, Date endTime, Set<String> storeNames, boolean dev, BigDecimal min,
			BigDecimal max, Gift gift) {
		super(startTime, endTime, storeNames, dev);
		this.min = min;
		this.max = max;
		this.gift = gift;
	}

	@Override
	protected Set<Gift> doPresent(Order order) {
		if (min.compareTo(order.getPayment()) <= 0 && max.compareTo(order.getPayment()) > 0) {
			Set<Gift> gifts = new HashSet<>();
			Set<GoodsItem> items = gift.getItems().stream().map(g -> {
				return new GoodsItem(g.getGoodsNo(), g.getQuantity());
			}).collect(Collectors.toSet());
			Gift tmp = new Gift(gift.getDesc(), items, Integer.valueOf(1));
			gifts.add(tmp);
			return gifts;
		} else {
			return Collections.emptySet();
		}
	}

	@Override
	protected boolean verifyStrategy() {
		if (min == null || max == null || min.compareTo(max) >= 0 || gift == null) {
			return false;
		}
		return true;
	}

}
