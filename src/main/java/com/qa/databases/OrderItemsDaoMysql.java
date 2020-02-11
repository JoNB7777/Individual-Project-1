package com.qa.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderItemsDaoMysql implements Dao<OrderItems> {
	/**
	 * This class is responsible for creating, reading, updating and deleting entries in the order_items table of the database
	 */
	
	private Connection connection;
	public OrderItemsDaoMysql() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/IMSDB", "root", "root"); 
	}

	public void create(OrderItems orderItem) {
		/**
		 * creates an entry in the order_item table
		 * parameter orderItem: is an instance of the OrderItem
		 * The individual orderItems variables are the entries for the individual columns of the new row in the table
		 */
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
		/**
		 * Reads all entries from the order_items table
		 */
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

	public void update(OrderItems orderItem) {
		/**
		 * Updates the quantity of an item in the order_items table
		 * Details of this item are stored in the attributes of the object orderItem
		 */
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("update order_items set quantity'" + orderItem.getQuantity() + " ') where id = ' " + orderItem.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	public void delete(int id) {
		/**
		 * Deletes an entry from the order_items table of the database
		 * id specifies the id the order_item that is to be deleted has in the system
		 */
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete * from order_items where id = ' " + id);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

}
