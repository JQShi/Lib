package com.llq.gift.sale.rule;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.llq.gift.sale.data.Gift;
import com.llq.gift.sale.data.GoodsItem;
import com.llq.gift.sale.data.Order;

/**
 * 商品数量满赠
 * 
 * @author sjq
 *
 */
public class PerQuantityStrategy extends AbstractStrategy {

	private BigDecimal quantity;

	private String goodsNo;

	private Gift gift;

	public PerQuantityStrategy(Date startTime, Date endTime, Set<String> storeNames, boolean dev, BigDecimal quantity,
			String goodsNo, Gift gift) {
		super(startTime, endTime, storeNames, dev);
		this.quantity = quantity;
		this.goodsNo = goodsNo;
		this.gift = gift;
	}

	@Override
	protected Set<Gift> doPresent(Order order) {

		Optional<Integer> times = order.getItems().stream().filter(g -> g.getGoodsNo().equals(this.goodsNo))
				.map(i -> i.getQuantity()).reduce((a, b) -> a.add(b)).map(q -> {
					q.setScale(2, RoundingMode.FLOOR);
					return q.divide(this.quantity).intValue();
				});
		
		return times.filter(t -> t.intValue() > 0).map(t -> {
			String desc = gift.getDesc();
			Set<GoodsItem> items = gift.getItems().stream().map(i -> new GoodsItem(i.getGoodsNo(), i.getQuantity()))
					.collect(Collectors.toSet());
			Gift tmp = new Gift(desc, items, t);
			Set<Gift> gifts = new HashSet<>();
			gifts.add(tmp);
			return gifts;
		}).orElse(Collections.emptySet());

	}

	@Override
	protected boolean verifyStrategy() {
		return goodsNo != null && goodsNo.length() > 0 && quantity != null && quantity.compareTo(BigDecimal.ZERO) > 0
				&& gift != null;
	}

}
