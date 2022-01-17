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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StoreAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1160, 640);
        stage.setTitle("Grocery Store!");
        stage.setScene(scene);
        stage.show();

        Connection conn = JDBCPostgreSQLConnection.connect();
        Crud.delete_row_by_name(conn,"Users", "hey");
    }

    public static void main(String[] args) {
        launch();
    }
}