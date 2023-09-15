package com.danjimlob.inditex.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProductDto implements Serializable {

  private static final long serialVersionUID = 1L;

	private int productId;

	private int brandId;

	private int tariffRate;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	private BigDecimal price;

	public ProductDto(int productId, int brandId, int tariffRate, LocalDateTime startDate, LocalDateTime endDate,
			BigDecimal price) {
		this.productId = productId;
		this.brandId = brandId;
		this.tariffRate = tariffRate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
  }

  public ProductDto(){}
}
