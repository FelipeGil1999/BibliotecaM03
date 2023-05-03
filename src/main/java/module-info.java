module com.mycompany.biblioteca {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql; 
    requires javafx.swing;
    requires java.desktop; 
    requires javafx.base;

    opens com.mycompany.biblioteca to javafx.fxml;
    exports com.mycompany.biblioteca;
}
