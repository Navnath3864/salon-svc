package com.ng.salonsvc.bill.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class BillEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "date")
	private String date;
	@Column(name = "customer_Id")
	private int customerId;
	@Column(name = "product_Id")
	private int productId;
	@Column(name = "discount_Amout")
	private double discountAmout;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "total")
	private double total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int i) {
		this.customerId = i;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productEntity) {
		this.productId = productEntity;
	}

	public double getDiscountAmout() {
		return discountAmout;
	}

	public void setDiscountAmout(double discountAmout) {
		this.discountAmout = discountAmout;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
