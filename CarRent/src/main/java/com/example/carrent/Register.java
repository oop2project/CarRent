package com.example.carrent;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import models.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Register {
    private static final Logger logger = LogManager.getLogger(Register.class);

    public TextField priceField;

    public void onRegisterButtonClick(ActionEvent actionEvent) {
        String priceString = priceField.getText();
        double price = Double.parseDouble(priceString);
        Car car = new Car(price);
        
        logger.info(price);

    }
}
