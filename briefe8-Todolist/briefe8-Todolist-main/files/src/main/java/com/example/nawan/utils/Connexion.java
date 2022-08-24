package com.example.nawan.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static Connection con;
    static String DRIVER_CLASS = "org.postgresql.Driver";
    static String url = "jdbc:postgresql://localhost/db_briefe88";
    static String user = "postgres";
    static String pass = "nawan";
    //private constructor
    static
    {

        try {
            Class.forName(DRIVER_CLASS);
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connexion etablie avec succes");
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {

        return con;
    }
}
