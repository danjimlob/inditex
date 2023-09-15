package com.danjimlob.inditex.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
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

	private int brandId;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	private BigDecimal price;
	
	private int productId;

	private int priority;

	private int tariffRate;

}
