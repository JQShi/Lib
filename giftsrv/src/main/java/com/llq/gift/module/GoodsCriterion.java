package com.llq.gift.module;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "G_GOODSCRITERION")
public class GoodsCriterion {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table_gen")
	@TableGenerator(name = "table_gen", // name对应@GeneratedValue中generator 引用的名字
	table = "seq_table_generator", // 对应数据库表中的名字,表键-字段名
	pkColumnName = "seq_name", // 指定主键的名字
	pkColumnValue = "G_GOODSCRITERION", // 指定下次插入主键时使用默认的值，表键-字段值
	valueColumnName = "seq_id", // 该主键当前所生成的值，它的值将会随着每次创建累加,表值-字段名
	initialValue = 1, // 初始化值
	allocationSize = 1 // 累加值，每次累加1
	)
	private Long id;
	
	@Basic
	@Column(name = "GOODS_NO", length = 64)
	private String goodsNo;

	@Basic
	@Column(name = "MIN_QUANTITY")
	private BigDecimal minQuantity;

	@Basic
	@Column(name = "MAX_QUANTITY")
	private BigDecimal maxQuantity;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "GIFT_ID", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private Gift gift;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Promotion.class, optional = false)
	@JoinColumn(name = "PROMOTION_ID", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT) )
	private Promotion promotion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public BigDecimal getMinQuantity() {
		return minQuantity;
	}

	public void setMinQuantity(BigDecimal minQuantity) {
		this.minQuantity = minQuantity;
	}

	public BigDecimal getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(BigDecimal maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public Gift getGift() {
		return gift;
	}

	public void setGift(Gift gift) {
		this.gift = gift;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	@Override
	public String toString() {
		return "GoodsCriterion [id=" + id + ", goodsNo=" + goodsNo + ", minQuantity=" + minQuantity + ", maxQuantity="
				+ maxQuantity + ", gift=" + gift + "]";
	}
	
	
	
}
