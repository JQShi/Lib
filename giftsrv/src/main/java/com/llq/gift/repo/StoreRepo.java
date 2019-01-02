package com.llq.gift.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.llq.gift.module.Store;

@Repository
public interface StoreRepo extends JpaRepository<Store, Serializable> {

	public int countByStoreName(String storeName);
	
	public Store getByStoreName(String storeName);
}
