package com.student.grocerystore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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

  /*  public Controller(Label welcomeText, TextField email, TextField password) {
        this.welcomeText = welcomeText;
        this.email = email;
        this.password = password;
    }*/


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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("store.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 950);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public void onLoginButtonClick(ActionEvent event) throws IOException {
        if (email.getText().equals("a") && password.getText().equals("a")) {
            System.out.println("Login Successful");
            LoginStatus status = LoginStatus.SUCCESS;
            // exit the fxml
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
        // load the fxml
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("store.fxml"));
        // create a scene
        Scene scene = new Scene(fxmlLoader.load(), 300, 550);
        // create a stage
        Stage stage = new Stage();
        // set the scene
        stage.setScene(scene);
        // set the stage title
        stage.setTitle("Hello!");
        // show the stage
        stage.show();

    }
}