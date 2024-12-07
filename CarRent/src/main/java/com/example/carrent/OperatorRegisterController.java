package com.example.carrent;

import database_layer.ClientEntity;
import database_layer.HibernateSetup;
import database_layer.OperatorEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OperatorRegisterController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    public void onRegisterButtonClick(ActionEvent actionEvent) {
        String name = nameField.getText();
        String phoneNumber = phoneNumberField.getText();

        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();


            OperatorEntity operatorEntity = new OperatorEntity(name, phoneNumber);

            session.persist(operatorEntity);


            transaction.commit();
            System.out.println("Operator saved successfully!");
            //resultText.setText("The car is registered!");
            nameField.clear();
            phoneNumberField.clear();


        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
