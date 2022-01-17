package com.student.grocerystore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class Controller {
    @FXML
    private  Label welcomeText;
    @FXML
    private  TextField email;
    @FXML
    private  TextField password;
    @FXML
    private ComboBox<String> role;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        System.out.println("Hello button clicked!");
    }
    enum LoginStatus {
        SUCCESS,
        FAILURE
    }
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StoreAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 950);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public void onLoginButtonClick(ActionEvent event) throws IOException {
        Connection conn = JDBCPostgreSQLConnection.connect();
         String[] login = Crud.read_username(conn);
        if (email.getText().contains(login[0]) && password.getText().contains(login[2])) {
            System.out.println("Login Successful");
            LoginStatus status = LoginStatus.SUCCESS;
            Stage stage = (Stage) email.getScene().getWindow();
            stage.close();
            start();
        }
        else {
            System.out.println("Login Failed");
            LoginStatus status = LoginStatus.FAILURE;
        }
    }
    private void start() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StoreAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 550);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Hello!");
        stage.show();

    }
}