package com.example.carrent;

import database_layer.CarEntity;
import database_layer.ClientEntity;
import database_layer.HibernateSetup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientRegisterController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField addressField;
    @FXML
    public void onRegisterButtonClick(ActionEvent actionEvent) {
        String name = nameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String address = addressField.getText();

        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();


            ClientEntity clientEntity = new ClientEntity(name, phoneNumber, address);

            session.persist(clientEntity);


            transaction.commit();
            System.out.println("Client saved successfully!");
            //resultText.setText("The car is registered!");
            nameField.clear();
            phoneNumberField.clear();
            addressField.clear();


        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }


}
