package dao;
import java.sql.Connection;
import java.util.Set;

import db.DbConnection;

public interface Dao<T> {
	  Connection connection = DbConnection.getConnection();
	  Set<T> getAll();
	  T getOne(int id);
	  boolean insert(T item);
	  boolean update(int id, T item);
	  boolean delete(int id);  
	  
	  
}
