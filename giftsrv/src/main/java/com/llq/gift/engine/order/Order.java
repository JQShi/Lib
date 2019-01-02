package com.llq.gift.engine.order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Order implements OrderInfo {
	
	private boolean dev = false;

	private String storeName;

	private BigDecimal amount;

	private BigDecimal payment;

	private BigDecimal purchasedValue;

	private Date createdTime;

	private Date checkedTime;

	private Set<OrderItemInfo> items;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	public BigDecimal getPurchasedValue() {
		return purchasedValue;
	}

	public void setPurchasedValue(BigDecimal purchasedValue) {
		this.purchasedValue = purchasedValue;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getCheckedTime() {
		return checkedTime;
	}

	public void setCheckedTime(Date checkedTime) {
		this.checkedTime = checkedTime;
	}

	public Set<OrderItemInfo> getItems() {
		return items;
	}

	public void setItems(Set<OrderItemInfo> items) {
		this.items = items;
	}

	public boolean getDev() {
		return dev;
	}

	public void setDev(boolean dev) {
		this.dev = dev;
	}

	@Override
	public String toString() {
		return "Order [dev=" + dev + ", storeName=" + storeName + ", amount=" + amount + ", payment=" + payment
				+ ", purchasedValue=" + purchasedValue + ", createdTime=" + createdTime + ", checkedTime=" + checkedTime
				+ ", items=" + items + "]";
	}

}
