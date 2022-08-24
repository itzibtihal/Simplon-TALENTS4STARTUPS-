package com.example.demo;

import com.example.demo.Connexion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;


public class HelloApplication extends Application {
    Connection connection= Connexion.get_connection();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Inscription.fxml"));
        //fxmlLoader.setRoot(new AnchorPane());
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        /*Image icon = new Image(getClass().getResourceAsStream("icon1"));
        stage.getIcons().add(icon);*/
        stage.setTitle("GESTION DES INSCRIPTIONS");
        stage.show();
    }

    public static void main(String[] args) {

        launch();


    }
}