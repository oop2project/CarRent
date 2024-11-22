package com.example.carrent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        welcomeText.setText("The car is registered");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 220, 340);
        stage.setTitle("Register a car");
        stage.setScene(scene);
        stage.show();
    }

    public void onReturnButtonClick(ActionEvent actionEvent) throws IOException {
        welcomeText.setText("The car is returned");
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
//
//        Stage stage = new Stage();
//        Scene scene = new Scene(fxmlLoader.load(), 420, 240);
//        stage.setTitle("Register a car");
//        stage.setScene(scene);
//        stage.show();

    }
}