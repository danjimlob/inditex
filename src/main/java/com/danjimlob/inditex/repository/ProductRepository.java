package com.danjimlob.inditex.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.danjimlob.inditex.entity.Product;

public interface ProductRepository {

   List<Product> getProduct(int productId, int brandId, LocalDateTime date);
}
