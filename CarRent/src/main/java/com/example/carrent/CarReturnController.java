package com.example.carrent;

import database_layer.*;
import enums.CarCategory;
import enums.CarClass;
import enums.RentStatus;
import enums.ReturnStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.RentPrice;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CarReturnController implements RentPrice {
    private List<RentedCarsEntity> rentedCarsList;

    private List<CarEntity> carList;

    @FXML
    private ComboBox<RentedCarsEntity> rentedCarsComboBox;

    @FXML
    private ComboBox<CarEntity> carComboBox;

    @FXML
    public TextField kilometersField;

    @FXML
    public TextField daysField;

    @FXML
    private ComboBox<ReturnStatus> returnStatusComboBox;

    @FXML
    private Label returnText;



    @FXML
    public void initialize() {
        returnStatusComboBox.getItems().setAll(ReturnStatus.values());
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
        String daysString = daysField.getText();
        int days = Integer.parseInt(daysString);
        String kilometersString = kilometersField.getText();
        int kilometers = Integer.parseInt(kilometersString);
        ReturnStatus selectedReturnStatus = returnStatusComboBox.getValue();


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
            returnText.setText("The car is returned! The rent price is: " + this.getRentPrice(days,kilometers, selectedReturnStatus,selectedCar));
            this.initialize();


        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public double getRentPrice(int days, int kilometers, ReturnStatus returnStatus, CarEntity carEntity) {
        double price = 0;
        price = carEntity.getPrice()*days + kilometers*0.2;
        if(returnStatus == ReturnStatus.PROBLEM){
            price = price + 300;
        }
        return price;
    }
}
