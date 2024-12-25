package com.example.carrent;

import database_layer.*;
import enums.ReturnStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RentInformationController {
    @FXML
    private TableView<RentedCarsEntity> rentedCarsEntityTableView;

    private List<RentedCarsEntity> rentedCarsList;

    @FXML
    private TableColumn<RentedCarsEntity, Integer> idColumn;

    @FXML
    private TableColumn<RentedCarsEntity, CarEntity> carColumn;

    @FXML
    private TableColumn<RentedCarsEntity, ClientEntity> clientColumn;

    @FXML
    private TableColumn<RentedCarsEntity, OperatorEntity> operatorColumn;

    @FXML
    private ComboBox<OperatorEntity> operatorComboBox;

    private List<OperatorEntity> operatorList;


    @FXML
    private ComboBox<ClientEntity> clientComboBox;

    private List<ClientEntity> clientList;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        carColumn.setCellValueFactory(new PropertyValueFactory<>("car"));
        clientColumn.setCellValueFactory(new PropertyValueFactory<>("client"));
        operatorColumn.setCellValueFactory(new PropertyValueFactory<>("operator"));

        Session session = HibernateSetup.getSessionFactory().openSession();
        try {

//            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
//            brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
//            categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
//            classColumn.setCellValueFactory(new PropertyValueFactory<>("class"));


            Query<RentedCarsEntity> query1 = session.createQuery("FROM RentedCarsEntity" , RentedCarsEntity.class);
            //query1.setParameter("status", RentStatus.RENTED);
            rentedCarsList = query1.getResultList();


            System.out.println(rentedCarsList);


            ObservableList<RentedCarsEntity> notRentedcarsObservableList = FXCollections.observableArrayList(rentedCarsList);
            rentedCarsEntityTableView.setItems(notRentedcarsObservableList);
            //tableText.setText("Available Cars");



            Query<OperatorEntity> query2 = session.createQuery("FROM OperatorEntity" , OperatorEntity.class);
            //query1.setParameter("status", RentStatus.RENTED);
            operatorList = query2.getResultList();


            //System.out.println(operatorList);


            ObservableList<OperatorEntity> operatorObservableList = FXCollections.observableArrayList(operatorList);


            //System.out.println(carObservableList);
            operatorComboBox.setItems(operatorObservableList);
            operatorComboBox.setPromptText("Choose an operator");



            Query<ClientEntity> query3 = session.createQuery("FROM ClientEntity" , ClientEntity.class);
            //query1.setParameter("status", RentStatus.RENTED);
            clientList = query3.getResultList();


            //System.out.println(operatorList);


            ObservableList<ClientEntity> clientObservableList = FXCollections.observableArrayList(clientList);


            //System.out.println(carObservableList);
            clientComboBox.setItems(clientObservableList);
            clientComboBox.setPromptText("Choose a client");



        } catch (Exception   e) {
            e.printStackTrace();
        } finally {
            session.close();
        }





    }

    @FXML
    public void onCheckOperatorButtonClick() {
        Session session = HibernateSetup.getSessionFactory().openSession();
        try {

            OperatorEntity selectedOperator = operatorComboBox.getValue();

            Query<RentedCarsEntity> query1 = session.createQuery("FROM RentedCarsEntity WHERE operator = :selectedOperator" , RentedCarsEntity.class);
            query1.setParameter("selectedOperator", selectedOperator);
            rentedCarsList = query1.getResultList();


            System.out.println(rentedCarsList);


            ObservableList<RentedCarsEntity> notRentedcarsObservableList = FXCollections.observableArrayList(rentedCarsList);
            rentedCarsEntityTableView.setItems(notRentedcarsObservableList);



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    @FXML
    public void onCheckClientButtonClick() {
        Session session = HibernateSetup.getSessionFactory().openSession();
        try {

           ClientEntity selectedClient = clientComboBox.getValue();

            Query<RentedCarsEntity> query1 = session.createQuery("FROM RentedCarsEntity WHERE client = :selectedClient" , RentedCarsEntity.class);
            query1.setParameter("selectedClient", selectedClient);
            rentedCarsList = query1.getResultList();


            System.out.println(rentedCarsList);


            ObservableList<RentedCarsEntity> notRentedcarsObservableList = FXCollections.observableArrayList(rentedCarsList);
            rentedCarsEntityTableView.setItems(notRentedcarsObservableList);



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
