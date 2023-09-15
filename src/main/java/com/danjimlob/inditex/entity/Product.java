package com.danjimlob.inditex.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@ToString
@Table(name="p1_prices_product")

public class Product extends CreationAndLastUpdateHistory {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	
	@Column(name = "brand_id")
	private int brandId;

	@Column(name = "start_date")
	private LocalDateTime startDate;

	@Column(name = "end_date")
	private LocalDateTime endDate;
	
	@Column(name = "price_list")
	private int priceList;
	
	@Column(name = "product_id")
	private int productId;

	@Column(name = "priority")
	private int priority;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "curr")
	private String curr;
	


}
