package com.qa.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomersDaoMysql implements Dao<Customers>{
	/**
	 * This class is responsible for creating, reading, updating and deleting entries in the customers table of the database
	 */
	
	private Connection connection;
	public CustomersDaoMysql() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/IMSDB", "root", "root"); 
	}
	public void create(Customers customer) {
		/**
		 * Creates a new row in the customers table
		 * The attributes of the parameter customer will be the individual the column entries for that row
		 */
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into customers(name) values('" + customer.getName() + "')");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	public ArrayList<Customers> readAll() {
		/**
		 * Reads all entries from the customers table
		 */
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
		/**
		 * updates a customer name in the customers database
		 * The attributes of the customer whose entry is to be changed are stored in the Customers class instance customer
		 */
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("update customers set name'" + customer.getName() + " ') where id = ' " + customer.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	public void delete(int id) {
		/**
		 * deletes a customer from the customers database
		 * Id specifies the id of the customer to be deleted
		 */
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete * from customers where id = ' " + id);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	

}
