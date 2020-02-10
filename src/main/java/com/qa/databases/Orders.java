package com.qa.databases;

public class Orders {
	
	private Long id;
	private Long customerId;
	private double price;    // need to rename cost to price in database
	
	public Orders(Long id, Long customer_id, double price) {
		this.setId(id);
		this.setCustomerId(customer_id);
		this.setPrice(price);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customer_id) {
		this.customerId = customer_id;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
