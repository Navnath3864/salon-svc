package com.ng.salonsvc.bill.service;

import com.ng.salonsvc.bill.model.Bill;
import com.ng.salonsvc.customer.model.CustomerRequest;
import com.ng.salonsvc.product.model.Product;

public interface BillingService {
	Bill generateBill(CustomerRequest customer, Product product, int quantity);
}
