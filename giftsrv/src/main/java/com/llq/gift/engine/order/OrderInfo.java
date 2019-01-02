package com.llq.gift.engine.order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public interface OrderInfo {
	
	public boolean getDev();
	
	public String getStoreName();
	
	public BigDecimal getAmount();
	
	public BigDecimal getPayment();
	
	public BigDecimal getPurchasedValue();
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(example = "2018-12-21 10:12:01")
	public Date getCreatedTime();
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(example = "2018-12-21 10:12:01")
	public Date getCheckedTime();
	
	public Set<OrderItemInfo> getItems();
	
	
}
