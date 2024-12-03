package com.example.carrent;

import database_layer.CarEntity;
import database_layer.HibernateSetup;
import enums.CarCategory;
import enums.CarClass;
import enums.ReturnStatus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Register {
    private static final Logger logger = LogManager.getLogger(Register.class);

    @FXML
    public TextField priceField;

    private SessionFactory sessionFactory;


    @FXML
    private ComboBox<CarCategory> carCategoryComboBox;

    @FXML
    private ComboBox<CarClass> carClassComboBox;

    @FXML
    private ComboBox<ReturnStatus> returnStatusComboBox;

    @FXML
    private Label resultText;

    @FXML
    public void initialize() {
        carCategoryComboBox.getItems().setAll(CarCategory.values());
        carClassComboBox.getItems().setAll(CarClass.values());
        returnStatusComboBox.getItems().setAll(ReturnStatus.values());
    }



//    protected void setUp() {
//        // A SessionFactory is set up once for an application!
//        final StandardServiceRegistry registry =
//                new StandardServiceRegistryBuilder()
//                        .build();
//        try {
//            sessionFactory =
//                    new MetadataSources(registry)
//                            .buildMetadata()
//                            .buildSessionFactory();
//        }
//        catch (Exception e) {
//            // The registry would be destroyed by the SessionFactory, but we
//            // had trouble building the SessionFactory so destroy it manually.
//            StandardServiceRegistryBuilder.destroy(registry);
//        }
//    }
    @FXML
    public void onRegisterButtonClick(ActionEvent actionEvent) {
        String priceString = priceField.getText();
        double price = Double.parseDouble(priceString);
        CarCategory selectedCategory = carCategoryComboBox.getValue();
        CarClass selectedClass = carClassComboBox.getValue();
        ReturnStatus selectedStatus = returnStatusComboBox.getValue();


        Car car = new Car(price);
        CarEntity carE = new CarEntity(price);

        //System.out.println(car);
        logger.info(car);
        logger.info(carE);


        //double price = 50;

        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Create and save an entity
            //CarEntity carEntity = new CarEntity(price, CarCategory.SUV, CarClass.FAMILY, ReturnStatus.NO_PROBLEM);
            CarEntity carEntity = new CarEntity(price, selectedCategory, selectedClass, selectedStatus);
            // Set fields as needed

            // Use persist() instead of save()
            session.persist(carEntity);

            transaction.commit();
            System.out.println("Car saved successfully!");
            resultText.setText("The car is registered!");

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

//        Session session = HibernateSetup.getSessionFactory().openSession();
//        Transaction transaction = null;
//
//        try {
//            transaction = session.beginTransaction();
//
//            // Create and save an entity
//            CarEntity carEntity = new CarEntity(price);
//              // Set fields as needed
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




//        Configuration cfg = new Configuration();
//        cfg.configure("hibernate.cfg.xml");  // Load configuration file
//        cfg.addAnnotatedClass(CarEntity.class);  // Add the entity class
//
//        try (Session session = cfg.buildSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//
//            // Create a new CarEntity object
//            CarEntity carEntity = new CarEntity(price);
//              // Set fields as needed
//
//            // Use persist() instead of save()
//            session.persist(carEntity);
//
//            // Commit the transaction
//            transaction.commit();
//            System.out.println("Car object saved successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        try(Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//
//            session.persist(carE);
//
//            session.getTransaction().commit();
//        }


//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")  // Loads configuration and mappings
//                .addAnnotatedClass(CarEntity.class)
//                .buildSessionFactory();
//
//        // Open a session to interact with the database
//        try (Session session = factory.openSession()) {
//            // Begin a transaction
//            session.beginTransaction();
//
//            // Create a new CarEntity object
//            CarEntity carEnt = new CarEntity(price);
//            //logger.info(carEntity);
//
//            // Save the object to the database
//            session.persist(carEnt);
//
//            // Commit the transaction
//            session.getTransaction().commit();
//            System.out.println("Car object saved successfully!");
//
//        } finally {
//            factory.close();  // Close the factory to free resources
//        }



//        try (Session session = cfg.buildSessionFactory().openSession()) {
//
//            Transaction tx = null;
//
//            try {
//                tx = session.beginTransaction();
//                // do some work
//                //Create a new CarEntity object
//                CarEntity carEntity = new CarEntity(price);
//                // Set fields as needed
//
//                // Use persist() instead of save()
//                session.persist(carEntity);
//                tx.commit();
//            } catch (Exception e) {
//                if (tx != null) tx.rollback();
//                e.printStackTrace();
//            } finally {
//                session.close();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }
}
