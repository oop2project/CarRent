package com.example.carrent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Scene scene = new Scene(fxmlLoader.load(), 620, 440);
        //stage.setTitle("Car administration");
        stage.setTitle("System login");
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