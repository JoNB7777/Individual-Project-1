package com.qa.databases;

import java.util.ArrayList;

public interface Dao<T> {
	/**
	 * this class is a generic for creating the methods for creating an entry in a database, reading such an entry,
	 * updating an entry and deleting an entry
	 * The actual implementations of these methods are only written in the corresponding Daos for the given table
	 * @param t
	 */
	//C
	public void create(T t);
	//R
	public ArrayList<T>readAll();
	//U
	public void update(T t);
	//D
	public void delete(int id);

}