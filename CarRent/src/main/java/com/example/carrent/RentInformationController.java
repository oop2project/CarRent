package com.example.carrent;

import database_layer.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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

        } catch (Exception   e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
