package com.example.carrent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    protected void onAdministratorButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login_administrator.fxml"));

        Stage stage = new Stage();
        //Scene scene = new Scene(fxmlLoader.load(), 250, 370);
        //Scene scene = new Scene(fxmlLoader.load(), 620, 440);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("System");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onOperatorButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login_operator.fxml"));

        Stage stage = new Stage();
        //Scene scene = new Scene(fxmlLoader.load(), 250, 370);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("System");
        stage.setScene(scene);
        stage.show();
    }
}
