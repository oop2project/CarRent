package com.example.carrent;

import database_layer.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    public void onRentACarButtonClick() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("rent_a_car.fxml"));

        Stage stage = new Stage();
        //Scene scene = new Scene(fxmlLoader.load(), 250, 370);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Rent a car");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onReturnButtonClick(ActionEvent actionEvent) throws IOException {
        welcomeText.setText("The car is returned");

        //EntityManager entityManager = null;
//        CarEntity car = entityManager.find(CarEntity.class, 1);
//        ClientEntity client = entityManager.find(ClientEntity.class, 1);
//        OperatorEntity operator = entityManager.find(OperatorEntity.class, 1);
        //RentedCarsEntity rentedCarsEntity = new RentedCarsEntity(car,client,operator);


        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction transaction = null;


        //EntityManagerFactory emf = null;
        //EntityManager entityManager = null;

        try {

            transaction = session.beginTransaction();


            CarEntity car = session.get(CarEntity.class, 1);
            ClientEntity client = session.get(ClientEntity.class, 1);
            OperatorEntity operator = session.get(OperatorEntity.class, 1);

            //OperatorEntity operatorEntity = new OperatorEntity(name, phoneNumber);
            RentedCarsEntity rentedCarsEntity = new RentedCarsEntity(car,client,operator);

            session.persist(rentedCarsEntity);


            transaction.commit();
            System.out.println("Operator saved successfully!");
            //resultText.setText("The car is registered!");
            //nameField.clear();
            //phoneNumberField.clear();


        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }



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