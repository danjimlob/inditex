package com.danjimlob.inditex.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danjimlob.inditex.dto.PriceProductFilter;
import com.danjimlob.inditex.dto.ProductDto;
import com.danjimlob.inditex.exceptions.InvalidParametersException;
import com.danjimlob.inditex.exceptions.PriceNotFoundException;
import com.danjimlob.inditex.service.ProductPricesService;
import com.danjimlon.inditex.commons.Constants;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inditex/api")
@RequiredArgsConstructor
public class PriceController {

	  private static final Logger LOGGER = LoggerFactory.getLogger(PriceController.class);
	  
	  private final ProductPricesService productService;
	  

  @PostMapping("/price")
  @ApiOperation(value = "Obtener precios de productos a través del productId, brandId y date")
  @ApiResponses({
	  @ApiResponse(responseCode = "200", description = Constants.MESSAGE_PRICE_FOUND),
	  @ApiResponse(responseCode = "404", description = Constants.MESSAGE_PRICE_FOUND),
	  @ApiResponse(responseCode = "500", description = Constants.MESSAGE_INTERNAL_ERROR),
      })
  
  public ResponseEntity<ProductDto> getProductPrice( @RequestBody PriceProductFilter filter) throws PriceNotFoundException, InvalidParametersException{
	    
	  LOGGER.debug("getPrices");
	  //Llamada método servicio prices
	  
	  final ProductDto product = productService.getProductPriceByProductBrandDate(filter.getProductId(), filter.getBrandId(), filter.getDate());

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
