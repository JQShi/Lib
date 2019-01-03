package com.llq.gift.sale.rule;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.llq.gift.sale.data.Gift;
import com.llq.gift.sale.data.GoodsItem;
import com.llq.gift.sale.data.Order;

public class SimpleStrategy extends AbstractStrategy {

	private Gift gift;

	public SimpleStrategy(Date startTime, Date endTime, Set<String> storeNames, boolean dev, Gift gift) {
		super(startTime, endTime, storeNames, dev);
		this.gift = gift;
	}

	@Override
	protected Set<Gift> doPresent(Order order) {
		Set<GoodsItem> items = gift.getItems().stream().map(i -> new GoodsItem(i.getGoodsNo(), i.getQuantity()))
				.collect(Collectors.toSet());
		Gift tmp = new Gift(this.gift.getDesc(), items, 1);
		Set<Gift> gifts = new HashSet<>();
		gifts.add(tmp);
		return Collections.unmodifiableSet(gifts);
	}

	@Override
	protected boolean verifyStrategy() {
		return this.gift != null;
	}

}
