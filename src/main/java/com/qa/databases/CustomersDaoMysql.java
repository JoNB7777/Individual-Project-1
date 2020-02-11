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
	public void create(Customers customer) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into customers(name) values('" + customer.getName() + "')");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
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
	
	public void update(Customers customer) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("update customers(name) values('" + customer.getName() + " ') where id = 1");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	public void delete(int id) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete * from customers where id = 1");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	

}
