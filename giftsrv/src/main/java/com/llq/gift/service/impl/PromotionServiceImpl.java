package com.llq.gift.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.llq.gift.module.Promotion;
import com.llq.gift.module.Store;
import com.llq.gift.repo.PromotionRepo;
import com.llq.gift.repo.StoreRepo;
import com.llq.gift.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {

	@Autowired
	private PromotionRepo promotionRepo;

	@Autowired
	private StoreRepo storeRepo;

	@Override
	public Promotion getById(Long id) {
		return this.promotionRepo.getOne(id);
	}
	
	@Override
	public Promotion save(Promotion promotion) {
		return this.promotionRepo.save(promotion);
	}

	@Override
	public Promotion create(Promotion promotion, String... storeNames) {
		promotion.setDev(Boolean.TRUE);
		for (String storeName : storeNames) {
			Store store = this.storeRepo.getByStoreName(storeName);
			promotion.getStores().add(store);
		}
		return this.promotionRepo.save(promotion);
	}

	public List<Promotion> findAll() {
		return this.promotionRepo.findAll();
	}

	@Override
	public Page<Promotion> findPage(Pageable pageable) {
		return this.promotionRepo.findAll(pageable);
	}

	

}
