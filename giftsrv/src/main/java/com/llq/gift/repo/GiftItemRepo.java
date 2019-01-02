package com.llq.gift.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.llq.gift.module.GiftItem;

@Repository
public interface GiftItemRepo extends JpaRepository<GiftItem, Serializable> {

}
