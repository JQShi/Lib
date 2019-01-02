package com.llq.gift.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class OrderVo {
	private boolean dev = false;

	private String storeName;

	private BigDecimal amount;

	private BigDecimal payment;

	private BigDecimal purchasedValue;

	@ApiModelProperty(example = "2018-12-22 12:15:14")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(example = "2018-12-22 12:15:14")
	private Date checkedTime;

	private Set<OrderItemVo> items;

	public boolean isDev() {
		return dev;
	}

	public void setDev(boolean dev) {
		this.dev = dev;
	}

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

	public Set<OrderItemVo> getItems() {
		return items;
	}

	public void setItems(Set<OrderItemVo> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "OrderVo [dev=" + dev + ", storeName=" + storeName + ", amount=" + amount + ", payment=" + payment
				+ ", purchasedValue=" + purchasedValue + ", createdTime=" + createdTime + ", checkedTime=" + checkedTime
				+ ", items=" + items + "]";
	}

}
