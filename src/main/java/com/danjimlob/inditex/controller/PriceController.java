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

  @PostMapping("/price")
  @ApiOperation(value = "Obtener precios de productos a través del productId, brandId y date")
  @ApiResponses({
	  @ApiResponse(responseCode = "200", description = "Precio encontrado"),
	  @ApiResponse(responseCode = "404", description = "Precio no encontrado"),
	  @ApiResponse(responseCode = "500", description = "Error interno, contacte con el administrador"),
      })
  
  public ResponseEntity<ProductDto> getProductPrice( @RequestBody PriceProductFilter filter){
	    
	  LOGGER.debug("getPrices");
	  //Llamada método servicio prices

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
