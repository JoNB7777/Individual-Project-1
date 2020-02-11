package com.qa.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrdersDaoMysql implements Dao<Orders> {
	/**
	 * This class is responsible for creating, reading, updating and deleting entries in the orders table of the database
	 */

	private Connection connection;
	public OrdersDaoMysql() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/IMSDB", "root", "root"); 
	}
	
	public void create(Orders order) {
		/**
		 * Creates a new row in the orders table
		 * The attributes of the parameter order will be the individual the column entries for that row
		 */
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into orders(name) values('" + order.getCustomerId() + "')");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	public ArrayList<Orders> readAll() {
		/**
		 * reads all entries from the orders table
		 */
		ArrayList<Orders> orders = new ArrayList<Orders>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders");
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				Long customerId = resultSet.getLong("customerId");
				double cost= resultSet.getDouble("cost");
				Orders order = new Orders(id, customerId, cost);
				orders.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void update(Orders t) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		/**
		 * deletes an entry from the orders table
		 * Parameter id specifies the id of the entry to be deleted
		 */
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete * from orders where id = 1");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

}
