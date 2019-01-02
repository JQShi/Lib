package com.llq.gift.repo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.llq.gift.module.Promotion;

@Repository
public interface PromotionRepo extends JpaRepository<Promotion, Serializable> {

	
	List<Promotion> findByEndTimeAfter(Date time);
	
}
