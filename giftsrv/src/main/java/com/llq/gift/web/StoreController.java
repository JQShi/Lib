package com.llq.gift.web;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.llq.gift.module.Store;
import com.llq.gift.service.StoreService;
import com.llq.gift.vo.StorePageQueryResponse;
import com.llq.gift.vo.StoresAddRequest;
import com.llq.gift.vo.StoresAddResponse;

@RestController
public class StoreController {

	private static final String STORE_PAGE_QUERY = "store_page_query";

	private static final String STORE_ADD = "store_add";

	@Autowired
	private StoreService storeService;

	@GetMapping("/" + STORE_PAGE_QUERY)
	public StorePageQueryResponse findAll() {
		Pageable pageable = null;
		Page<Store> page = this.storeService.findAll(pageable);
		StorePageQueryResponse rsp = new StorePageQueryResponse(page);
		return rsp;
	}

	@PostMapping("/" + STORE_ADD)
	public StoresAddResponse add(@RequestBody StoresAddRequest req) {
		Set<Store> stores = new HashSet<>();
		for (String storeName : req.getStoreNames()) {
			Store store = this.storeService.add(storeName);
			stores.add(store);
		}
		StoresAddResponse rsp = new StoresAddResponse(stores);
		return rsp;
	}
}
