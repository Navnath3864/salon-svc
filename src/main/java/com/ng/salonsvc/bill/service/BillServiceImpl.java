package com.ng.salonsvc.bill.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ng.salonsvc.bill.model.Bill;
import com.ng.salonsvc.customer.model.CustomerRequest;
import com.ng.salonsvc.product.model.Product;

public class BillServiceImpl implements BillingService {

	@Override
	public Bill generateBill(CustomerRequest customer, Product product, int quantity) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();  
		Bill bill = new Bill();
		bill.setId(6);
		bill.setDate(formatter.format(date));
		bill.setCustomerName(customer.getfName() +" "+customer.getlName());
		bill.setMobileNumber(customer.getMobNumber());
		bill.setProductName(product.getName());
		bill.setQuantity(quantity);
		bill.setTotal(product.getPrice()*quantity);
		return bill;
	}


}
