package com.ng.salon.product.service;

import com.ng.salon.product.model.Product;

public interface ProductService {
	Product addProduct(Product product);

	Product getProductById(int id);

	Product getProductByName(String name);
}
