package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
	    
	 public static Connection getConnection() {
		 
		 String DriverName = "org.postgresql.Driver"; 
		 String host = "jdbc:postgresql://localhost:5434/postgres"; 
		 String user = "postgres"; 
		 String pass = "ibtihal@2003"; 

		 try{ 
	         Class.forName(DriverName);
			 return DriverManager.getConnection(host, user, pass);

		 }catch(SQLException | ClassNotFoundException e){
			 e.printStackTrace();
	         System.out.println("Error Opening DB!");
			 
		 }
		 return null;
	 }
   
}
