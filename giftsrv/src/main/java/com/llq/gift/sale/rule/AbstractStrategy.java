package com.llq.gift.sale.rule;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.llq.gift.sale.data.Gift;
import com.llq.gift.sale.data.Order;

public abstract class AbstractStrategy implements Strategy {

	protected Date startTime;

	protected Date endTime;

	protected Set<String> storeNames = new HashSet<>();

	protected boolean dev = true;

	public AbstractStrategy(Date startTime, Date endTime, Set<String> storeNames, boolean dev) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.storeNames = storeNames;
		this.dev = dev;
	}

	/**
	 * 计算赠品数量
	 * 
	 * @param order
	 * @return
	 */
	protected abstract Set<Gift> doPresent(Order order);

	/**
	 * 检验促销策略
	 * 
	 * @return
	 */
	protected abstract boolean verifyStrategy();

	@Override
	public Set<Gift> present(Order order) {
		if (!this.verifyStrategy()) {
			return Collections.emptySet();
		}
		if (!this.verifyOrder(order)) {
			return Collections.emptySet();
		}
		return this.doPresent(order);
	}

	protected boolean verifyOrder(Order order) {
		return order != null && this.verifyPayment(order) && this.verifyCheckedTime(order)
				&& this.verifyStoreName(order) && this.verifyDev(order);
	}

	private boolean verifyCheckedTime(Order order) {
		if (this.startTime != null) {
			if (order.getCheckedTime() == null || this.startTime.compareTo(order.getCheckedTime()) > 0) {
				return false;
			}
		}
		if (this.endTime != null) {
			if (order.getCheckedTime() == null || this.endTime.compareTo(order.getCheckedTime()) <= 0) {
				return false;
			}
		}
		return true;
	}

	private boolean verifyPayment(Order order) {
		if (order.getPayment() == null || order.getPayment().compareTo(BigDecimal.ZERO) <= 0) {
			return false;
		}
		return true;
	}

	private boolean verifyStoreName(Order order) {
		String storeName = null;
		if (order.getStoreName() == null) {
			storeName = "";
		} else {
			storeName = order.getStoreName();
		}
		return this.storeNames.contains(storeName);
	}

	private boolean verifyDev(Order order) {
		if (!this.dev) {
			// 非测试策略
			return true;
		} else {
			return order.isDev() == true;
		}
	}

}
