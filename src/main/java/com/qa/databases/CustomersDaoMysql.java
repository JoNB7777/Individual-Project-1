package com.qa.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomersDaoMysql implements Dao<Customers>{
	
	private Connection connection;
	public CustomersDaoMysql() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/IMSDB", "root", "root"); 
	}
	public void create(Customers t) {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<Customers> readAll() {
		ArrayList<Customers> customers = new ArrayList<Customers>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from customers");
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				Customers customer = new Customers(id, name);
				customers.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return customers;
	}
	
	public void update(Customers t) {
		// TODO Auto-generated method stub
		
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
