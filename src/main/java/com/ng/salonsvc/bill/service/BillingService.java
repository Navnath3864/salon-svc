package com.ng.salonsvc.bill.service;

import java.util.List;

import com.ng.salonsvc.bill.Request.BillRequest;
import com.ng.salonsvc.bill.Response.BillResponse;
import com.ng.salonsvc.bill.dao.entity.BillEntity;
import com.ng.salonsvc.customer.dao.entity.CustomerEntity;
import com.ng.salonsvc.product.dao.entity.ProductEntity;

public interface BillingService {

	BillResponse generateBillResponse(BillRequest billRequest);

	List<BillEntity> getBill();

	CustomerEntity getCustomerById(int id);

	ProductEntity getProductById(int id);
	// double calculateTotal (BillRequest billRequest);

}