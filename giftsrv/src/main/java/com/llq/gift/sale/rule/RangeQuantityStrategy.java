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

/**
 * 每满商品数量赠送
 * 
 * @author sjq
 *
 */
public class RangeQuantityStrategy extends AbstractStrategy {

	private String goodsNo;

	private BigDecimal min;

	private BigDecimal max;

	private Gift gift;

	public RangeQuantityStrategy(Date startTime, Date endTime, Set<String> storeNames, boolean dev, String goodsNo,
			BigDecimal min, BigDecimal max, Gift gift) {
		super(startTime, endTime, storeNames, dev);
		this.goodsNo = goodsNo;
		this.min = min;
		this.max = max;
		this.gift = gift;
	}

	@Override
	protected Set<Gift> doPresent(Order order) {
		long count = order.getItems().stream().filter(g -> {
			return g.getGoodsNo().equals(goodsNo) && g.getQuantity().compareTo(min) >= 0
					&& g.getQuantity().compareTo(max) < 0;
		}).count();
		if (count > 0) {
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
