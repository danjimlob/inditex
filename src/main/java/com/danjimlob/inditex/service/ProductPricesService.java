package com.danjimlob.inditex.service;

import java.util.Date;

import com.danjimlob.inditex.dto.ProductDto;
import com.danjimlob.inditex.exceptions.InvalidParametersException;
import com.danjimlob.inditex.exceptions.PriceNotFoundException;

public interface ProductPricesService {

	ProductDto getProductPriceByProductBrandDate(int productId, int brandId, Date date)
			throws PriceNotFoundException, InvalidParametersException;
}
