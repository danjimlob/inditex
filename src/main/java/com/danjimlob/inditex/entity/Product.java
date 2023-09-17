package com.danjimlob.inditex.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Builder
public class Product extends CreationAndLastUpdateHistory {

	@Column(name = "brandId")
	private int brandId;

	@Column(name = "startDate")
	private Date startDate;

	@Column(name = "endDate")
	private Date endDate;

	@Id
	@Column(name = "priceList")
	private int priceList;

	@Column(name = "productId")
	private int productId;

	@Column(name = "priority")
	private int priority;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "curr")
	private String curr;

}
