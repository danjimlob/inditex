package com.danjimlob.inditex.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class ProductDto implements Serializable {

  private static final long serialVersionUID = 1L;

	private int productId;

	private int brandId;

	private int priority;

	private LocalDateTime startDate;

	private LocalDateTime endDate;
	
	private int priceList;

	private BigDecimal price;
	
	private String curr;


	public ProductDto(int productId, int brandId, int priority, LocalDateTime startDate, LocalDateTime endDate,
			int priceList,BigDecimal price, String curr) {
		this.productId = productId;
		this.brandId = brandId;
		this.priority = priority;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.price = price;
		this.curr = curr;
  }

  public ProductDto(){}
}
