package com.qa.databases;

public class OrderItems {
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
