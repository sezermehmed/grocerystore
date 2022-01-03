module com.student.grocerystore {
    //requires javafx.controls;
   // requires javafx.fxml;
    //requires javafx.web;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
   // requires eu.hansolo.tilesfx;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;

    opens com.student.grocerystore to javafx.fxml;
    exports com.student.grocerystore;
}