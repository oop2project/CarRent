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

public class CarRentController {
    private List<CarEntity> carList;
    private List<ClientEntity> clientList;
    private List<OperatorEntity> operatorList;

    @FXML
    private ComboBox<CarEntity> carComboBox;

    @FXML
    private ComboBox<ClientEntity> clientComboBox;

    @FXML
    private ComboBox<OperatorEntity> operatorComboBox;

    @FXML
    public void initialize() {
        Session session = HibernateSetup.getSessionFactory().openSession();
        try {
            //carList = session.createQuery("FROM CarEntity", CarEntity.class);

            Query<CarEntity> query1 = session.createQuery("FROM CarEntity WHERE rentStatus = RentStatus.NOT_RENTED", CarEntity.class);
            carList = query1.getResultList();

            Query<ClientEntity> query2 = session.createQuery("FROM ClientEntity", ClientEntity.class);
            clientList = query2.getResultList();

            Query<OperatorEntity> query3 = session.createQuery("FROM OperatorEntity", OperatorEntity.class);
            operatorList = query3.getResultList();

            System.out.println(carList);
            System.out.println(clientList);
            System.out.println(operatorList);

            ObservableList<CarEntity> carObservableList = FXCollections.observableArrayList(carList);
            ObservableList<ClientEntity> clientObservableList = FXCollections.observableArrayList(clientList);
            ObservableList<OperatorEntity> operatorObservableList = FXCollections.observableArrayList(operatorList);

            //System.out.println(carObservableList);
            carComboBox.setItems(carObservableList);
            clientComboBox.setItems(clientObservableList);
            operatorComboBox.setItems(operatorObservableList);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void onRentButtonClick(){
        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction transaction = null;




        //EntityManagerFactory emf = null;
        //EntityManager entityManager = null;

        try {
            //carList = session.createQuery("FROM CarEntity", CarEntity.class);


//            Query<CarEntity> query1 = session.createQuery("FROM CarEntity", CarEntity.class);
//            carList = query1.getResultList();
//
//            Query<ClientEntity> query2 = session.createQuery("FROM ClientEntity", ClientEntity.class);
//            clientList = query2.getResultList();
//
//            Query<OperatorEntity> query3 = session.createQuery("FROM OperatorEntity", OperatorEntity.class);
//            operatorList = query3.getResultList();
//
//            System.out.println(carList);
//            System.out.println(clientList);
//            System.out.println(operatorList);
//
//            ObservableList<CarEntity> carObservableList = FXCollections.observableArrayList(carList);
//            ObservableList<ClientEntity> clientObservableList = FXCollections.observableArrayList(clientList);
//            ObservableList<OperatorEntity> operatorObservableList = FXCollections.observableArrayList(operatorList);
//
//            //System.out.println(carObservableList);
//            carComboBox.setItems(carObservableList);
//            clientComboBox.setItems(clientObservableList);
//            operatorComboBox.setItems(operatorObservableList);


            transaction = session.beginTransaction();


//            CarEntity car = session.get(CarEntity.class, 2);
//            ClientEntity client = session.get(ClientEntity.class, 2);
//            OperatorEntity operator = session.get(OperatorEntity.class, 2);

            CarEntity selectedCar = carComboBox.getValue();
            ClientEntity selectedClient = clientComboBox.getValue();
            OperatorEntity selectedOperator = operatorComboBox.getValue();


            //OperatorEntity operatorEntity = new OperatorEntity(name, phoneNumber);

            //RentedCarsEntity rentedCarsEntity = new RentedCarsEntity(car,client,operator);
            RentedCarsEntity rentedCarsEntity = new RentedCarsEntity(selectedCar,selectedClient,selectedOperator);

            selectedClient.updateRentNumber();
            selectedCar.updateRentNumber();

            session.persist(rentedCarsEntity);

            selectedCar.setRentStatus(RentStatus.RENTED);
            session.update(selectedCar);
            session.update(selectedClient);


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
