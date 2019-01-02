package com.llq.gift.vo;

import java.util.Collections;
import java.util.Set;

public class GiftVo {

	private String comment;
	
	private Set<GiftItemVo> items = Collections.emptySet();

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Set<GiftItemVo> getItems() {
		return items;
	}

	public void setItems(Set<GiftItemVo> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "GiftDto [comment=" + comment + ", items=" + items + "]";
	}
	
	
	
}
