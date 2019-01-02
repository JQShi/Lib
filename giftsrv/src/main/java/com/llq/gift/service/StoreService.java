package com.llq.gift.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.llq.gift.module.Store;

public interface StoreService {

	public Page<Store> findAll(Pageable pageable);
	
	public Store add(String storeName);
}
