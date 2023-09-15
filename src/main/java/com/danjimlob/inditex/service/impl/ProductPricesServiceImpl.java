package com.danjimlob.inditex.service.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import com.danjimlob.inditex.dto.ProductDto;
import com.danjimlob.inditex.entity.Product;
import com.danjimlob.inditex.exceptions.InvalidParametersException;
import com.danjimlob.inditex.exceptions.PriceNotFoundException;
import com.danjimlob.inditex.repository.ProductRepository;
import com.danjimlob.inditex.service.ProductPricesService;
import com.danjimlob.inditex.service.validators.ParameterValidation;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductPricesServiceImpl implements ProductPricesService {

	private final ParameterValidation parameterValidation;
	
	private final ProductRepository productRepository;
	
	@Override
	public ProductDto getProductPriceByProductBrandDate(final int productId, final int brandId,
			final LocalDateTime date) throws InvalidParametersException, PriceNotFoundException {
		
		ProductDto productReturn = null;
		
		if(!parameterValidation.validateParameters(productId, brandId)) {
			throw new InvalidParametersException(String.format("Invalid parameters productId: <%d>, brandId: <%d>", productId, brandId));
		}

		final List<ProductDto> productList = Optional.ofNullable(productRepository.getProduct(productId, brandId, date))
				.orElse(Collections.emptyList()).stream().map(product -> toDto(product)).collect(Collectors.toList());

		if(CollectionUtils.isEmpty(productList)) {
			throw new PriceNotFoundException("Price not found");
		} else {
			if (productList.size() > 1) {
				//Recorremos la lista para obtener el de mayor prioridad.
				productReturn = Collections.max(productList,
						(p1, p2) -> Integer.compare(p1.getPriority(), p2.getPriority()));
			} else {
				productReturn = productList.get(0);
			}
		}

		return productReturn;

	}
	
	ProductDto toDto(Product product) {
		
		return ProductDto.builder()
				.productId(product.getProductId())
				.brandId(product.getBrandId())
				.priority(product.getPriority())
				.startDate(product.getStartDate())
				.endDate(product.getEndDate())
				.price(product.getPrice())
				.priceList(product.getPriceList()).build();
	}
	
	
}
