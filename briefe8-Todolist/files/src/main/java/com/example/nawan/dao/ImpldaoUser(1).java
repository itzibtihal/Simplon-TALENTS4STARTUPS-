package com.example.nawan.dao;

import com.example.nawan.utils.Connexion;
import com.example.nawan.utils.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImpldaoUser implements IUserDao<User>{
    @Override
    public boolean addUser(User u){
        String sql = "INSERT INTO users (nom, prenom, nomutilisateur, motdepasse)VALUES(?,?,?,?)";
        try {
            PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
            st.setString(1, u.getNom());
            st.setString(2, u.getPrenom());
            st.setString(3, u.getNomUtilisateur());
            st.setString(4, u.getPassword());
            //st.executeUpdate();
            int i = st.executeUpdate();
            if (i == 1)
                System.out.println("Nouvel utilisateur ajoute avec succes !");
            else
                System.out.println("Echec de l'ajout du nouvel utilisateur ! ");

    } catch (
    SQLException ex) {
        ex.printStackTrace();
        System.out.println("ERREUR SQL : "+ex);
    }
        return false;
    }

    @Override
    public boolean signIn(User u) {
        ActionEvent event = null;
        Alert a = null;
        String sql = "SELECT * FROM users WHERE nomutilisateur =? AND motdepasse =?";

        try {

            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);

            ps.setString(1, u.getNomUtilisateur());
            ps.setString(2, u.getPassword());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Parent root = FXMLLoader.load(getClass().getResource("taches.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Connexion reussie !");
                a.show();

            } else {
                a.setAlertType(Alert.AlertType.ERROR);
                a.setContentText("Impossible de se connecter !");
                a.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

        @Override
    public boolean signUp(User u) {
        return false;
    }
}
