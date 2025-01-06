package com.example.carrent;

import database_layer.CarEntity;
import database_layer.HibernateSetup;
import database_layer.RentedCarsEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class CarInformationController {
    private static final Logger logger = LogManager.getLogger(CarInformationController.class);
    @FXML
    private TableView<CarEntity> carTableView;

    private List<CarEntity> carList;


    @FXML
    private TableColumn<CarEntity, Integer> idColumn;

    @FXML
    private TableColumn<CarEntity, Integer> priceColumn;

    @FXML
    private TableColumn<CarEntity, String> brandColumn;

    @FXML
    private TableColumn<CarEntity, String> categoryColumn;

    @FXML
    private TableColumn<CarEntity, String> classColumn;

//    @FXML
//    private Label tableText;

    @FXML
    public void initialize() {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("carBrand"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("carCategory"));
        classColumn.setCellValueFactory(new PropertyValueFactory<>("carClass"));

        Session session = HibernateSetup.getSessionFactory().openSession();
        try {

//            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
//            brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
//            categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
//            classColumn.setCellValueFactory(new PropertyValueFactory<>("class"));


            Query<CarEntity> query1 = session.createQuery("FROM CarEntity WHERE rentStatus = RentStatus.NOT_RENTED" , CarEntity.class);
            //query1.setParameter("status", RentStatus.RENTED);
            carList = query1.getResultList();


            //System.out.println(carList);
            logger.info(carList);


            ObservableList<CarEntity> notRentedcarsObservableList = FXCollections.observableArrayList(carList);
            carTableView.setItems(notRentedcarsObservableList);
            //tableText.setText("Available Cars");

        } catch (Exception   e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @FXML
    public void onAvailableCarsButtonClick(ActionEvent actionEvent) {
//        Session session = HibernateSetup.getSessionFactory().openSession();
//        try {
//
////            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
////            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
////            brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
////            categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
////            classColumn.setCellValueFactory(new PropertyValueFactory<>("class"));
//
//
//            Query<CarEntity> query1 = session.createQuery("FROM CarEntity WHERE rentStatus = RentStatus.NOT_RENTED" , CarEntity.class);
//            //query1.setParameter("status", RentStatus.RENTED);
//            carList = query1.getResultList();
//
//
//            System.out.println(carList);
//
//
//            ObservableList<CarEntity> notRentedcarsObservableList = FXCollections.observableArrayList(carList);
//            carTableView.setItems(notRentedcarsObservableList);
//            tableText.setText("Available Cars");
//
//        } catch (Exception   e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
    }
}
