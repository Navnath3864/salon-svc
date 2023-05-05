package com.ng.salonsvc.bill.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ng.salonsvc.bill.Request.BillRequest;
import com.ng.salonsvc.bill.Response.BillResponse;
import com.ng.salonsvc.bill.dao.BillRepository;
import com.ng.salonsvc.bill.dao.entity.BillEntity;
import com.ng.salonsvc.customer.dao.CustomerRepository;
import com.ng.salonsvc.customer.dao.entity.CustomerEntity;
import com.ng.salonsvc.product.dao.ProductRepository;
import com.ng.salonsvc.product.dao.entity.ProductEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class BillServiceImpl implements BillingService {
	@Autowired
	private BillRepository billRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<BillEntity> getBill() {
		List<BillEntity> list = billRepository.findAll();
		return list;
	}

	@Override
	public BillResponse generateBillResponse(BillRequest billRequest) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		BillResponse billResponse = new BillResponse();
		BillEntity billEntity = new BillEntity();
		billEntity.setDate(formatter.format(date));
		billEntity.setCustomerId(billRequest.getCustomerId());
		billEntity.setProductId(billRequest.getProductId());
		billEntity.setQuantity(billRequest.getQuantity());
		billEntity.setTotal(calculateTotal(billRequest.getQuantity(), billRequest.getProductId()));
		billEntity.setDiscountAmout(discountPrice(billRequest));
		BillEntity save = billRepository.save(billEntity);

		billResponse.setCustomerId(billEntity.getCustomerId());
		billResponse.setProductId(billEntity.getProductId());

		billResponse.setQuantity(billRequest.getQuantity());
		billResponse.setTotal(billEntity.getTotal());
		billEntity.setDate(billEntity.getDate());

		CustomerEntity customer = customerRepository.findById(billRequest.getCustomerId());
		ProductEntity product = productRepository.findById(billRequest.getProductId());
		billResponse.setCustomerName(customer.getfName() + " " + customer.getlName());
		billResponse.setCustomerEmail(customer.getEmail());
		billResponse.setProductName(product.getName());

		System.out.println("Bill Id :" + save.getId());
		System.out.println("customer id :" + billResponse.getCustomerId());
		System.out.println("customer Name :" + billResponse.getCustomerName());
		System.out.println("customer Email :" + billResponse.getCustomerEmail());
		
		System.out.println("product id :" + billResponse.getProductId());
		System.out.println("product Name :" + billResponse.getProductName());
		System.out.println("discount price : "+billEntity.getDiscountAmout());
		
		return billResponse;
	}

	@Override
	public CustomerEntity getCustomerById(int id) {
		return customerRepository.findById(id);
	}

	@Override
	public ProductEntity getProductById(int id) {
		return productRepository.getProductById(id);
	}

	public double calculateTotal(int quantity, int id) {
		ProductEntity prod = productRepository.findById(id);
		double totalPrice = (prod.getPrice() * quantity);
		return totalPrice;
	}
	
	public double discountPrice(BillRequest billRequest) 
	{
		double disCountPrice=calculateTotal(billRequest.getQuantity(), billRequest.getProductId())-(((calculateTotal(billRequest.getQuantity(), billRequest.getProductId())) * billRequest.getDiscountPercent() )/100);
		System.out.println("discount percetage: "+billRequest.getDiscountAmount());
		System.out.println("discount price in function : "+disCountPrice);
		return disCountPrice;
	}
}