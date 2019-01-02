package com.llq.gift.engine.predicate;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.llq.gift.engine.order.OrderInfo;
import com.llq.gift.engine.order.OrderItemInfo;

public class RangeQuantityPredicate implements OrderPredicate {

	private final String goodsNo;

	private final BigDecimal min;

	private final BigDecimal max;

	public RangeQuantityPredicate(String goodsNo, BigDecimal min, BigDecimal max) {
		super();
		this.goodsNo = goodsNo;
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean test(OrderInfo t) {
		if (!isValidated()) {
			return false;
		}
		List<OrderItemInfo> suitableItems = t.getItems().stream()
				.filter((o) -> String.valueOf(o.getGoodsNo()).equals(this.goodsNo)
						&& o.getQuantity().compareTo(this.min) >= 0 && o.getQuantity().compareTo(this.max) < 1)
				.collect(Collectors.toList());
		return !suitableItems.isEmpty();
	}

	@Override
	public boolean isValidated() {
		return this.goodsNo != null && this.goodsNo.length() > 0 && this.min != null && this.max != null
				&& this.min.compareTo(this.max) == -1;
	}

	@Override
	public String toString() {
		return "RangeQuantityPredicate [goodsNo=" + goodsNo + ", min=" + min + ", max=" + max + "]";
	}

	
	
}
