package com.example.carrent.operator;

import com.example.carrent.Application;
import database_layer.CarEntity;
import database_layer.ClientEntity;
import database_layer.HibernateSetup;
import database_layer.OperatorEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import models.CurrentUser;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class OperatorLoginController {
    private List<OperatorEntity> operatorList;
    @FXML
    private ComboBox<OperatorEntity> operatorComboBox;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageText;

    @FXML
    public void initialize() {
        Session session = HibernateSetup.getSessionFactory().openSession();
        try {
            //carList = session.createQuery("FROM CarEntity", CarEntity.class);

            Query<OperatorEntity> query3 = session.createQuery("FROM OperatorEntity ORDER BY name", OperatorEntity.class);
            operatorList = query3.getResultList();

            System.out.println(operatorList);

            ObservableList<OperatorEntity> operatorObservableList = FXCollections.observableArrayList(operatorList);

            //System.out.println(carObservableList);

            operatorComboBox.setItems(operatorObservableList);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    @FXML
    public void onLoginButtonClick() throws IOException {
        OperatorEntity selectedOperator = operatorComboBox.getValue();
        String password = passwordField.getText();

        if(password.equals("admin")){//        CurrentUser currentUser = new CurrentUser();
//        currentUser.setName(selectedOperator.getName());

            Stage currentStage = (Stage) operatorComboBox.getScene().getWindow();
            currentStage.close();

            CurrentUser.setName(selectedOperator.getName());

            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view-operator.fxml"));

            Stage stage = new Stage();
            //Scene scene = new Scene(fxmlLoader.load(), 250, 370);
            Scene scene = new Scene(fxmlLoader.load(), 620, 440);
            //Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("System" + " (" + CurrentUser.getName() + ")");
            stage.setScene(scene);
            stage.show();
        } else {
            System.out.println("Invalid password");
            messageText.setText("Invalid password");
        }

//        CurrentUser currentUser = new CurrentUser();
//        currentUser.setName(selectedOperator.getName());

//        Stage currentStage = (Stage) operatorComboBox.getScene().getWindow();
//        currentStage.close();
//
//        CurrentUser.setName(selectedOperator.getName());
//
//        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view-operator.fxml"));
//
//        Stage stage = new Stage();
//        //Scene scene = new Scene(fxmlLoader.load(), 250, 370);
//        Scene scene = new Scene(fxmlLoader.load(), 620, 440);
//        //Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("System" + " (" + CurrentUser.getName() + ")");
//        stage.setScene(scene);
//        stage.show();
    }
}
