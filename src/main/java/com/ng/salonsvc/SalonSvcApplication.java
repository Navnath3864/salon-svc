package com.ng.salonsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ng.salon.bill.service.BillServiceImpl;
import com.ng.salon.bill.service.BillingService;
import com.ng.salon.bill.model.Bill;
import com.ng.salon.product.model.Product;
import com.ng.salon.product.service.ProductService;
import com.ng.salon.product.service.ProductServiceImpl;
import com.ng.salonsvc.customer.model.CustomerRequest;
import com.ng.salonsvc.customer.service.CustomerService;
import com.ng.salonsvc.customer.service.CustomerServiceImpl;

@SpringBootApplication
public class SalonSvcApplication {
	//static CustomerService customerservice = null;
	//static CustomerService customerservice2 = null;
	static ProductService productservice = null;
	static BillingService billingservice = null;

	public static void main(String[] args) {
		SpringApplication.run(SalonSvcApplication.class, args);
		System.out.println("Spring Project Start");
//		customerservice = new CustomerServiceImpl();
//		customerservice2 = new CustomerServiceImpl();
		addCustomer();
		productservice= new ProductServiceImpl();
		addProduct();
		billingservice= new BillServiceImpl();
		generateBill();

	}

	private static void generateBill() {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setName("dove");
		product.setPrice(100);
		product.setDesc("Hair shampoo");

		CustomerRequest customer = new CustomerRequest();
		customer.setId(1);
		customer.setfName("Abc");
		customer.setlName("xyz");
		customer.setAddress("Kasarwadi");
		customer.setMobNumber("123456789");
		Bill bill= billingservice.generateBill(customer, product, 3);
		System.out.println(";Bill Id : " + bill.getId());
		System.out.println("Date : " + bill.getDate());
		System.out.println("Customer Name : " + bill.getCustomerName());
		System.out.println("product name: " + bill.getProductName());
		System.out.println("Mobile Number : " + bill.getMobileNumber());
		System.out.println("Quantity : " + bill.getQuantity());
		System.out.println("total :" + bill.getTotal());
	}

	private static void addProduct() {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setName("Dove");
		product.setPrice(100);
		product.setDesc("Hair shampoo");

		//Product productRes = productservice.getProductById(1);
		//System.out.println(productRes.getName());
	}

	private static void addCustomer() {
		// TODO Auto-generated method stub
		CustomerRequest customer = new CustomerRequest();
		customer.setId(1);
		customer.setfName("Navnath");
		customer.setMobNumber("12345");

//		Customer custResponse = customerservice.saveCustomer(customer);
//		customerservice2.saveCustomer(customer);
//		System.out.println(custResponse.getId());
//		System.out.println(custResponse.getfName());
//		System.out.println(custResponse.getMobNumber());
	}

}
