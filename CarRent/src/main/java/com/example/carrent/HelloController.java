package com.example.carrent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("The car is registered");
    }

    public void onReturnButtonClick(ActionEvent actionEvent) {
        welcomeText.setText("The car is returned");
    }
}