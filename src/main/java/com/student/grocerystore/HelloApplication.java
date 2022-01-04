package com.student.grocerystore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 560, 340);
        stage.setTitle("Grocery Store!");
        stage.setScene(scene);
        stage.show();

        // Connect to the database with JDBCPostgreSQLConnection
        Connection conn = JDBCPostgreSQLConnection.connect();
     //   Crud.createTable(conn,"Products");
       // Crud.insert_row(conn,"Products","Milk", 3, 10);
       // Crud.delete_row_by_name(conn,"Products", "Milk");
      //  Crud.read_data(conn,"Products");
      //  Crud.createTable_Sales(conn,"Sales");
        Crud.createTable_Users(conn,"Users");
       // Crud.createTable_ProductDiscount(conn,"Product Discount");
        Crud.insertRow_users(conn,2,"admin","admin","admin","admin");
       // Crud.insertRow_users(conn,2,"user","user","password","user");
       // Crud.createTable_Sales(conn,"Sales");
        //Crud.insertRow_Sales(conn,1,"77", 1,2,"card");
        //Crud.createTable_Products(conn,"Products");
       // Crud.insertRow_Products(conn,1,"Milk", 3, 10);
       // Crud.createTable_ProductDiscount(conn,"Product Discount");
       // Crud.insertRow_ProductDiscount(conn,1,10,"2","6",1);
    }



       // JDBCPostgreSQLConnection



    public static void main(String[] args) {
        launch();
    }
}