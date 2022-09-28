<<<<<<< HEAD
package dao;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

import connexion.Connexion;
import models.User;


public class implement_dao implements interface_dao<User> , interface_verification {

	Statement statement;

	public Connection connect = Connexion.getConnect();

	public boolean insert(User user) {

		try {
			String sql = "insert into utilisateur(username,name,password) values (?,?,?)";
			PreparedStatement ps = connect.prepareStatement(sql);
			connect.setAutoCommit(false);
			ps.setString(1, user.getUsername()); 
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassword()); 
			ps.execute();
			connect.commit();
			return true;

		} catch (Exception e) { 
			e.printStackTrace();
			System.err.println("problem in insertion ...");
		}

		return false;

	}

	public Set<User> select() {

		try {

			statement = connect.createStatement();

			String sql = "select * from utilisateur";

			ResultSet resultSet = statement.executeQuery(sql);

			Set<User> list_users = new HashSet<User>();

			while (resultSet.next()) {

				User user = new User();

				user.setUsername(resultSet.getString("username"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));

				list_users.add(user);

			}

			return list_users;

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("problem in lister...");
		}

		System.out.println("error");
		return null;
	}

	public boolean update(User user) {

		try {
			PreparedStatement stmt = connect.prepareStatement("UPDATE utilisateur SET name=?,  password=?  WHERE username=?");

			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getUsername());
			int i = stmt.executeUpdate();
			if (i == 1) {
				return true;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	public void delete(User user) {
		try {
			String sql = "delete from utilisateur where username='" + user.getUsername() + "'";
			statement = connect.createStatement();
			statement.executeUpdate(sql);
			System.out.println("User deleted ...");

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("problem in deleting ...");

		} finally {
			System.out.println("error");
		}

	}

	@Override
	public boolean login(String username, String password) {
		
	    try {
	    	
	        Statement stmt = connect.createStatement();
	         String req= "SELECT * FROM utilisateur where username='" + username +"' and password='" + password +"'";
	        ResultSet rs = stmt.executeQuery(req);
	          while ( rs.next() ) { 
	              return true;
	          }

	    } catch (SQLException ex) { 
	        ex.printStackTrace();
	    }

	return false;
	}
}




=======
package dao;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

import connexion.Connexion;
import models.User;


public class implement_dao implements interface_dao<User> , interface_verification {

	Statement statement;

	public Connection connect = Connexion.getConnect();

	public boolean insert(User user) {

		try {
			String sql = "insert into utilisateur(username,name,password) values (?,?,?)";
			PreparedStatement ps = connect.prepareStatement(sql);
			connect.setAutoCommit(false);
			ps.setString(1, user.getUsername()); 
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassword()); 
			ps.execute();
			connect.commit();
			return true;

		} catch (Exception e) { 
			e.printStackTrace();
			System.err.println("problem in insertion ...");
		}

		return false;

	}

	public Set<User> select() {

		try {

			statement = connect.createStatement();

			String sql = "select * from utilisateur";

			ResultSet resultSet = statement.executeQuery(sql);

			Set<User> list_users = new HashSet<User>();

			while (resultSet.next()) {

				User user = new User();

				user.setUsername(resultSet.getString("username"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));

				list_users.add(user);

			}

			return list_users;

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("problem in lister...");
		}

		System.out.println("error");
		return null;
	}

	public boolean update(User user) {

		try {
			PreparedStatement stmt = connect.prepareStatement("UPDATE utilisateur SET name=?,  password=?  WHERE username=?");

			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getUsername());
			int i = stmt.executeUpdate();
			if (i == 1) {
				return true;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	public void delete(User user) {
		try {
			String sql = "delete from utilisateur where username='" + user.getUsername() + "'";
			statement = connect.createStatement();
			statement.executeUpdate(sql);
			System.out.println("User deleted ...");

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("problem in deleting ...");

		} finally {
			System.out.println("error");
		}

	}

	@Override
	public boolean login(String username, String password) {
		
	    try {
	    	
	        Statement stmt = connect.createStatement();
	         String req= "SELECT * FROM utilisateur where username='" + username +"' and password='" + password +"'";
	        ResultSet rs = stmt.executeQuery(req);
	          while ( rs.next() ) { 
	              return true;
	          }

	    } catch (SQLException ex) { 
	        ex.printStackTrace();
	    }

	return false;
	}
}




>>>>>>> fbf558e1d5a02f2cb34c27c924b1e54a4f44962a
