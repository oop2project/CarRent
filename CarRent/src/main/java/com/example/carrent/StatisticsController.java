package com.example.carrent;

import database_layer.CarEntity;
import database_layer.ClientEntity;
import database_layer.HibernateSetup;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StatisticsController {

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

    @FXML
    private TableColumn<CarEntity, Integer> numberOfRentsColumn;

//    @FXML
//    private Label tableText;


    @FXML
    private TableView<ClientEntity> clientTableView;

    private List<ClientEntity> clientList;

    @FXML
    private TableColumn<ClientEntity, Integer> clientIdColumn;

    @FXML
    private TableColumn<ClientEntity, String> nameColumn;

    @FXML
    private TableColumn<ClientEntity, String> phoneNumberColumn;

    @FXML
    private TableColumn<ClientEntity, String> addressColumn;

    @FXML
    private TableColumn<ClientEntity, Integer> clientNumberOfRentsColumn;


    @FXML
    public void initialize() {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("carBrand"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("carCategory"));
        classColumn.setCellValueFactory(new PropertyValueFactory<>("carClass"));
        numberOfRentsColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfRents"));


        clientIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        clientNumberOfRentsColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfRents"));

        Session session = HibernateSetup.getSessionFactory().openSession();
        try {

//            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
//            brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
//            categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
//            classColumn.setCellValueFactory(new PropertyValueFactory<>("class"));


            Query<CarEntity> query1 = session.createQuery("FROM CarEntity" , CarEntity.class);
            //query1.setParameter("status", RentStatus.RENTED);
            carList = query1.getResultList();


            System.out.println(carList);


            ObservableList<CarEntity> notRentedcarsObservableList = FXCollections.observableArrayList(carList);
            carTableView.setItems(notRentedcarsObservableList);
            //tableText.setText("Available Cars");





            Query<ClientEntity> query2 = session.createQuery("FROM ClientEntity" , ClientEntity.class);
            //query1.setParameter("status", RentStatus.RENTED);
            clientList = query2.getResultList();


            System.out.println(clientList);


            ObservableList<ClientEntity> clientsObservableList = FXCollections.observableArrayList(clientList);
            clientTableView.setItems(clientsObservableList);

        } catch (Exception   e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void onOrderClientsButtonClick(){
        Session session = HibernateSetup.getSessionFactory().openSession();
        try {

//            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
//            brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
//            categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
//            classColumn.setCellValueFactory(new PropertyValueFactory<>("class"));


            Query<ClientEntity> query2 = session.createQuery("FROM ClientEntity ORDER BY numberOfRents DESC" , ClientEntity.class);
            //query1.setParameter("status", RentStatus.RENTED);
            clientList = query2.getResultList();


            System.out.println(clientList);


            ObservableList<ClientEntity> clientsObservableList = FXCollections.observableArrayList(clientList);
            clientTableView.setItems(clientsObservableList);

        } catch (Exception   e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
