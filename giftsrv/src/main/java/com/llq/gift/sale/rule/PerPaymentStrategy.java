package com.llq.gift.sale.rule;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.llq.gift.sale.data.Gift;
import com.llq.gift.sale.data.GoodsItem;
import com.llq.gift.sale.data.Order;

/**
 * 金额满赠
 * 
 * @author sjq
 *
 */
public class PerPaymentStrategy extends AbstractStrategy {

	private BigDecimal payment;

	private Gift gift;

	public PerPaymentStrategy(Date startTime, Date endTime, Set<String> storeNames, boolean dev, BigDecimal payment,
			Gift gift) {
		super(startTime, endTime, storeNames, dev);
		this.payment = payment;
		this.gift = gift;
	}

	@Override
	protected Set<Gift> doPresent(Order order) {
		if (order.getPayment().compareTo(payment) < 0) {
			return Collections.emptySet();
		}
		BigDecimal p = order.getPayment();
		p.setScale(0, RoundingMode.FLOOR);
		int times = p.divide(this.payment).intValue();

		String desc = gift.getDesc();
		Set<GoodsItem> items = gift.getItems().stream().map(i -> {
			return new GoodsItem(i.getGoodsNo(), i.getQuantity());
		}).collect(Collectors.toSet());
		Gift tmp = new Gift(desc, items, times);
		Set<Gift> gifts = new HashSet<>();
		gifts.add(tmp);
		return gifts;
	}

	@Override
	protected boolean verifyStrategy() {
		return payment != null && payment.compareTo(BigDecimal.ZERO) > 0 && gift != null;
	}

}
