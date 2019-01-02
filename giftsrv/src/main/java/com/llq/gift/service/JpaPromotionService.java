package com.llq.gift.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.llq.gift.engine.gift.Gift;
import com.llq.gift.engine.gift.GiftInfo;
import com.llq.gift.engine.order.OrderItem;
import com.llq.gift.engine.order.OrderItemInfo;
import com.llq.gift.engine.promotion.PromotionInfo;
import com.llq.gift.engine.promotion.PromotionService;
import com.llq.gift.module.GoodsCriterion;
import com.llq.gift.module.PaymentCriterion;
import com.llq.gift.module.Promotion;
import com.llq.gift.module.PvCriterion;
import com.llq.gift.repo.PromotionRepo;

@Service
public class JpaPromotionService implements PromotionService {

	@Autowired
	private PromotionRepo promotionRepo;

	@Override
	@Transactional(readOnly = true)
	public List<PromotionInfo> loadAll() {

		List<PromotionInfo> promotions = new ArrayList<>();
		Date now = Calendar.getInstance().getTime();
		List<Promotion> list = this.promotionRepo.findByEndTimeAfter(now);
		for (Promotion entity : list) {
			Set<String> storeNames = entity.getStores().stream().map(s -> s.getStoreName()).collect(Collectors.toSet());
			Date startTime = entity.getStartTime();
			Date endTime = entity.getEndTime();
			boolean dev = entity.getDev();

			for (PaymentCriterion pc : entity.getPaymentCriteria()) {
				com.llq.gift.engine.promotion.Promotion promotion = new com.llq.gift.engine.promotion.Promotion();
				promotion.setStoreNames(storeNames);
				promotion.setDev(dev);
				promotion.setEndCheckedTime(endTime);
				promotion.setStartCheckedTime(startTime);

				Set<OrderItemInfo> orderItems = pc.getGift().getItems().stream()
						.map(i -> new OrderItem(i.getGoodsNo(), i.getQuantity())).collect(Collectors.toSet());
				GiftInfo gift = new Gift(pc.getGift().getComment(), orderItems);
				promotion.setGift(gift);
				promotion.setMinPayment(pc.getMinPayment());
				promotion.setMaxPayment(pc.getMaxPayment());
				promotions.add(promotion);
			}

			for (PvCriterion pc : entity.getPvCriteria()) {
				com.llq.gift.engine.promotion.Promotion promotion = new com.llq.gift.engine.promotion.Promotion();
				promotion.setStoreNames(storeNames);
				promotion.setDev(dev);
				promotion.setEndCheckedTime(endTime);
				promotion.setStartCheckedTime(startTime);

				Set<OrderItemInfo> orderItems = pc.getGift().getItems().stream()
						.map(i -> new OrderItem(i.getGoodsNo(), i.getQuantity())).collect(Collectors.toSet());
				GiftInfo gift = new Gift(pc.getGift().getComment(), orderItems);
				promotion.setGift(gift);
				promotion.setMinPurchasedValue(pc.getMinPv());
				promotion.setMaxPurchasedValue(pc.getMaxPv());
				promotions.add(promotion);
			}

			for (GoodsCriterion gc : entity.getGoodsCriteria()) {
				com.llq.gift.engine.promotion.Promotion promotion = new com.llq.gift.engine.promotion.Promotion();
				promotion.setStoreNames(storeNames);
				promotion.setDev(dev);
				promotion.setEndCheckedTime(endTime);
				promotion.setStartCheckedTime(startTime);

				Set<OrderItemInfo> orderItems = gc.getGift().getItems().stream()
						.map(i -> new OrderItem(i.getGoodsNo(), i.getQuantity())).collect(Collectors.toSet());
				GiftInfo gift = new Gift(gc.getGift().getComment(), orderItems);
				promotion.setGift(gift);
				promotion.setGoodsNo(gc.getGoodsNo());
				promotion.setMinQuantity(gc.getMinQuantity());
				promotion.setMaxQuantity(gc.getMaxQuantity());
				promotions.add(promotion);
			}

		}

		return promotions;
	}

}
