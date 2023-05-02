package com.ng.salonsvc.customer.service;

import java.util.List;

import com.ng.salonsvc.customer.dao.entity.CustomerEntity;
import com.ng.salonsvc.customer.model.CustomerRequest;;

public interface CustomerService {
	CustomerRequest saveCustomer(CustomerRequest customer);
	List<CustomerEntity> getAllCustomers();
//	CustomerEntity findById(int id);
	CustomerEntity getCustomerById(int id);
}
