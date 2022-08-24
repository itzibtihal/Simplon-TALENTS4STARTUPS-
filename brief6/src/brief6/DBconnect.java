package brief6;

import java.sql.*;

public class DBconnect {

	public static Connection get_connection() {
		Connection connection = null;
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/brief6";
		String username = "postgres";
		String password = "postgres";

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null) {
				System.out.println("connect");
			} else {
				System.out.println("not connected");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	}

}
