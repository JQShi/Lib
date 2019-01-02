package com.llq.gift.module;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "G_PROMOTION")
public class Promotion {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table_gen")
	@TableGenerator(name = "table_gen", // name对应@GeneratedValue中generator 引用的名字
	table = "seq_table_generator", // 对应数据库表中的名字,表键-字段名
	pkColumnName = "seq_name", // 指定主键的名字
	pkColumnValue = "G_PROMOTION", // 指定下次插入主键时使用默认的值，表键-字段值
	valueColumnName = "seq_id", // 该主键当前所生成的值，它的值将会随着每次创建累加,表值-字段名
	initialValue = 1, // 初始化值
	allocationSize = 1 // 累加值，每次累加1
	)
	private Long id;

	@Basic
	@Column(name = "COMMENTS", length = 255)
	private String comment;

	@ManyToMany(fetch = FetchType.LAZY, targetEntity = Store.class)
	@JoinTable(name = "G_STORE_PROMOTION", joinColumns = { @JoinColumn(name = "PROMOTION_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "STORE_ID") }, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT) )
	private Set<Store> stores = new HashSet<>();

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_TIME")
	private Date startTime;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_TIME")
	private Date endTime;

	@Basic
	@Column(name = "IS_DEV")
	private boolean dev = false;

	@SuppressWarnings("deprecation")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "promotion", targetEntity = GoodsCriterion.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.ForeignKey(name = "none")
	private Set<GoodsCriterion> goodsCriteria = new HashSet<>();

	@SuppressWarnings("deprecation")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "promotion", targetEntity = PaymentCriterion.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.ForeignKey(name = "none")
	private Set<PaymentCriterion> paymentCriteria = new HashSet<>();

	@SuppressWarnings("deprecation")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "promotion", targetEntity = PvCriterion.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.ForeignKey(name = "none")
	private Set<PvCriterion> pvCriteria = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Set<Store> getStores() {
		return stores;
	}

	public void setStores(Set<Store> stores) {
		this.stores = stores;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public boolean getDev() {
		return dev;
	}

	public void setDev(boolean dev) {
		this.dev = dev;
	}

	public Set<GoodsCriterion> getGoodsCriteria() {
		return goodsCriteria;
	}

	public void setGoodsCriteria(Set<GoodsCriterion> goodsCriteria) {
		this.goodsCriteria = goodsCriteria;
	}

	public Set<PaymentCriterion> getPaymentCriteria() {
		return paymentCriteria;
	}

	public void setPaymentCriteria(Set<PaymentCriterion> paymentCriteria) {
		this.paymentCriteria = paymentCriteria;
	}

	public Set<PvCriterion> getPvCriteria() {
		return pvCriteria;
	}

	public void setPvCriteria(Set<PvCriterion> pvCriteria) {
		this.pvCriteria = pvCriteria;
	}

	@Override
	public String toString() {
		return "Promotion [id=" + id + ", comment=" + comment + ", stores=" + stores + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", dev=" + dev + ", goodsCriteria=" + goodsCriteria + ", paymentCriteria="
				+ paymentCriteria + ", pvCriteria=" + pvCriteria + "]";
	}

}
