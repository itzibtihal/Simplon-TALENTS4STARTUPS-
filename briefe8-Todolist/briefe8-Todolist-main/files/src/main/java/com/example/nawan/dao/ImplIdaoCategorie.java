package com.example.nawan.dao;

import com.example.nawan.utils.Categorie;
import com.example.nawan.utils.Connexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ImplIdaoCategorie implements Idao<Categorie> {

    @Override
    public List<Categorie> findAll() {
        ObservableList<Categorie> categories = FXCollections.observableArrayList();
        String sql = "SELECT * from categories";
        try {
            //String sql = "SELECT * from categories";
            PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Categorie cat = new Categorie();
                cat.setId(rs.getInt("idcategorie"));
                cat.setNom(rs.getString("nom"));
                categories.add(cat);
                //System.out.print(rs.getInt("idcategorie"));
                //System.out.println(rs.getString( "nom"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);

        }
        return categories;
    }

    @Override
    public void add(Categorie cat) {
        try {

            String sql = "INSERT INTO categories (nom)VALUES(?)";
            PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
            st.setString(1,cat.getNom());
            System.out.println("Nouvelle categorie : " +cat.getNom());
            Integer rs =  st.executeUpdate();
            if(rs==1)
           // affiche();
            System.out.println("Ajout effectue avec succes ! ");
            else System.out.println("Ajout non effectue");
          //  affiche();
        } catch (SQLException ex) {
            System.out.println("INSERT : " + ex);
        }
    }

    @Override
    public void update(Categorie cat) {
        String sql = "UPDATE categories SET nom = ? where idcategorie ="+cat.getId();
        try {

            PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
            st.setString(1, cat.getNom());
            //st.setInt(2, cat.getId());
            st.executeUpdate();
            //System.out.println(st.executeUpdate());
            int rowupdate = st.executeUpdate();
            if(rowupdate==1)
                System.out.println("Modification de la categorie ayant l'Id "+cat.getId());
            else
                System.out.println("Echec de modification de la categorie ayant l'Id "+cat.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Update : " + ex);
        }
    }

    @Override
    public void delete(Categorie cat) {
        System.out.println("Avant la requete");
        String sql = "DELETE FROM categories  where idcategorie = ?";
        try {
            System.out.println("A l'interieur de try");
            PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
            st.setInt(1,cat.getId());
            st.executeUpdate();
            System.out.println("Apres la requete");
            int rowsup = st.executeUpdate();
            if(rowsup ==1)
                System.out.println("Suppression de la categorie ayant l'Id "+cat.getId());
            else
                System.out.println("Echec de suprression de la categorie ayant l'Id "+cat.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("DELETE : " + ex);
        }
    }
}
