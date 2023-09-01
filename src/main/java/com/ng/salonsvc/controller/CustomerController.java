package com.ng.salonsvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ng.salonsvc.customer.dao.CustomerRepository;
import com.ng.salonsvc.customer.dao.entity.CustomerEntity;
import com.ng.salonsvc.customer.model.CustomerRequest;
import com.ng.salonsvc.customer.service.CustomerService;

@RestController
@RequestMapping("/api/v1/cust")
public class CustomerController {
	
	@Autowired
	private CustomerService customerservice;
	// get, create , update ,delete
	
	@GetMapping("")
	public List<CustomerEntity> getAllCustomers() {
		List<CustomerEntity> list =customerservice.getAllCustomers();
		return list;
	}
	
	@PostMapping("")
	public String post(@RequestBody CustomerRequest customerRequest) {
		
		customerservice.saveCustomer(customerRequest);
		return customerRequest.toString();
				
	}

}