package com.qa.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemsDaoMysql implements Dao<Items> {
	/**
	 * This class is responsible for creating, reading, deleting and updating entries in the items table of the database
	 */

	private Connection connection;
	public ItemsDaoMysql() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/IMSDB", "root", "root"); 
	}
	public void create(Items item) {
		/**
		 * Creates a new row in the items table
		 * The attributes of the parameter item will be the individual the column entries for that row
		 */
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into items(name) values('" + item.getItemName() + "')");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	public ArrayList<Items> readAll() {
		/**
		 * Reads all entries from the items table
		 */
		ArrayList<Items> items = new ArrayList<Items>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from items");
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String itemName = resultSet.getString("name");
				double itemValue = resultSet.getDouble("item_value");
				Items item = new Items(id, itemName, itemValue);
				items.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return items;
	}

	public void update(Items item) {
		/**
		 * Updates the price of an item in the items table
		 * The details of the item that is to be updated are stored in the object item
		 */
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("update items set item_value'" + item.getItemValue() + " ') where id = ' " + item.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	public void delete(int id) {
		/**
		 * Deletes an order from the items table
		 * Parameter id specifies the id of the entry to be deleted
		 */
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete * from items where id = ' " + id);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

}
