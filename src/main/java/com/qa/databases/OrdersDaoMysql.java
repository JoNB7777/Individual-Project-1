package com.qa.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrdersDaoMysql implements Dao<Orders> {

	private Connection connection;
	public OrdersDaoMysql() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/IMSDB", "root", "root"); 
	}
	
	public void create(Orders t) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Orders> readAll() {
		ArrayList<Orders> orders = new ArrayList<Orders>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders");
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				Long customerId = resultSet.getLong("customerId");
				int cost = resultSet.getInt("cost");
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
		// TODO Auto-generated method stub
		
	}

}
