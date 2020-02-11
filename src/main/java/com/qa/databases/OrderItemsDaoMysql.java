package com.qa.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderItemsDaoMysql implements Dao<OrderItems> {
	
	private Connection connection;
	public OrderItemsDaoMysql() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/IMSDB", "root", "root"); 
	}

	public void create(OrderItems orderItem) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into order_items(id) values('" + orderItem.getId() + "')");
			statement.executeUpdate("insert into order_items(quantity) values('" + orderItem.getQuantity() + "')");
			statement.executeUpdate("insert into order_items(item_value) values('" + orderItem.getItemValue() + "')");
			statement.executeUpdate("insert into order_items(item_id) values('" + orderItem.getItemId() + "')");
			statement.executeUpdate("insert into order_items(order_id) values('" + orderItem.getOrderId() + "')");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	public ArrayList<OrderItems> readAll() {
		ArrayList<OrderItems> orderItems = new ArrayList<OrderItems>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from order_items");
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				Long itemId = resultSet.getLong("item_id");
				double itemValue = resultSet.getDouble("item_value");
				int quantity = resultSet.getInt("quantity");
				Long orderId = resultSet.getLong("order_id");
				OrderItems orderItem = new OrderItems(id, itemId, itemValue, quantity, orderId);
				orderItems.add(orderItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return orderItems;
	}

	public void update(OrderItems t) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete * from order_items where id = 1");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

}
