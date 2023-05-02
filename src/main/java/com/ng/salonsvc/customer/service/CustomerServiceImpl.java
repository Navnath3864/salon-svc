package com.ng.salonsvc.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ng.salonsvc.customer.dao.CustomerRepository;
import com.ng.salonsvc.customer.dao.entity.CustomerEntity;
import com.ng.salonsvc.customer.model.CustomerRequest;
import com.ng.salonsvc.customer.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public CustomerRequest saveCustomer(CustomerRequest customerRequest) {
		System.out.println("Customer save operation : "+customerRequest.getId());
		//Request to entity mapping
		CustomerEntity customerEntity= new CustomerEntity();
		customerEntity.setfName(customerRequest.getfName());
		customerEntity.setlName(customerRequest.getlName());
		customerEntity.setAddress(customerRequest.getAddress());
		customerEntity.setEmail(customerRequest.getEmail());
		customerEntity.setMobNumber(customerRequest.getMobNumber());
		CustomerEntity save = customerRepository.save(customerEntity);
		System.out.println("Customer Id :"+save.getId());
		return customerRequest;
	}

	@Override
	public List<CustomerEntity> getAllCustomers() {
		List<CustomerEntity> list = customerRepository.findAll();
		return list;
	}

	@Override
	public CustomerEntity getCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
