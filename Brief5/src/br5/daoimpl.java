package br5;

import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import br5.DBconnection;
import br5.dao;
import br5.Condidats;

public class daoimpl implements dao<Condidats>{
	Connection connection= DBconnection.get_connection();
	//Statement stmt=null;
	//ResultSet rs=null;
	//DBconnection sqlConnect=new DBconnection();
    //connection=sqlConnect.get_connection();

	public daoimpl(String nom, String prenom, String mail, String adress, String ville, String pays) {
		// TODO Auto-generated constructor stub
	}



	public daoimpl() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public Condidats save (Condidats item) {
		try {
			String query ="INSERT INTO list (nom,prenom,email,adress,ville,pays) VALUES (?,?, ?, ?, ?,?)";
			PreparedStatement rs= connection.prepareStatement(query);

			connection.setAutoCommit(false);
			rs.setString(1,item.getnom());
			rs.setString(2,item.getprenom());
			rs.setString(3,item.getmail());
			rs.setString(4,item.getadress());
			rs.setString(5,item.getville());
			rs.setString(6,item.getadress());
			rs.execute();
			
			
	        connection.commit();
			rs.close();
			connection.close();
			
			return item;

        }catch (Exception e) {
            e.printStackTrace();
               }
        return  item;
    }		



	@Override
	public Condidats update(int id, Condidats item) {
		
		try{    
		      String query = "UPDATE list SET nom=?,prenom=?, email =?, adress=?,ville=?,pays=? WHERE id=? ";
		      PreparedStatement stmt = connection.prepareStatement(query);
		   
		      stmt.setString(1,item.getnom());
		      stmt.setString(2,item.getprenom());
		      stmt.setString(3,item.getmail());
		      stmt.setString(4,item.getadress());
		      stmt.setString(5,item.getville());
		      stmt.setString(6,item.getpays());
		      stmt.setInt(7, id);
		      System.out.println("updated!");
		      stmt.execute();   
		      connection.close();
		      
		       item = this.find(item.getId());
		      
		      
	            
	        } catch (SQLException e) {
	                e.printStackTrace();
	        }
	    	 return item ;
		
             }	
	
	

	private Condidats find(int id) {
		
		return null;
	}


	@Override
	public void delete (int id) {
		
		try {
            
			 this.connection   
             .createStatement(
                 ResultSet.TYPE_SCROLL_INSENSITIVE, 
                 ResultSet.CONCUR_UPDATABLE
              ).executeUpdate(
                 "DELETE FROM list WHERE id = " + id
              );
			
			

        } catch (SQLException e) {
                e.printStackTrace();
        }
		
		
    
	}   
	
	 
	




  }