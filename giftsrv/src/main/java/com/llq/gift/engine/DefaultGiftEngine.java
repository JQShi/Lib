package com.llq.gift.engine;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.llq.gift.engine.activity.Activity;
import com.llq.gift.engine.activity.DefaultActivity;
import com.llq.gift.engine.gift.Gift;
import com.llq.gift.engine.gift.GiftInfo;
import com.llq.gift.engine.order.OrderInfo;
import com.llq.gift.engine.predicate.CheckedTimePredicate;
import com.llq.gift.engine.predicate.CompositePredicate;
import com.llq.gift.engine.predicate.DevPredicate;
import com.llq.gift.engine.predicate.OrderPredicate;
import com.llq.gift.engine.predicate.PaymentPredicate;
import com.llq.gift.engine.predicate.PurchasedValuePredicate;
import com.llq.gift.engine.predicate.RangeQuantityPredicate;
import com.llq.gift.engine.predicate.StoreNamePredicate;
import com.llq.gift.engine.promotion.PromotionInfo;
import com.llq.gift.engine.promotion.PromotionService;

public class DefaultGiftEngine implements GiftEngine {

	private PromotionService promotionService;

	private volatile List<Activity> activities = Collections.emptyList();

	private final static DevPredicate DEV_PREDICATE = new DevPredicate();

	public DefaultGiftEngine(PromotionService promotionService) {
		super();
		this.promotionService = promotionService;
	}

	@Override
	@PostConstruct
	public boolean refresh() {
		List<PromotionInfo> promotions = this.promotionService.loadAll();
//		System.out.println(promotions);
		List<Activity> copy = promotions.stream().map(p -> {
			Set<OrderPredicate> set = new HashSet<>();
			if (p.getStoreNames() != null && !p.getStoreNames().isEmpty()) {
				StoreNamePredicate storeNamePredicate = new StoreNamePredicate(p.getStoreNames());
				set.add(storeNamePredicate);
			}
			if (p.getStartCheckedTime() != null && p.getEndCheckedTime() != null) {
				CheckedTimePredicate checkedTimePredicate = new CheckedTimePredicate(p.getStartCheckedTime(),
						p.getEndCheckedTime());
				set.add(checkedTimePredicate);
			}
			if (p.getMinPayment() != null && p.getMaxPayment() != null) {
				PaymentPredicate paymentPredicate = new PaymentPredicate(p.getMinPayment(), p.getMaxPayment());
				set.add(paymentPredicate);
			}
			if (p.getMinPurchasedValue() != null && p.getMaxPurchasedValue() != null) {
				PurchasedValuePredicate purchasedValuePredicate = new PurchasedValuePredicate(p.getMinPurchasedValue(),
						p.getMaxPurchasedValue());
				set.add(purchasedValuePredicate);
			}
			if (p.getGoodsNo() != null && p.getGoodsNo().length() > 0 && p.getMinQuantity() != null
					&& p.getMaxQuantity() != null) {
				RangeQuantityPredicate rangeQuantityPredicate = new RangeQuantityPredicate(p.getGoodsNo(),
						p.getMinQuantity(), p.getMaxQuantity());
				set.add(rangeQuantityPredicate);
			}
			if (p.getDev()) {
				set.add(DEV_PREDICATE);
			}
			List<OrderPredicate> predicates = set.stream().filter(x -> x.isValidated()).collect(Collectors.toList());
			CompositePredicate compositePredicate = new CompositePredicate(predicates);
			Gift gift = new Gift(p.getGift().getComment(), p.getGift().getItems());
			Activity activity = new DefaultActivity(compositePredicate, gift);
			return activity;
		}).collect(Collectors.toList());
		this.activities = copy;
		return true;
	}

	@Override
	public Set<GiftInfo> present(OrderInfo order) {
		Set<GiftInfo> gifts = this.activities.stream().map(t -> t.present(order)).filter(x -> x != null)
				.collect(Collectors.toSet());
		return gifts;
	}

	@Override
	public String toString() {
		return "DefaultGiftEngine [promotionService=" + promotionService + ", activities=" + activities + "]";
	}

	@Override
	public List<Activity> getActivities() {
		return this.activities;
	}
	
	

}
