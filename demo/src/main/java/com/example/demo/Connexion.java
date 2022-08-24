package com.example.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connexion {


//	public static void main (String[]args) {
//		DBconnection sqlConnect=new DBconnection();
//		System.out.println(sqlConnect.get_connection());
//	     }
//



    public static Connection get_connection() {
        Connection connection = null;
        String driver="org.postgresql.Driver";
        String url="jdbc:postgresql://localhost:5434/db_briefe5";
        String username="postgres";
        String password="ibtihal@2003";

        try{
            Class.forName(driver);
            connection=DriverManager.getConnection(url, username, password);
            if(connection!=null) {
                System.out.println("connect");
            }else {
                System.out.println("not connected");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;

    }}

