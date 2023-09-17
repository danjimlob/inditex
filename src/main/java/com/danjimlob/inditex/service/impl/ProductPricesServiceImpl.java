package com.danjimlob.inditex.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.danjimlob.inditex.dto.ProductDto;
import com.danjimlob.inditex.entity.Product;
import com.danjimlob.inditex.exceptions.InvalidParametersException;
import com.danjimlob.inditex.exceptions.PriceNotFoundException;
import com.danjimlob.inditex.repository.ProductRepository;
import com.danjimlob.inditex.service.ProductPricesService;
import com.danjimlob.inditex.service.validators.ParameterValidation;

@Service
public class ProductPricesServiceImpl implements ProductPricesService {

	private final ParameterValidation parameterValidation;

	private final ProductRepository productRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductPricesServiceImpl.class);

	public ProductPricesServiceImpl(final ParameterValidation parameterValidation,
			ProductRepository productRepository) {
		this.parameterValidation = parameterValidation;
		this.productRepository = productRepository;
	}

	@Override
	public ProductDto getProductPriceByProductBrandDate(final int productId, final int brandId, final Date date)
			throws InvalidParametersException, PriceNotFoundException {

		ProductDto productReturn = null;

		if (!parameterValidation.validateParameters(productId, brandId)) {
			LOGGER.error(String.format("Invalid parameters productId: <%d>, brandId: <%d>", productId, brandId));
			throw new InvalidParametersException(
					String.format("Invalid parameters productId: <%d>, brandId: <%d>", productId, brandId));
		}

		Product product = productRepository
				.findFirstByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
						date, date, productId, brandId);

		if (product == null) {
			LOGGER.error("Price not found");
			throw new PriceNotFoundException("Price not found");
		} else {
			productReturn = toDto(product);
		}
		return productReturn;

	}

	ProductDto toDto(Product product) {

		return ProductDto.builder().productId(product.getProductId()).brandId(product.getBrandId())
				.priority(product.getPriority()).startDate(product.getStartDate()).endDate(product.getEndDate())
				.price(product.getPrice()).priceList(product.getPriceList()).build();
	}

}
