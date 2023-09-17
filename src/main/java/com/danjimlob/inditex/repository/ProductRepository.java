package com.danjimlob.inditex.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danjimlob.inditex.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	Product findFirstByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
			Date startDate, Date endDate, int productId, int brandId);

}
