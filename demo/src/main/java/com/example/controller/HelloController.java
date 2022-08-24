package com.example.controller;

import com.example.demo.Candidat;
import com.example.demo.Connexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    Connection connection= Connexion.get_connection();
    public TableColumn colId;
    public TableColumn colNom;
    public TableColumn colPrenom;
    public TableColumn colEmail;
    public TableColumn colAdresse;
    public TableColumn colPays;
    public Button btneffacer;
    public Button btnlister;
    public Button btnsupprimer;
    public Button btnmodifier;
    public Button btnajouter;
    public TableView tableview;
    @FXML
    private TextField adresse;

    @FXML
    private TextField email;
    @FXML
    private TextField id;

    @FXML
    private TextField nom;

    @FXML
    private TextField pays;

    @FXML
    private TextField prenom;


    @FXML
    private AnchorPane root;
    @FXML
    void btnajouter() {
        try {

            String sql = "INSERT INTO candidat ( nom, prenom, email, adresse, pays)VALUES(?,?,?,?,?)";
            PreparedStatement st = Connexion.get_connection().prepareStatement(sql);

            st.setString(1, nom.getText());
            st.setString(2, prenom.getText());
            st.setString(3, email.getText());
            st.setString(4, adresse.getText());
            st.setString(5, pays.getText());
            st.executeUpdate();
            affiche();
            System.out.println("Ajout effectue avec succes !");
            affiche();
        } catch (SQLException ex) {
            System.out.println("INSERT : "+ex);
        }
    }

    @FXML
    void btnlister() {
        affiche();
        System.out.println("Bouton lister clicke");
    }

    @FXML
    void btnmodifier() {
        try {
            String sql = "UPDATE candidat SET nom =?,prenom = ?,email =? ,adresse =? ,pays =?  where idcandidat =?";
            PreparedStatement st = Connexion.get_connection().prepareStatement(sql);
            st.setString(1, nom.getText());
            st.setString(2, prenom.getText());
            st.setString(3, email.getText());
            st.setString(4, adresse.getText());
            st.setString(5, pays.getText());
            st.setInt(6, Integer.parseInt(id.getText()));
            st.executeUpdate();
            System.out.println("Modification realisee avec succes ");
            affiche();
        } catch (SQLException ex) {
            System.out.println("Update : "+ex);
        }

    }

    @FXML
    void btnsupprimer() {

        try {
            String sql = "DELETE FROM candidat  where idcandidat = ?";
            PreparedStatement st = Connexion.get_connection().prepareStatement(sql);
            st.setInt(1, Integer.parseInt(id.getText()));
            st.executeUpdate();
            System.out.println("Suppression effectuee avec succes !");
            affiche();
        } catch (SQLException ex) {
            System.out.println("DELETE : "+ex);
        }
    }

    public void btneffacer() {
        id.setText(null);
        nom.setText(null);
        prenom.setText(null);
        email.setText(null);
        adresse.setText(null);
        pays.setText(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public ObservableList<Candidat> getCandidat() {
        ObservableList<Candidat> list = FXCollections.observableArrayList();
        String sql = "SELECT * from candidat";
        try {

            PreparedStatement st = Connexion.get_connection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Candidat cdt = new Candidat();
                cdt.setId(rs.getInt("idcandidat"));
                cdt.setNom(rs.getString("nom"));
                cdt.setPrenom(rs.getString("prenom"));
                cdt.setEmail(rs.getString("email"));
                cdt.setAdresse(rs.getString("adresse"));
                cdt.setPays(rs.getString("pays"));
                list.add(cdt);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public void affiche() {
        ObservableList<Candidat> list = getCandidat();
        colId.setCellValueFactory(new PropertyValueFactory<Candidat, Integer>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<Candidat, String>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<Candidat, String>("prenom"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Candidat, String>("email"));
        colAdresse.setCellValueFactory(new PropertyValueFactory<Candidat, String>("adresse"));
        colPays.setCellValueFactory(new PropertyValueFactory<Candidat, String>("pays"));
        tableview.setItems(list);

    }

    public void tablehandleButtonAction(MouseEvent mouseEvent) {
        Candidat cdt = (Candidat) tableview.getSelectionModel().getSelectedItem();
        id.setText(String.valueOf(cdt.getId()));
        nom.setText(cdt.getNom());
        prenom.setText(cdt.getPrenom());
        email.setText(cdt.getEmail());
        adresse.setText(cdt.getAdresse());
        pays.setText(cdt.getPays());
    }



}