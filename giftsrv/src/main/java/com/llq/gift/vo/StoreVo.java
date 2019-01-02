package com.llq.gift.vo;

public class StoreVo {

	private Long storeCode;

	private String storeName;

	public Long getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(Long storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	@Override
	public String toString() {
		return "StoreVo [storeCode=" + storeCode + ", storeName=" + storeName + "]";
	}

}
