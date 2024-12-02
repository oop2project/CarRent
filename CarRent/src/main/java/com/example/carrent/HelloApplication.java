package com.example.carrent;

import database_layer.CarEntity;
import database_layer.HibernateSetup;
import enums.CarCategory;
import enums.CarClass;
import enums.ReturnStatus;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 440);
        stage.setTitle("Car administration");
        stage.setScene(scene);
        stage.show();



//        double price = 50;
//
//        Session session = HibernateSetup.getSessionFactory().openSession();
//        Transaction transaction = null;
//
//        try {
//            transaction = session.beginTransaction();
//
//            // Create and save an entity
//            CarEntity carEntity = new CarEntity(price, CarCategory.SUV, CarClass.FAMILY, ReturnStatus.NO_PROBLEM);
//            // Set fields as needed
//
//            // Use persist() instead of save()
//            session.persist(carEntity);
//
//            transaction.commit();
//            System.out.println("Employee saved successfully!");
//
//        } catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
    }

    public static void main(String[] args) {
        launch();
    }
}