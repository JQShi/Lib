package com.llq.gift.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.llq.gift.engine.DefaultGiftEngine;
import com.llq.gift.engine.GiftEngine;
import com.llq.gift.engine.promotion.PromotionService;

@Configuration
public class GiftConfig {

	@Bean
	@Autowired
	public GiftEngine giftEngine(PromotionService promotionService) {
		return new DefaultGiftEngine(promotionService);
	}
}
