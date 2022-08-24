package com.example.nawan;

import com.example.nawan.dao.ImplIdaoCategorie;
import com.example.nawan.dao.ImplIdaoTache;
import com.example.nawan.dao.ImpldaoUser;
import com.example.nawan.utils.Categorie;
import com.example.nawan.utils.Connexion;
import com.example.nawan.utils.Tache;
import com.example.nawan.utils.User;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class MainController {

    Stage stage;
    Tache tache = new Tache();
    Categorie cat ;
    User user;
    ImplIdaoCategorie implIdaoCategorie = new ImplIdaoCategorie();
    ImplIdaoTache implIdaoTache = new ImplIdaoTache();
    ImpldaoUser impldaoUser = new ImpldaoUser();
    @FXML
    public TableView tableTache;
    @FXML
    public TableColumn colIdTache;
    @FXML
    public TableColumn colTitre;
    @FXML
    public TableColumn colDescription;
    @FXML
    public TableColumn colStatut;
    @FXML
    public TableColumn colDeadline;
    @FXML
    public TableColumn colCategorie;
    @FXML
    public Button btnajouterT;
    @FXML
    public Button btnmodifierT;
    @FXML
    public Button btnsupprimerT;
    @FXML
    public Button btnlisterT;
    @FXML
    public Button btnquitterT;
    @FXML
    public TextField titre;
    @FXML
    public TextArea description;
    @FXML
    public TextField statut;
    @FXML
    public TextField deadline;
    @FXML
    public TextField categorie;
    @FXML
    public VBox btnjeminscris;
    @FXML
    public TextField txtfieldnom;
    @FXML
    public TextField txtfieldprenom;
    @FXML
    public TextField txtfieldnomutilisateur;
    @FXML
    public TextField txtfieldmotdepasse;
    @FXML
    public TextField id;
    @FXML
    public TextField idcat;
    @FXML
    public TextField nom;
    @FXML
    public TableView tableCategorie;
    @FXML
    public TableColumn colidcategorie;
    @FXML
    public TableColumn colnomcategorie;
    @FXML
    public Button btnajouter;
    @FXML
    public Button btnmodifier;
    @FXML
    public Button btnsupprimer;
    @FXML
    public Button btnlister;
    @FXML
    public Button btnquitter;
    @FXML
    public TextField txtfieldpseudo;
    @FXML
    public PasswordField txtfieldpassword;
    @FXML
    public Label lblvalidateconnexion;
    @FXML
    public Label lbldejainscrit;
    @FXML
    public Button btnsinscrire;
    @FXML
    public Button btnconnexion;
@FXML
    public void btnsinscrire(ActionEvent event) throws IOException {
        System.out.println("VOUS ETES SUR LA PAGE INSCRIPTION");
        Parent root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
        System.out.println(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("NOUVELLE INSCRIPTION !");
        stage.setScene(scene);
        stage.show();

    }
@FXML
    public void btnconnexion(ActionEvent event) {
        try {

            if (txtfieldpseudo.getText().equals("nawan") && txtfieldpassword.getText().equals("nawan")) {

                lblvalidateconnexion.setText("Connexion reussie !");
                System.out.println("Connexion reussie !");
                Parent root = FXMLLoader.load(getClass().getResource("taches.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setTitle("GESTIONNAIRE DE TACHES");
                stage.setScene(scene);
                stage.show();
                //System.out.println("Connexion a la base de donnee reussie !");
            } else {
                lblvalidateconnexion.setText("Connexion echouee!");
                System.out.println("Pseudo ou password incorrect");
            }
        } catch (Exception e) {
            System.out.println("Connexion a la base de donnee echouee !");
        }
    }
@FXML
    public void btnjeminscris(ActionEvent actionEvent) {
    System.out.println("Merci pour votre interet, operation de maintenance pour les incriptions !");

    }
@FXML
    public void btnmestaches(ActionEvent event) throws IOException {
        System.out.println("VOUS ETES SUR LE GESTIONNAIRE DES TACHES ");
        Parent root = FXMLLoader.load(getClass().getResource("gestion_taches.fxml"));
        System.out.println(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("GESTION DES TACHES ");
        stage.setScene(scene);
        stage.show();

    }
@FXML
    public void btnmescategories(ActionEvent event) throws IOException {
        System.out.println("VOUS ETES SUR LE GESTIONNAIRE DES CATEGORIES ");
        Parent root = FXMLLoader.load(getClass().getResource("gestion_categories.fxml"));
        System.out.println(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("GESTION DES CATEGORIES");
        stage.setScene(scene);
        stage.show();

    }
@FXML
    public void btnajouter(ActionEvent actionEvent) {
        cat = new Categorie();
        System.out.println("Avant ajout categorie");
        cat.setNom(nom.getText());
        implIdaoCategorie.add(cat);
        afficheCategories();
        System.out.println("Apres ajout categorie");
    }
@FXML
    public void btnmodifier(ActionEvent actionEvent) {
    int idCat =Integer.parseInt(idcat.getText());
    cat=new Categorie(idCat);
    cat.setId(idCat);
    implIdaoCategorie.update(cat);
    System.out.println("Bouton modifer categorie clique");
    afficheCategories();
    //System.out.println(idcat.getText());
    }
@FXML
    public void btnsupprimer(ActionEvent actionEvent) {
    int idCat =Integer.parseInt(idcat.getText());
    cat=new Categorie(idCat);
    cat.setId(idCat);
    implIdaoCategorie.delete(cat);
    System.out.println("Bouton supprimer categorie clique");
    afficheCategories();
    //System.out.println(idcat.getText());
    }
@FXML
    public void btnlister(ActionEvent actionEvent) {
        afficheCategories();

    }
@FXML
    public void btnquitter(ActionEvent actionEvent) {

    Platform.exit();
    }
@FXML
    public void btnajouterT(ActionEvent actionEvent) throws IllegalStateException {
    tache = new Tache();
    //tache.setId(Integer.parseInt(id.getText()));
    tache.setTitre(titre.getText());
    tache.setDescription(description.getText());
    tache.setStatut(statut.getText());
    tache.setDeadline(deadline.getText());
    tache.setIdCategorie(Integer.parseInt(categorie.getText()));
    implIdaoTache.add(tache);
    afficheTaches();
}

@FXML
    public void btnmodifierT(ActionEvent actionEvent) throws IllegalStateException{
        tache = new Tache();
        int idT =Integer.parseInt(id.getText());
        System.out.println("ID = "+idT);
        tache =new Tache(idT);
        tache.setTitre(titre.getText());
        tache.setDescription(description.getText());
        tache.setStatut(statut.getText());
        tache.setDeadline(deadline.getText());
        //tache.setId(Integer.parseInt(id.getText()));
        tache.setIdCategorie(Integer.parseInt(categorie.getText()));
        implIdaoTache.update(tache);
        afficheTaches();
        //System.out.println(idT);
    }
@FXML
    public void btnsupprimerT(ActionEvent actionEvent) throws IllegalStateException{
    int idT =Integer.parseInt(id.getText());
    tache =new Tache(idT);
    tache.setId(idT);
    //tache.setId(Integer.parseInt(id.getText()));
    implIdaoTache.delete(tache);
    afficheTaches();
    //System.out.println(id.getText());
    }
@FXML
    public void btnlisterT(ActionEvent actionEvent) {
    afficheTaches();

    }
@FXML
    public void btnquitterT(ActionEvent actionEvent) throws IllegalStateException {
    Platform.exit();
    }
    @FXML
    public void handleAction(MouseEvent mouseEvent) {
        //Categorie cdt = new Categorie();
        Categorie cdt = (Categorie) tableCategorie.getSelectionModel().getSelectedItem();
        idcat.setText(String.valueOf(cdt.getId()));
        nom.setText(cdt.getNom());
        afficheCategories();
        System.out.println("Selection de la ligne avec l'id "+cdt.getId());
    }
    @FXML
    public void handleActionT(MouseEvent mouseEvent) throws IllegalStateException {
        Tache taches = (Tache) tableTache.getSelectionModel().getSelectedItem();
        id.setText(String.valueOf(taches.getId()));
        titre.setText(taches.getTitre());
        description.setText(taches.getDescription());
        statut.setText(taches.getStatut());
        deadline.setText(taches.getDeadline());
        categorie.setText(String.valueOf(taches.getIdCategorie()));
        System.out.println("Selection de la ligne avec l'id "+taches.getId());
    }

    public void afficheCategories() {
        ObservableList<Categorie> list = (ObservableList<Categorie>) implIdaoCategorie.findAll();
        colidcategorie.setCellValueFactory(new PropertyValueFactory<Categorie, Integer>("idcategorie"));
        colnomcategorie.setCellValueFactory(new PropertyValueFactory<Categorie, String>("nom"));
        tableCategorie.setItems(list);
    }

    public void afficheTaches() {
        ObservableList<Tache> list = (ObservableList<Tache>) implIdaoTache.findAll();
        colIdTache.setCellValueFactory(new PropertyValueFactory<Tache, Integer>("id"));
        colTitre.setCellValueFactory(new PropertyValueFactory<Tache, String>("titre"));
        colDescription.setCellValueFactory(new PropertyValueFactory<Tache, String>("description"));
        colStatut.setCellValueFactory(new PropertyValueFactory<Tache, String>("statut"));
        colDeadline.setCellValueFactory(new PropertyValueFactory<Tache, String>("deadline"));
        colCategorie.setCellValueFactory(new PropertyValueFactory<Tache, String>("idcategorie"));
        tableTache.setItems(list);

    }
}