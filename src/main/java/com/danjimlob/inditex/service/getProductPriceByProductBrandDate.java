package com.danjimlob.inditex.service;

import java.time.LocalDateTime;

import com.danjimlob.inditex.entity.Product;

public interface getProductPriceByProductBrandDate {

	Product getProductPriceByProductBrandDate(int productId, int brandId, LocalDateTime date);
}
