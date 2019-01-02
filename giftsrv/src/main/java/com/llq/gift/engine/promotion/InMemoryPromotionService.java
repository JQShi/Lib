package com.llq.gift.engine.promotion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class InMemoryPromotionService implements PromotionService {

	private final List<PromotionInfo> promotions = new ArrayList<>();

	public InMemoryPromotionService(Collection<PromotionInfo> promotions) {
		this.promotions.addAll(promotions);
	}

	@Override
	public List<PromotionInfo> loadAll() {
		return Collections.unmodifiableList(this.promotions);
	}
	


}
