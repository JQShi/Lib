package com.llq.gift.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.llq.gift.module.Store;
import com.llq.gift.repo.StoreRepo;
import com.llq.gift.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepo storeRepo;
	
	public Page<Store> findAll(Pageable pageable) {
		return this.storeRepo.findAll(pageable);
	}
	
	public Store add(String storeName) {
		int count = this.storeRepo.countByStoreName(storeName);
		if (count > 0) {
			return this.storeRepo.getByStoreName(storeName);
		}
		Store store = new Store();
		store.setStoreName(storeName);
		return this.storeRepo.save(store);
	}
	
}
