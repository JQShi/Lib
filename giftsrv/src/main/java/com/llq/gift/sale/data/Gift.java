package com.llq.gift.sale.data;

import java.util.HashSet;
import java.util.Set;

public class Gift {

	private String desc;

	private Set<GoodsItem> items = new HashSet<>();

	private Integer times = Integer.valueOf(0);

	public Gift() {
		super();
	}

	public Gift(String desc, Set<GoodsItem> items, Integer times) {
		super();
		this.desc = desc;
		this.items = items;
		this.times = times;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Set<GoodsItem> getItems() {
		return items;
	}

	public void setItems(Set<GoodsItem> items) {
		this.items = items;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	@Override
	public String toString() {
		return "Gift [desc=" + desc + ", items=" + items + ", times=" + times + "]";
	}

}
