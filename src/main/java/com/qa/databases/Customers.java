package com.qa.databases;

public class Customers {
	/**
	 * Customer class is used to save customer data in its class instances
	 * Attributes are the id (the Customer Id) and the customer's name
	 */
	
	private Long id;
	private String name;
	
	public Customers(Long id, String name ) {
		this.setId(id);
		this.setName(name);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
