package com.llq.gift.engine.predicate;

import java.util.Date;

import com.llq.gift.engine.order.OrderInfo;

public class CheckedTimePredicate implements OrderPredicate {

	private final Date start;

	private final Date end;

	public CheckedTimePredicate(Date start, Date end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public boolean test(OrderInfo t) {
		if (!isValidated() || t.getCheckedTime() == null) {
			return false;
		}
		return this.start.before(t.getCheckedTime()) && this.end.after(t.getCheckedTime());
	}

	@Override
	public boolean isValidated() {
		return this.start != null && this.end != null;
	}

	@Override
	public String toString() {
		return "CheckedTimePredicate [start=" + start + ", end=" + end + "]";
	}
	
	

}
