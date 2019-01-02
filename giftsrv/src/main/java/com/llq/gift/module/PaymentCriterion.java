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
@Table(name = "G_PAYMENTCRITERION")
public class PaymentCriterion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table_gen")
	@TableGenerator(name = "table_gen", // name对应@GeneratedValue中generator 引用的名字
	table = "seq_table_generator", // 对应数据库表中的名字,表键-字段名
	pkColumnName = "seq_name", // 指定主键的名字
	pkColumnValue = "G_PAYMENTCRITERION", // 指定下次插入主键时使用默认的值，表键-字段值
	valueColumnName = "seq_id", // 该主键当前所生成的值，它的值将会随着每次创建累加,表值-字段名
	initialValue = 1, // 初始化值
	allocationSize = 1 // 累加值，每次累加1
	)
	private Long id;

	@Basic
	@Column(name = "MIN_PAYMENT")
	private BigDecimal minPayment;

	@Basic
	@Column(name = "MAX_PAYMENT")
	private BigDecimal maxPayment;
	
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

	public BigDecimal getMinPayment() {
		return minPayment;
	}

	public void setMinPayment(BigDecimal minPayment) {
		this.minPayment = minPayment;
	}

	public BigDecimal getMaxPayment() {
		return maxPayment;
	}

	public void setMaxPayment(BigDecimal maxPayment) {
		this.maxPayment = maxPayment;
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
		return "PaymentCriterion [id=" + id + ", minPayment=" + minPayment + ", maxPayment=" + maxPayment + ", gift="
				+ gift + "]";
	}
	
	
	
}
