package com.danjimlob.inditex.service.validators;

import org.springframework.stereotype.Component;

@Component
public class ParameterValidation {

  public boolean validateParameters(final int productId, final int brandId) {
    return brandId > 0 && productId > 0;
  }
}
