package com.llq.gift.vo;

import java.util.Collections;
import java.util.Set;

public class GoodsCriteriaAddRequest {

	private Long promotionCode;

	private Set<GoodsCriterionVo> goodsCriteria = Collections.emptySet();

	public Long getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(Long promotionCode) {
		this.promotionCode = promotionCode;
	}

	public Set<GoodsCriterionVo> getGoodsCriteria() {
		return goodsCriteria;
	}

	public void setGoodsCriteria(Set<GoodsCriterionVo> goodsCriteria) {
		this.goodsCriteria = goodsCriteria;
	}

	@Override
	public String toString() {
		return "GoodsCriteriaAddRequest [promotionCode=" + promotionCode + ", goodsCriteria=" + goodsCriteria + "]";
	}

}
