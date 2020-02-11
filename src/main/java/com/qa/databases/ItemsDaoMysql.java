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
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into items(name) values('" + item.getItemName() + "')");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	public ArrayList<Items> readAll() {
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

	public void update(Items t) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete * from items where id = 1");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

}
