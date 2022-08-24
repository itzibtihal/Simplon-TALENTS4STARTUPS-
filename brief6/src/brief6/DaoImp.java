package brief6;

import java.sql.*;

public class DaoImp implements Dao {

	Connection connection = DBconnect.get_connection();

	@Override
	public Categories save(Categories item) {
		try {
			String query = "INSERT INTO categories(name) VALUES (?)";
			PreparedStatement ps = connection.prepareStatement(query);

			connection.setAutoCommit(false);
			ps.setString(1, item.getName());
			ps.execute();

			connection.commit();
			ps.close();
			connection.close();

			return item;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public Produits save(Produits item) {
		try {
			String query = "INSERT INTO produits(name,prix,categoriesid) VALUES (?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);

			connection.setAutoCommit(false);
			ps.setString(1, item.getName());
			ps.setString(2, item.getPrix());
			ps.setInt(3, item.getCategoriesid());
			ps.execute();

			connection.commit();
			ps.close();
			connection.close();

			return item;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public Categories getById(int id) {
		Categories item = null;
		try {
			String query = "SELECT name FROM categories WHERE id=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				item = new Categories(rs.getString(1));

				item.setId(id);
			}

			ps.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public Produits getById1(int produitsid) {
		Produits item = null;
		try {
			String query = "SELECT name, prix,categoriesid FROM Produits WHERE produitsid=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, produitsid);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				item = new Produits(rs.getString(1), rs.getString(2), rs.getInt(3));

				item.setProduitsid(produitsid);
			}

			ps.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public Produits getById2(int id) {
		Produits item = null;
		try {
			String query = "SELECT name,prix,categoriesid FROM produits WHERE categoriesid=?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				item = new Produits(rs.getString(1), rs.getString(2), rs.getInt(3));

				item.setProduitsid(id);
			}

			ps.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return item;
	}

	@Override
	public void update(int id, Categories item) {
		String query = "update categories set name= ? WHERE id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, item.getName());
			ps.setInt(2, id);

			int result = ps.executeUpdate();
			if (result == 1) {
				System.out.println("Database updated successfully ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(int produitsid, Produits item) {
		String query = "update produits set name= ?, prix =?,categoriesid = ? WHERE produitsid=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, item.getName());
			ps.setString(2, item.getPrix());
			ps.setInt(3, item.getCategoriesid());
			ps.setInt(4, produitsid);

			int result = ps.executeUpdate();
			if (result == 1) {
				System.out.println("Database updated successfully ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String query = "DELETE FROM produits WHERE categoriesid=?";
		String query1 = "DELETE FROM categories WHERE id=?";
		
		PreparedStatement ps;
		PreparedStatement ps1;
		
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			
			ps1 = connection.prepareStatement(query1);
			ps1.setInt(1, id);
			
			int row = ps1.executeUpdate();
			int row1 = ps1.executeUpdate();
			
			// rows affected
			System.out.println("Nombre de lignes supprimes dans le tableau produits :" + row);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete1(int produitsid) {
		String query = "DELETE FROM produits WHERE produitsid=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, produitsid);
			int row = ps.executeUpdate();
			// rows affected
			System.out.println("Number of deleted rows :" + row);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
