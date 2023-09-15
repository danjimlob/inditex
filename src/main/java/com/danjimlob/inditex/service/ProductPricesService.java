package com.danjimlob.inditex.service;

import java.time.LocalDateTime;

import com.danjimlob.inditex.dto.ProductDto;
import com.danjimlob.inditex.exceptions.InvalidParametersException;
import com.danjimlob.inditex.exceptions.PriceNotFoundException;

public interface ProductPricesService {

	ProductDto getProductPriceByProductBrandDate(int productId, int brandId, LocalDateTime date) throws PriceNotFoundException, InvalidParametersException;
}
