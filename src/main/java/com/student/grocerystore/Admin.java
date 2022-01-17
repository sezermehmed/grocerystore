package com.student.grocerystore;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Admin extends Application implements Initializable {
    @FXML
    private TextField userid, productid, productidPD, productname;
    @FXML
    private TextField productquantity, productprice;
    @FXML
    private TextField password, discountid, amount, startdate, enddate;
    @FXML
    private ComboBox role;
    @FXML
    private TextField name;
    @FXML
    private TextField email;


    static Connection conn = JDBCPostgreSQLConnection.connect();


    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Admin.class.getResource("StoreAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1050, 550);
        Stage stageAdmin = new Stage();
        stageAdmin.setScene(scene);
        stageAdmin.setTitle("Hello!");
        stageAdmin.show();

    }
  public static void main(String[] args) {
      launch();
  }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        role.setItems(FXCollections.observableArrayList("Admin", "Boss","Operator"));
    }

    // Create User button press
    public void handleCUButtonPress(ActionEvent actionEvent) {
        String userid = this.userid.getText();
        String password = this.password.getText();
        String role = this.role.getValue().toString();
        String name = this.name.getText();
        String email = this.email.getText();
        Crud.insertRow_users(conn, Integer.valueOf(userid), name, email,password, role);
        System.out.println("User created");
    }
    // Insert Product button press
    public void handleIPButtonPress(ActionEvent actionEvent) {
        Integer productid = Integer.valueOf(this.productid.getText());
        String productname = this.productname.getText();
        Integer productprice = Integer.valueOf(this.productprice.getText());
        Integer productquantity = Integer.valueOf(this.productquantity.getText());
        Crud.insertRow_Products(conn, Integer.valueOf(productid), Integer.valueOf(productquantity),productname, Integer.valueOf(productprice));
        System.out.println("Product Inserted");
    }

    // Product Discount button press
    public void handleIDButtonPress(ActionEvent actionEvent) throws SQLException {
        Integer discountid = Integer.valueOf(this.discountid.getText());
        String amount = this.amount.getText();
        String startdate = this.startdate.getText();
        String enddate = this.enddate.getText();
        Integer productidPD = Integer.valueOf(this.productidPD.getText());
            ArrayList<Integer> product = Crud.search_by_id(conn, "Products",productidPD);

            if(product.get(0) != null) {
                Crud.update_amount(conn, "Products", String.valueOf(product.get(1)),amount);
            }

        Crud.insertRow_ProductDiscount(conn, discountid,Integer.valueOf(amount),startdate, enddate, productidPD);
        System.out.println("Product Discount Inserted");
    }

    public void handleDUButtonPress(ActionEvent actionEvent) {
        String userid = this.userid.getText();
       // String password = this.password.getText();
       // String role = this.role.getValue().toString();
        String name = this.name.getText();
      //  String email = this.email.getText();
        Crud.delete_row_by_id(conn, "Users", Integer.parseInt(userid));
        System.out.println("User deleted");
    }

}