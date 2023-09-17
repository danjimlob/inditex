package com.danjimlob.inditex.controller;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danjimlob.inditex.dto.ProductDto;
import com.danjimlob.inditex.entity.Product;
import com.danjimlob.inditex.exceptions.InvalidParametersException;
import com.danjimlob.inditex.exceptions.PriceNotFoundException;
import com.danjimlob.inditex.repository.ProductRepository;
import com.danjimlob.inditex.service.ProductPricesService;
import com.danjimlon.inditex.commons.Constants;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PriceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PriceController.class);

	private final ProductPricesService productService;
	private final ProductRepository repository;
	DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

	@RequestMapping(value = "prices", method = RequestMethod.GET)
	public List<Product> list() {
		return (List<Product>) repository.findAll();
	}

	@RequestMapping(value = "prices/{id}", method = RequestMethod.GET)
	public Product get(@PathVariable int id) {
		return repository.findById(id).get();
	}

	@ApiOperation(value = "Obtener precios de productos a través del productId, brandId y date")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = Constants.MESSAGE_PRICE_FOUND),
			@ApiResponse(responseCode = "404", description = Constants.MESSAGE_PRICE_FOUND),
			@ApiResponse(responseCode = "500", description = Constants.MESSAGE_INTERNAL_ERROR), })

	@RequestMapping(value = "/prices/{brandId}/{productId}/{priceDate}", method = RequestMethod.GET)
	public ProductDto getProductPrice(@PathVariable int brandId, @PathVariable int productId,
			@PathVariable String priceDate) throws PriceNotFoundException, InvalidParametersException {

		LOGGER.debug("getPrices");

		LocalDateTime localDateTime = LocalDateTime.parse(priceDate, formatter);
		Date convertedStartDate = Date.from(localDateTime.toInstant(ZoneOffset.of("+2")));

		final ProductDto product = productService.getProductPriceByProductBrandDate(productId, brandId,
				convertedStartDate);

		return product;
	}
}
