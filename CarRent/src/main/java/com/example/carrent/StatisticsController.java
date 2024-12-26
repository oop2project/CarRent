package com.example.carrent;

import database_layer.*;
import enums.CarBrand;
import enums.CarCategory;
import enums.CarClass;
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
    private ComboBox<CarCategory> carCategoryComboBox;

    @FXML
    private ComboBox<CarClass> carClassComboBox;

    @FXML
    private ComboBox<CarBrand> carBrandComboBox;



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




        carCategoryComboBox.getItems().setAll(CarCategory.values());
        carClassComboBox.getItems().setAll(CarClass.values());
        carBrandComboBox.getItems().setAll(CarBrand.values());

        carCategoryComboBox.getItems().add(null);
        carClassComboBox.getItems().add(null);
        carBrandComboBox.getItems().add(null);

        carCategoryComboBox.setPromptText("Choose a Category");
        carClassComboBox.setPromptText("Choose a Class");
        carBrandComboBox.setPromptText("Choose a Brand");

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

    public void onSearchCarButtonClick(){
        CarCategory selectedCategory = carCategoryComboBox.getValue();
        CarClass selectedClass = carClassComboBox.getValue();
        CarBrand selectedBrand = carBrandComboBox.getValue();


        Session session = HibernateSetup.getSessionFactory().openSession();
        try {
            StringBuilder sql = new StringBuilder("FROM CarEntity WHERE true ");
            //OperatorEntity selectedOperator = operatorComboBox.getValue();

            if(selectedCategory != null){
                sql.append("AND carCategory = :selectedCategory ");
            }
            if(selectedClass != null){
                sql.append("AND carClass = :selectedClass ");
            }
            if(selectedBrand != null){
                sql.append("AND carBrand = :selectedBrand ");
            }

            //Query<CarEntity> query1 = session.createQuery("FROM CarEntity WHERE carCategory = :selectedCategory" , CarEntity.class);
            Query<CarEntity> query1 = session.createQuery(sql.toString(), CarEntity.class);

            if(selectedCategory != null){
                query1.setParameter("selectedCategory", selectedCategory);
            }
            if(selectedClass != null){
                query1.setParameter("selectedClass", selectedClass);
            }
            if(selectedBrand != null){
                query1.setParameter("selectedBrand", selectedBrand);
            }
            //query1.setParameter("selectedCategory", selectedCategory);
            carList = query1.getResultList();


            System.out.println(carList);


            ObservableList<CarEntity> carsObservableList = FXCollections.observableArrayList(carList);
            carTableView.setItems(carsObservableList);

            carCategoryComboBox.setValue(null);
            carClassComboBox.setValue(null);
            carBrandComboBox.setValue(null);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
