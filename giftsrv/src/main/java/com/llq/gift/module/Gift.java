package com.llq.gift.module;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "G_GIFT")
public class Gift {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table_gen")
	@TableGenerator(name = "table_gen", // name对应@GeneratedValue中generator 引用的名字
	table = "seq_table_generator", // 对应数据库表中的名字,表键-字段名
	pkColumnName = "seq_name", // 指定主键的名字
	pkColumnValue = "G_GIFT", // 指定下次插入主键时使用默认的值，表键-字段值
	valueColumnName = "seq_id", // 该主键当前所生成的值，它的值将会随着每次创建累加,表值-字段名
	initialValue = 1, // 初始化值
	allocationSize = 1 // 累加值，每次累加1
	)
	private Long id;

	@Basic
	@Column(name = "COMMENTS", length = 255)
	private String comment;

	@SuppressWarnings("deprecation")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "gift", targetEntity = GiftItem.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.ForeignKey(name = "none")
	private Set<GiftItem> items = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<GiftItem> getItems() {
		return items;
	}

	public void setItems(Set<GiftItem> items) {
		this.items = items;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Gift [id=" + id + ", comment=" + comment + ", items=" + items + "]";
	}

}
