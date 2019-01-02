package com.llq.gift.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.llq.gift.AppException;
import com.llq.gift.module.Gift;
import com.llq.gift.module.GiftItem;
import com.llq.gift.module.GoodsCriterion;
import com.llq.gift.module.PaymentCriterion;
import com.llq.gift.module.Promotion;
import com.llq.gift.module.PvCriterion;
import com.llq.gift.service.PromotionService;
import com.llq.gift.vo.GiftItemVo;
import com.llq.gift.vo.GiftVo;
import com.llq.gift.vo.GoodsCriteriaAddRequest;
import com.llq.gift.vo.GoodsCriteriaAddResponse;
import com.llq.gift.vo.GoodsCriterionVo;
import com.llq.gift.vo.PaymentCriteriaAddRequest;
import com.llq.gift.vo.PaymentCriteriaAddResponse;
import com.llq.gift.vo.PaymentCriterionVo;
import com.llq.gift.vo.PromotionAddRequest;
import com.llq.gift.vo.PromotionAddResponse;
import com.llq.gift.vo.PromotionPageQueryResponse;
import com.llq.gift.vo.PvCriteriaAddRequest;
import com.llq.gift.vo.PvCriteriaAddResponse;
import com.llq.gift.vo.PvCriterionVo;

@RestController
public class PromotionController {

	private final static String PROMOTION_PAGE_QUERY = "promotion_page_query";

	private final static String PROMOTION_ADD = "promotion_add";

	private final static String PAYMENTCRITERIA_ADD = "paymentcriteria_add";
	
	private final static String PVCRITERIA_ADD = "pvcriteria_add";

	private final static String GOODSCRITERIA_ADD = "goodscriteria_add";

	@Autowired
	private PromotionService promotionService;

	@GetMapping("/" + PROMOTION_PAGE_QUERY)
	public PromotionPageQueryResponse find() {
		Pageable pageable = null;
		Page<Promotion> page = this.promotionService.findPage(pageable);
		PromotionPageQueryResponse rsp = new PromotionPageQueryResponse(page);
		return rsp;
	}

	@PostMapping("/" + PROMOTION_ADD)
	public PromotionAddResponse add(@RequestBody PromotionAddRequest req) {
		Promotion promotion = new Promotion();
		promotion.setComment(req.getComment());
		promotion.setStartTime(req.getStartTime());
		promotion.setEndTime(req.getEndTime());
		String[] storeNames = new String[req.getStoreNames().size()];
		req.getStoreNames().toArray(storeNames);
		Promotion saved = this.promotionService.create(promotion, storeNames);
		return new PromotionAddResponse(saved);
	}

	@PostMapping("/" + PAYMENTCRITERIA_ADD)
	public PaymentCriteriaAddResponse addPaymentCriteria(@RequestBody PaymentCriteriaAddRequest req) {
		Promotion promotion = this.promotionService.getById(req.getPromotionCode());
		if (promotion == null) {
			throw new AppException("bad promotion code");
		}
		for (PaymentCriterionVo criterion : req.getPaymentCriteria()) {
			GiftVo giftVo = criterion.getGift();
			Gift gift = new Gift();
			gift.setComment(giftVo.getComment());
			for (GiftItemVo giftItemVo : giftVo.getItems()) {
				GiftItem giftItem = new GiftItem();
				giftItem.setGift(gift);
				giftItem.setGoodsNo(giftItemVo.getGoodsNo());
				giftItem.setQuantity(giftItemVo.getQuantity());
				gift.getItems().add(giftItem);
			}
			
			PaymentCriterion paymentCriterion = new PaymentCriterion();
			paymentCriterion.setPromotion(promotion);
			paymentCriterion.setGift(gift);
			paymentCriterion.setMinPayment(criterion.getMinPayment());
			paymentCriterion.setMaxPayment(criterion.getMaxPayment());
			promotion.getPaymentCriteria().add(paymentCriterion);
		}
		Promotion saved = this.promotionService.save(promotion);
		return new PaymentCriteriaAddResponse(saved.getPaymentCriteria());
	}
	
	
	@PostMapping("/" + PVCRITERIA_ADD)
	public PvCriteriaAddResponse addPvCriteria(@RequestBody PvCriteriaAddRequest req) {
		Promotion promotion = this.promotionService.getById(req.getPromotionCode());
		if (promotion == null) {
			throw new AppException("bad promotion code");
		}
		for (PvCriterionVo criterion : req.getPvCriteria()) {
			GiftVo giftVo = criterion.getGift();
			Gift gift = new Gift();
			gift.setComment(giftVo.getComment());
			for (GiftItemVo giftItemVo : giftVo.getItems()) {
				GiftItem giftItem = new GiftItem();
				giftItem.setGift(gift);
				giftItem.setGoodsNo(giftItemVo.getGoodsNo());
				giftItem.setQuantity(giftItemVo.getQuantity());
				gift.getItems().add(giftItem);
			}
			
			PvCriterion pvCriterion = new PvCriterion();
			pvCriterion.setPromotion(promotion);
			pvCriterion.setGift(gift);
			pvCriterion.setMinPv(criterion.getMinPv());
			pvCriterion.setMaxPv(criterion.getMaxPv());
			promotion.getPvCriteria().add(pvCriterion);
		}
		Promotion saved = this.promotionService.save(promotion);
		return new PvCriteriaAddResponse(saved.getPvCriteria());
	}

	@PostMapping("/" + GOODSCRITERIA_ADD)
	public GoodsCriteriaAddResponse addGoodsCriteria(@RequestBody GoodsCriteriaAddRequest req) {
		Promotion promotion = this.promotionService.getById(req.getPromotionCode());
		if (promotion == null) {
			throw new AppException("bad promotion code");
		}
		for (GoodsCriterionVo criterion : req.getGoodsCriteria()) {
			GiftVo giftVo = criterion.getGift();
			Gift gift = new Gift();
			gift.setComment(giftVo.getComment());
			for (GiftItemVo giftItemVo : giftVo.getItems()) {
				GiftItem giftItem = new GiftItem();
				giftItem.setGift(gift);
				giftItem.setGoodsNo(giftItemVo.getGoodsNo());
				giftItem.setQuantity(giftItemVo.getQuantity());
				gift.getItems().add(giftItem);
			}
			
			GoodsCriterion goodsCriterion = new GoodsCriterion();
			goodsCriterion.setPromotion(promotion);
			goodsCriterion.setGift(gift);
			goodsCriterion.setGoodsNo(criterion.getGoodsNo());
			goodsCriterion.setMinQuantity(criterion.getMinQuantity());
			goodsCriterion.setMaxQuantity(criterion.getMaxQuantity());
			promotion.getGoodsCriteria().add(goodsCriterion);
		}
		Promotion saved = this.promotionService.save(promotion);
		return new GoodsCriteriaAddResponse(saved.getGoodsCriteria());
	}
	
}
