package com.llq.gift.vo;

import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class PromotionAddRequest {

	private String comment;

	private Set<String> storeNames;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(example = "2018-12-21 10:12:01")
	private Date startTime;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(example = "2018-12-19 10:12:01")
	private Date endTime;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Set<String> getStoreNames() {
		return storeNames;
	}

	public void setStoreNames(Set<String> storeNames) {
		this.storeNames = storeNames;
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

	@Override
	public String toString() {
		return "PromotionAddRequest [comment=" + comment + ", storeNames=" + storeNames + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}

}
