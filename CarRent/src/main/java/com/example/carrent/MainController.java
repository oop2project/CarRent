package com.example.carrent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        welcomeText.setText("The car is registered");
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("car_register.fxml"));

        Stage stage = new Stage();
        //Scene scene = new Scene(fxmlLoader.load(), 250, 370);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Register a car");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onReturnButtonClick(ActionEvent actionEvent) throws IOException {
        welcomeText.setText("The car is returned");
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("car_register.fxml"));
//
//        Stage stage = new Stage();
//        Scene scene = new Scene(fxmlLoader.load(), 420, 240);
//        stage.setTitle("Register a car");
//        stage.setScene(scene);
//        stage.show();

    }

    @FXML
    public void onClientRegisterButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("client_register.fxml"));

        Stage stage = new Stage();
        //Scene scene = new Scene(fxmlLoader.load(), 260, 370);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Register a client");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void onOperatorRegisterButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("operator_register.fxml"));

        Stage stage = new Stage();
        //Scene scene = new Scene(fxmlLoader.load(), 350, 370);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Register an operator");
        stage.setScene(scene);
        stage.show();

    }
}