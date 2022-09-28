<<<<<<< HEAD
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import connexion.Connexion;
import models.Tache;

public class implement_dao_task implements interface_dao<Tache> {

	Statement statement;

	public Connection connect = Connexion.getConnect();

	@Override 
	public boolean insert(Tache tache) {

		
		try {
			String sql = "insert into tache (titre,description,statut,deadline,nom_category) values (?,?,?,?,?) "; // ?
			PreparedStatement ps = connect.prepareStatement(sql);
			connect.setAutoCommit(false);
			ps.setString(1, tache.getTitre());
			ps.setString(2, tache.getDescription());
			ps.setString(3, tache.getStatut());
			ps.setString(4, tache.getDeadline());
			// ps.setObject(4, new Timestamp(tache.getDeadline().getTime()));
			ps.setString(5, tache.getNom_category());
			ps.execute();
			connect.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("problem in insertion ..." + e);
		}

		return false;
	}

	@Override
	public Set<Tache> select() {

		try { 

			statement = connect.createStatement();

			String sql = "select * from tache";
 
			ResultSet resultSet = statement.executeQuery(sql);

			Set<Tache> list_users = new HashSet<Tache>();

			while (resultSet.next()) {

				Tache tache = new Tache();

				tache.setTitre(resultSet.getString("titre"));
				tache.setDescription(resultSet.getString("description"));
				tache.setStatut(resultSet.getString("statut"));
				tache.setDeadline(resultSet.getString("deadline"));
				tache.setNom_category(resultSet.getString("nom_category"));
				list_users.add(tache);

			}

			return list_users;

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("problem in lister...");
		}

		System.out.println("error");
		return null;
	}

	@Override
	public boolean update(Tache tache) {
		try {
		PreparedStatement stmt = connect.prepareStatement("UPDATE tache SET description=?, statut=?, deadline=?, nom_category=? WHERE titre=?");
		stmt.setString(1, tache.getDescription());
		stmt.setString(2, tache.getStatut());
		stmt.setString(3, tache.getDeadline());
		stmt.setString(4, tache.getNom_category());
		stmt.setString(5, tache.getTitre());
		int i = stmt.executeUpdate();
		if (i == 1) {
			return true;
		}
		stmt.close();
		connect.close();
		
		}catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
			return false;
		}

	@Override
	public void delete(Tache tache) {
		try {
			String sql = "delete from tache where titre ='" + tache.getTitre() + "'";
			statement = connect.createStatement();
			statement.executeUpdate(sql);
			System.out.println("task deleted ...");

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("problem in deleting ...");

		} finally {
			System.out.println("error");
		}
	}


}
=======
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import connexion.Connexion;
import models.Tache;

public class implement_dao_task implements interface_dao<Tache> {

	Statement statement;

	public Connection connect = Connexion.getConnect();

	@Override 
	public boolean insert(Tache tache) {

		
		try {
			String sql = "insert into tache (titre,description,statut,deadline,nom_category) values (?,?,?,?,?) "; // ?
			PreparedStatement ps = connect.prepareStatement(sql);
			connect.setAutoCommit(false);
			ps.setString(1, tache.getTitre());
			ps.setString(2, tache.getDescription());
			ps.setString(3, tache.getStatut());
			ps.setString(4, tache.getDeadline());
			// ps.setObject(4, new Timestamp(tache.getDeadline().getTime()));
			ps.setString(5, tache.getNom_category());
			ps.execute();
			connect.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("problem in insertion ..." + e);
		}

		return false;
	}

	@Override
	public Set<Tache> select() {

		try { 

			statement = connect.createStatement();

			String sql = "select * from tache";
 
			ResultSet resultSet = statement.executeQuery(sql);

			Set<Tache> list_users = new HashSet<Tache>();

			while (resultSet.next()) {

				Tache tache = new Tache();

				tache.setTitre(resultSet.getString("titre"));
				tache.setDescription(resultSet.getString("description"));
				tache.setStatut(resultSet.getString("statut"));
				tache.setDeadline(resultSet.getString("deadline"));
				tache.setNom_category(resultSet.getString("nom_category"));
				list_users.add(tache);

			}

			return list_users;

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("problem in lister...");
		}

		System.out.println("error");
		return null;
	}

	@Override
	public boolean update(Tache tache) {
		try {
		PreparedStatement stmt = connect.prepareStatement("UPDATE tache SET description=?, statut=?, deadline=?, nom_category=? WHERE titre=?");
		stmt.setString(1, tache.getDescription());
		stmt.setString(2, tache.getStatut());
		stmt.setString(3, tache.getDeadline());
		stmt.setString(4, tache.getNom_category());
		stmt.setString(5, tache.getTitre());
		int i = stmt.executeUpdate();
		if (i == 1) {
			return true;
		}
		stmt.close();
		connect.close();
		
		}catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
			return false;
		}

	@Override
	public void delete(Tache tache) {
		try {
			String sql = "delete from tache where titre ='" + tache.getTitre() + "'";
			statement = connect.createStatement();
			statement.executeUpdate(sql);
			System.out.println("task deleted ...");

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("problem in deleting ...");

		} finally {
			System.out.println("error");
		}
	}


}
>>>>>>> fbf558e1d5a02f2cb34c27c924b1e54a4f44962a
