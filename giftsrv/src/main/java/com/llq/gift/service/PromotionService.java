package com.llq.gift.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.llq.gift.module.Promotion;

public interface PromotionService {

	public Promotion getById(Long id);
	
	public Promotion save(Promotion promotion);
	public Promotion create(Promotion promotion, String... storeNames);
	
	public List<Promotion> findAll();

	public Page<Promotion> findPage(Pageable pageable);

}
