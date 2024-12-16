package com.example.carrent;

import database_layer.*;
import enums.RentStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CarReturnController {
    private List<RentedCarsEntity> rentedCarsList;

    private List<CarEntity> carList;

    @FXML
    private ComboBox<RentedCarsEntity> rentedCarsComboBox;

    @FXML
    private ComboBox<CarEntity> carComboBox;

    @FXML
    public void initialize() {
        Session session = HibernateSetup.getSessionFactory().openSession();
        try {
            //carList = session.createQuery("FROM CarEntity", CarEntity.class);

//            Query<RentedCarsEntity> query1 = session.createQuery("FROM RentedCarsEntity", RentedCarsEntity.class);
//            rentedCarsList = query1.getResultList();
//
//
//            System.out.println(rentedCarsList);
//
//
//            ObservableList<RentedCarsEntity> rentedcarsObservableList = FXCollections.observableArrayList(rentedCarsList);
//
//
//            //System.out.println(carObservableList);
//            rentedCarsComboBox.setItems(rentedcarsObservableList);


            Query<CarEntity> query1 = session.createQuery("FROM CarEntity WHERE rentStatus = RentStatus.RENTED" , CarEntity.class);
            //query1.setParameter("status", RentStatus.RENTED);
            carList = query1.getResultList();


            System.out.println(carList);


            ObservableList<CarEntity> rentedcarsObservableList = FXCollections.observableArrayList(carList);


            //System.out.println(carObservableList);
            carComboBox.setItems(rentedcarsObservableList);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void onReturnButtonClick(){
//        CarEntity selectedCar = carComboBox.getValue();
//
//
//        selectedCar.setRentStatus(RentStatus.NOT_RENTED);

        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction transaction = null;




        //EntityManagerFactory emf = null;
        //EntityManager entityManager = null;

        try {



            transaction = session.beginTransaction();


//            CarEntity car = session.get(CarEntity.class, 2);
//            ClientEntity client = session.get(ClientEntity.class, 2);
//            OperatorEntity operator = session.get(OperatorEntity.class, 2);

            CarEntity selectedCar = carComboBox.getValue();



            //OperatorEntity operatorEntity = new OperatorEntity(name, phoneNumber);

            //RentedCarsEntity rentedCarsEntity = new RentedCarsEntity(car,client,operator);
            //RentedCarsEntity rentedCarsEntity = new RentedCarsEntity(selectedCar,selectedClient,selectedOperator);

            //session.persist(rentedCarsEntity);

            selectedCar.setRentStatus(RentStatus.NOT_RENTED);
            session.update(selectedCar);


            transaction.commit();
            System.out.println("Transaction saved successfully!");
            //resultText.setText("The car is registered!");
            //nameField.clear();
            //phoneNumberField.clear();

            this.initialize();


        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
