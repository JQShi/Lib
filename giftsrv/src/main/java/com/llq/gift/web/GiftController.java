package com.llq.gift.web;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.llq.gift.engine.GiftEngine;
import com.llq.gift.engine.gift.GiftInfo;
import com.llq.gift.engine.order.Order;
import com.llq.gift.engine.order.OrderItem;
import com.llq.gift.engine.order.OrderItemInfo;
import com.llq.gift.vo.GiftItemVo;
import com.llq.gift.vo.GiftQueryRequest;
import com.llq.gift.vo.GiftQueryResponse;
import com.llq.gift.vo.GiftVo;
import com.llq.gift.vo.OrderItemVo;

@RestController
public class GiftController {

	private static final String GIFT_QUERY = "gift_query";
	
	private static final String GIFT_REFRESH = "gift_refresh";

	@Autowired
	private GiftEngine giftEngine;

	@PostMapping("/" + GIFT_QUERY)
	public GiftQueryResponse query(@RequestBody GiftQueryRequest req) {
		Order order = new Order();
		order.setAmount(req.getOrder().getAmount());
		order.setCheckedTime(req.getOrder().getCheckedTime());
		order.setCreatedTime(req.getOrder().getCreatedTime());
		order.setDev(req.getOrder().isDev());
		order.setPayment(req.getOrder().getPayment());
		order.setPurchasedValue(req.getOrder().getPurchasedValue());
		order.setStoreName(req.getOrder().getStoreName());
		Set<OrderItemInfo> items = new HashSet<>();
		for (OrderItemVo orderItemVo : req.getOrder().getItems()) {
			OrderItemInfo orderItem = new OrderItem(orderItemVo.getGoodsNo(), orderItemVo.getQuantity());
			items.add(orderItem);
		}
		order.setItems(items);

		Set<GiftInfo> gifts = this.giftEngine.present(order);
		System.out.println(gifts);
		Set<GiftVo> body = gifts.stream().map(g -> {
			GiftVo gift = new GiftVo();
			gift.setComment(g.getComment());
			Set<GiftItemVo> giftItems = g.getItems().stream().map(i -> {
				GiftItemVo gi = new GiftItemVo();
				gi.setGoodsNo(i.getGoodsNo());
				gi.setQuantity(i.getQuantity());
				return gi;
			}).collect(Collectors.toSet());
			gift.setItems(giftItems);
			return gift;
		}).collect(Collectors.toSet());
		return new GiftQueryResponse(body);
	}
	
	@PostMapping("/" + GIFT_REFRESH)
	public String refresh()	 {
		this.giftEngine.refresh();
		return this.giftEngine.getActivities().toString();
	}

}
