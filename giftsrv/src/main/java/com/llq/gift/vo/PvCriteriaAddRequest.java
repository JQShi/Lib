package com.llq.gift.vo;

import java.util.Collections;
import java.util.Set;

public class PvCriteriaAddRequest {

	private Long promotionCode;

	private Set<PvCriterionVo> pvCriteria = Collections.emptySet();

	public Long getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(Long promotionCode) {
		this.promotionCode = promotionCode;
	}

	public Set<PvCriterionVo> getPvCriteria() {
		return pvCriteria;
	}

	public void setPvCriteria(Set<PvCriterionVo> pvCriteria) {
		this.pvCriteria = pvCriteria;
	}

	@Override
	public String toString() {
		return "PvCriteriaAddRequest [promotionCode=" + promotionCode + ", pvCriteria=" + pvCriteria + "]";
	}

}
