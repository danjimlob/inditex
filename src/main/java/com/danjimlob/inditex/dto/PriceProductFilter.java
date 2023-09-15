package com.danjimlob.inditex.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PriceProductFilter implements Serializable {

  private static final long serialVersionUID = 1L;

	private int productId;

	private int brandId;

	private LocalDateTime date;

	public PriceProductFilter(int productId, int brandId, LocalDateTime date) {
		this.productId = productId;
		this.brandId = brandId;
		this.date = date;
	}

	public PriceProductFilter() {
	}
}
