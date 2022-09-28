<<<<<<< HEAD
package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion { 
	private static String url = "jdbc:postgresql://localhost:5432/brief9";
	private static String user = "postgres";
	private static String password = "18014733"; 
	private static Connection  connect = null; 
	 
	public static Connection getConnect() { 
 
		try {
			
			if(connect==null || connect.isClosed())
							
            try 
			{ 
			  Class.forName("org.postgresql.Driver"); 
			  connect = DriverManager.getConnection(url,user,password);
			  System.out.println("connected to postgresql service ");
			 	return connect;  
			}  
			catch(Exception e){  
			  System.out.println(e); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return connect;
	
  }
}
=======
package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion { 
	private static String url = "jdbc:postgresql://localhost:5432/brief9";
	private static String user = "postgres";
	private static String password = "18014733"; 
	private static Connection  connect = null; 
	 
	public static Connection getConnect() { 
 
		try {
			
			if(connect==null || connect.isClosed())
							
            try 
			{ 
			  Class.forName("org.postgresql.Driver"); 
			  connect = DriverManager.getConnection(url,user,password);
			  System.out.println("connected to postgresql service ");
			 	return connect;  
			}  
			catch(Exception e){  
			  System.out.println(e); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return connect;
	
  }
}
>>>>>>> fbf558e1d5a02f2cb34c27c924b1e54a4f44962a
