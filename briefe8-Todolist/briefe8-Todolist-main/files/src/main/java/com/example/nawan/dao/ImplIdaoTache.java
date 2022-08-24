package com.example.nawan.dao;

import com.example.nawan.utils.Categorie;
import com.example.nawan.utils.Connexion;
import com.example.nawan.utils.Tache;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ImplIdaoTache implements Idao<Tache> {

    public ObservableList<Tache> getTaches() {
        ObservableList<Tache> list = FXCollections.observableArrayList();
        try{
        String sql = "SELECT * from taches";
        PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Tache tache = new Tache();
            tache.setId(rs.getInt("id"));
            tache.setTitre(rs.getString("titre"));
            tache.setDescription(rs.getString("description"));
            tache.setStatut(rs.getString("statut"));
            tache.setDeadline(rs.getString("deadline"));
            tache.setIdCategorie(rs.getInt("idcategorie"));
            list.add(tache);
            System.out.println(list.add(tache));
        }
    } catch (SQLException ex) {
        System.out.println(ex);
    }
        return list;
    }
    @Override
    public List<Tache> findAll() {
        ObservableList<Tache> list = FXCollections.observableArrayList();
        //String sql = "SELECT * from taches";
        try {
            String sql = "SELECT * from taches";
            PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Tache tache = new Tache();
                tache.setId(rs.getInt("id"));
                tache.setTitre(rs.getString("titre"));
                tache.setDescription(rs.getString("description"));
                tache.setStatut(rs.getString("statut"));
                tache.setDeadline(rs.getString("deadline"));
                tache.setIdCategorie(rs.getInt("idcategorie"));
                list.add(tache);
            }
        } catch (SQLException ex) {
            System.out.println("ERREUR SQL : "+ex);
        }
        return list;
    }


    @Override
    public void add(Tache tache) {
        try {
            String sql = "INSERT INTO taches (titre, description, statut, deadline, idcategorie)VALUES(?,?,?,?,?)";
            PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
            st.setString(1, tache.getTitre());
            st.setString(2, tache.getDescription());
            st.setString(3,tache.getStatut());
            st.setString(4,tache.getDeadline());
            st.setInt(5,tache.getIdCategorie());
            //st.executeUpdate();
            int i = st.executeUpdate();
            if(i == 1)
                System.out.println("Nouvelle tache ajoutee avec succes !");
            else
                System.out.println("Echec de l'ajout de la nouvelle tache ");


        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ERREUR SQL : "+ex);
        }
    }

    @Override
    public void update(Tache t) {
        try {
            String sql = "UPDATE taches SET titre =?,description = ?,statut =?, deadline =?, " +
                    "idcategorie =? where id = "+t.getId();
            PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
            st.setString(1, t.getTitre());
            st.setString(2, t.getDescription());
            st.setString(3, t.getStatut());
            st.setString(4, t.getDeadline());
            st.setInt(5, t.getIdCategorie());
            //st.setInt(6, t.getId());
            st.executeUpdate();
            int rowupdate = st.executeUpdate();
            if(rowupdate==1)
                System.out.println("Modification de la tache ayant l'Id "+t.getId());
            else
                System.out.println("Echec de modification de la tache ayant l'Id "+t.getId());
        } catch (SQLException ex) {
            System.out.println("Update : " + ex);
        }


    }

    @Override
    public void delete(Tache t){
        try {
            String sql = "DELETE FROM taches where id = ?";
            PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
            st.setInt(1, t.getId());
            st.executeUpdate();
            int rowupdate = st.executeUpdate();
            if(rowupdate==1)
                System.out.println("Suppression de la tache ayant l'Id "+t.getId());
            else
                System.out.println("Echec de suppression de la tache ayant l'Id "+t.getId());
        } catch (SQLException ex) {
            System.out.println("DELETE : " + ex);
        }

    }

}
