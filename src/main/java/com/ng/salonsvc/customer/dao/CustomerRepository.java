package com.ng.salonsvc.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ng.salonsvc.customer.dao.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>{

	//use inbuilt JPA provided methods for CRUD operations like save , find
	//only custom or JPA methods should be declared
	CustomerEntity findById(int id);
}
