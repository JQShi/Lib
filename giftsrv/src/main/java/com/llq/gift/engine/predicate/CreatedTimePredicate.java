package com.llq.gift.engine.predicate;

import java.util.Date;

import com.llq.gift.engine.order.OrderInfo;

public class CreatedTimePredicate implements OrderPredicate {

	private final Date start;

	private final Date end;

	public CreatedTimePredicate(Date start, Date end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public boolean test(OrderInfo t) {
		if (!isValidated() || t.getCreatedTime() == null) {
			return false;
		}
		return this.start.before(t.getCreatedTime()) && this.end.after(t.getCreatedTime());
	}

	@Override
	public boolean isValidated() {
		return this.start != null && this.end != null;
	}

	@Override
	public String toString() {
		return "CreatedTimePredicate [start=" + start + ", end=" + end + "]";
	}
	
	

}
