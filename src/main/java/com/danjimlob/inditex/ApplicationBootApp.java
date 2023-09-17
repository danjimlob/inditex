package com.danjimlob.inditex;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.danjimlob.inditex.ApplicationBootApp;
import com.danjimlob.inditex.entity.Product;
import com.danjimlob.inditex.repository.ProductRepository;

@SpringBootApplication
@ComponentScan(basePackages = { "com.danjimlob.inditex" })
public class ApplicationBootApp {

	ZoneId defaultZoneId = ZoneId.systemDefault();

	public static void main(String[] args) {
		SpringApplication.run(ApplicationBootApp.class, args);
	}

	@Bean
	public CommandLineRunner init(ProductRepository repository) {

		return (args) -> {
			Date startDate1 = this.convertToDate(2020, 6, 14, 0, 0, 0);
			Date startDate2 = this.convertToDate(2020, 6, 14, 15, 0, 0);
			Date startDate3 = this.convertToDate(2020, 6, 15, 0, 0, 0);
			Date startDate4 = this.convertToDate(2020, 6, 15, 16, 0, 0);

			Date endDate1 = this.convertToDate(2020, 12, 31, 23, 59, 59);
			Date endDate2 = this.convertToDate(2020, 6, 14, 18, 30, 0);
			Date endDate3 = this.convertToDate(2020, 6, 15, 11, 0, 0);
			Date endDate4 = this.convertToDate(2020, 12, 31, 23, 59, 59);

			repository.save(Product.builder().brandId(1).startDate(startDate1).endDate(endDate1).priceList(1)
					.productId(35455).priority(0).price(BigDecimal.valueOf(35.50)).curr("EUR").build());

			repository.save(Product.builder().brandId(1).startDate(startDate2).endDate(endDate2).priceList(2)
					.productId(35455).priority(1).price(BigDecimal.valueOf(25.45)).curr("EUR").build());

			repository.save(Product.builder().brandId(1).startDate(startDate3).endDate(endDate3).priceList(3)
					.productId(35455).priority(1).price(BigDecimal.valueOf(30.50)).curr("EUR").build());

			repository.save(Product.builder().brandId(1).startDate(startDate4).endDate(endDate4).priceList(4)
					.productId(35455).priority(1).price(BigDecimal.valueOf(38.95)).curr("EUR").build());

		};
	}

	public Date convertToDate(int year, int month, int day, int hour, int min, int sec) {
		return Date.from(LocalDate.of(year, month, day).atTime(hour, min, sec).atZone(defaultZoneId).toInstant());
	}

}
