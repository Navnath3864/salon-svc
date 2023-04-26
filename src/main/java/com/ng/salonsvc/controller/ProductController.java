package com.ng.salonsvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ng.salonsvc.product.dao.entity.ProductEntity;
import com.ng.salonsvc.product.model.Product;
import com.ng.salonsvc.product.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("")
	public List<ProductEntity> getProducts() {
		List<ProductEntity> list = productService.getAllProduct();
		return list;
	}

	@PostMapping("")
	public String post(@RequestBody Product product) {

		productService.addProduct(product);
		return product.toString();

	}

}