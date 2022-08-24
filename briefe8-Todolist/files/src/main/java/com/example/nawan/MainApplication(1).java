package com.example.nawan;

import com.example.nawan.dao.ImplIdaoCategorie;
import com.example.nawan.utils.Categorie;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("loginForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 698, 435);
        stage.setTitle("AUTHENTIFICATION");
        String IconImagePath = "img.png";
        stage.getIcons().add(new Image(getClass().getResource(IconImagePath).toExternalForm()));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}