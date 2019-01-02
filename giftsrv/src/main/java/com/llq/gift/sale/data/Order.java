package com.llq.gift.sale.data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {

	private String orderNo;

	private Date checkedTime;

	private Date createdTime;

	private BigDecimal payment;

	private BigDecimal amount;

	private BigDecimal pv;

	private String storeName;

	private Set<GoodsItem> items = new HashSet<>();

	private boolean dev = false;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getCheckedTime() {
		return checkedTime;
	}

	public void setCheckedTime(Date checkedTime) {
		this.checkedTime = checkedTime;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getPv() {
		return pv;
	}

	public void setPv(BigDecimal pv) {
		this.pv = pv;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public boolean isDev() {
		return dev;
	}

	public void setDev(boolean dev) {
		this.dev = dev;
	}

	public Set<GoodsItem> getItems() {
		return items;
	}

	public void setItems(Set<GoodsItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", checkedTime=" + checkedTime + ", createdTime=" + createdTime
				+ ", payment=" + payment + ", amount=" + amount + ", pv=" + pv + ", storeName=" + storeName + ", items="
				+ items + ", dev=" + dev + "]";
	}

}
