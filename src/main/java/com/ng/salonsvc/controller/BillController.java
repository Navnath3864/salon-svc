package com.ng.salonsvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ng.salonsvc.bill.Request.BillRequest;
import com.ng.salonsvc.bill.dao.entity.BillEntity;

import com.ng.salonsvc.bill.service.BillingService;

import com.ng.salonsvc.customer.dao.entity.CustomerEntity;
import com.ng.salonsvc.product.dao.entity.ProductEntity;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bill")
public class BillController {
	@Autowired
	private BillingService billService;

	@GetMapping("")
	public List<BillEntity> getBill() {
		List<BillEntity> list = billService.getBill();
		return list;
	}

	@PostMapping("")
	public String Post(@RequestBody BillRequest billRequest) {
		billService.generateBillResponse(billRequest);
		return billRequest.toString();
	}

	@GetMapping("/getcustomerdetails/{id}")
	public CustomerEntity getCustomerById(@PathVariable int id) {
		CustomerEntity customer = billService.getCustomerById(id);
		return customer;
	}

	@GetMapping("/getproductdetails/{id}")
	public ProductEntity getProductById(@PathVariable int id) {
		ProductEntity product = billService.getProductById(id);
		return product;
	}
}
