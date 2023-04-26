package com.ng.salonsvc.product.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.ng.salonsvc.product.model.Product;
import com.ng.salonsvc.product.dao.ProductRepository;
import com.ng.salonsvc.product.dao.entity.ProductEntity;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
			System.out.println("Product add operation : "+product.getId());
			//Request to entity mapping
			ProductEntity productEntity= new ProductEntity();
			productEntity.setId(product.getId());
			productEntity.setName(product.getName());
			productEntity.setPrice(product.getPrice());
			productEntity.setDesc(product.getDesc());
			ProductEntity save = productRepository.save(productEntity);
			System.out.println("product Id :"+save.getId());
			return product;
		}

	

	
	@Override
	public List<ProductEntity> getAllProduct() {
		List <ProductEntity> list = productRepository.findAll();
		return list;
	}
	
}
