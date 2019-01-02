package com.llq.gift.engine.promotion;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.llq.gift.engine.gift.GiftInfo;

public class Promotion implements PromotionInfo {

	private boolean dev = false;
	
	private Set<String> storeNames;

	private Date startCheckedTime;

	private Date endCheckedTime;

	private BigDecimal minPayment;

	private BigDecimal maxPayment;

	private BigDecimal minPurchasedValue;

	private BigDecimal maxPurchasedValue;

	private String goodsNo;

	private BigDecimal minQuantity;

	private BigDecimal maxQuantity;

	private GiftInfo gift;

	public void setStoreNames(Set<String> storeNames) {
		this.storeNames = storeNames;
	}

	public void setStartCheckedTime(Date startCheckedTime) {
		this.startCheckedTime = startCheckedTime;
	}

	public void setEndCheckedTime(Date endCheckedTime) {
		this.endCheckedTime = endCheckedTime;
	}

	public void setMinPayment(BigDecimal minPayment) {
		this.minPayment = minPayment;
	}

	public void setMaxPayment(BigDecimal maxPayment) {
		this.maxPayment = maxPayment;
	}

	public void setMinPurchasedValue(BigDecimal minPurchasedValue) {
		this.minPurchasedValue = minPurchasedValue;
	}

	public void setMaxPurchasedValue(BigDecimal maxPurchasedValue) {
		this.maxPurchasedValue = maxPurchasedValue;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public void setMinQuantity(BigDecimal minQuantity) {
		this.minQuantity = minQuantity;
	}

	public void setMaxQuantity(BigDecimal maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public void setGift(GiftInfo gift) {
		this.gift = gift;
	}

	public Set<String> getStoreNames() {
		return storeNames;
	}

	public Date getStartCheckedTime() {
		return startCheckedTime;
	}

	public Date getEndCheckedTime() {
		return endCheckedTime;
	}

	public BigDecimal getMinPayment() {
		return minPayment;
	}

	public BigDecimal getMaxPayment() {
		return maxPayment;
	}

	public BigDecimal getMinPurchasedValue() {
		return minPurchasedValue;
	}

	public BigDecimal getMaxPurchasedValue() {
		return maxPurchasedValue;
	}

	public String getGoodsNo() {
		return goodsNo;
	}

	public BigDecimal getMinQuantity() {
		return minQuantity;
	}

	public BigDecimal getMaxQuantity() {
		return maxQuantity;
	}

	public GiftInfo getGift() {
		return gift;
	}

	public boolean getDev() {
		return dev;
	}

	public void setDev(boolean dev) {
		this.dev = dev;
	}

	@Override
	public String toString() {
		return "Promotion [dev=" + dev + ", storeNames=" + storeNames + ", startCheckedTime=" + startCheckedTime
				+ ", endCheckedTime=" + endCheckedTime + ", minPayment=" + minPayment + ", maxPayment=" + maxPayment
				+ ", minPurchasedValue=" + minPurchasedValue + ", maxPurchasedValue=" + maxPurchasedValue + ", goodsNo="
				+ goodsNo + ", minQuantity=" + minQuantity + ", maxQuantity=" + maxQuantity + ", gift=" + gift + "]";
	}

}
