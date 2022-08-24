package br5;

import java.sql.Connection;
import java.util.List;

public interface dao<T> {
	
   //	DBconnection sqlConnect=new DBconnection();
   	public Connection sqlConnect = DBconnection.get_connection();
	
	//CREATE
		public T save(T item);
		
		
		
		
		//READ
	   // T getById(T item);
	   
	    
	    
	    
	    //update
	    public T update(int id, T item);
	    
	    
	    
	    //delete
	    public void delete(int id);
	    
}
