package com.llq.gift.vo;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PromotionVo {

	private Long promotionCode;

	private String comment;

	private Set<StoreVo> stores;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;

	private Boolean dev = false;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public boolean getDev() {
		return dev;
	}

	public void setDev(boolean dev) {
		this.dev = dev;
	}

	@Override
	public String toString() {
		return "PromotionVo [promotionCode=" + promotionCode + ", comment=" + comment + ", stores=" + stores
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", dev=" + dev + "]";
	}

}
