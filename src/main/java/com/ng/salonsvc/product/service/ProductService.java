package com.ng.salonsvc.product.service;

import java.util.List;

import com.ng.salonsvc.product.dao.entity.ProductEntity;
import com.ng.salonsvc.product.model.Product;

public interface ProductService {
	Product addProduct(Product product);
	
	List<ProductEntity> getAllProduct();
}
