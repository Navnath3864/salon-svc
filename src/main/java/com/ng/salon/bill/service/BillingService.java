package com.ng.salon.bill.service;

import com.ng.salon.bill.model.Bill;
import com.ng.salon.product.model.Product;
import com.ng.salonsvc.customer.model.CustomerRequest;

public interface BillingService {
	Bill generateBill(CustomerRequest customer, Product product, int quantity);
}
