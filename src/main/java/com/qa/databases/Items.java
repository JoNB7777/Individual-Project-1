package com.qa.databases;

public class Items {
	private Long id;
	private String itemName;
	private double itemValue;
	
	public Items(Long id, String itemName, double itemValue) {
		this.setId(id);
		this.setItemName(itemName);
		this.setItemValue(itemValue);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemValue() {
		return itemValue;
	}

	public void setItemValue(double itemValue) {
		this.itemValue = itemValue;
	}

}
