package com.qa.databases;

public class OrderItems {
	/**
	 * The purpose of this class is to store data about all the items in a given order in one of its class objects
	 * The class attributes are the id (id of a given item in an order), itemId (the Id that particular item has in the system),
	 * itemValue (the price of that item), quantity (the quantity of that item that has been ordered)
	 * and orderId ( the id the order this item is a part of has in the system)
	 */
	private Long id;
	private Long itemId;
	private double itemValue;
	private int quantity;
	private Long orderId;
	
	public OrderItems(Long id, Long itemId, double itemValue, int quantity, Long orderId) {
		this.setId(id);
		this.setItemId(itemId);
		this.setItemValue(itemValue);
		this.setQuantity(quantity);
		this.setOrderId(orderId);
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public double getItemValue() {
		return itemValue;
	}
	public void setItemValue(double itemValue) {
		this.itemValue = itemValue;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	

}
