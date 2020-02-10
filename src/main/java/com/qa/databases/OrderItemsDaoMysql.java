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

	public void create(OrderItems t) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

}
