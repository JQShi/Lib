package com.llq.gift.engine.promotion;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.llq.gift.engine.gift.GiftInfo;

public interface PromotionInfo {

	public boolean getDev();
	
	public Set<String> getStoreNames();
	
	public Date getStartCheckedTime();
	
	public Date getEndCheckedTime();
	
	public BigDecimal getMinPayment();
	
	public BigDecimal getMaxPayment();
	
	public BigDecimal getMinPurchasedValue();
	
	public BigDecimal getMaxPurchasedValue();
	
	public String getGoodsNo();
	
	public BigDecimal getMinQuantity();
	
	public BigDecimal getMaxQuantity();
	
	public GiftInfo getGift();
	
}
