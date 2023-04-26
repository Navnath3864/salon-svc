package com.ng.salonsvc.product.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ng.salonsvc.product.dao.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

	//use inbuilt JPA provided methods for CRUD operations like save , find
	//only custom or JPA methods should be declared
}
