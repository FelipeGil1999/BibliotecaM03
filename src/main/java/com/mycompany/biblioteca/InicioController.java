package com.mycompany.biblioteca;

import com.mycompany.biblioteca.Model.Connexio;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class InicioController {
        @FXML
    TextField usuario;
            @FXML
    TextField contraseña;
    
    Connection conecta;
    Connexio connexio = new Connexio();

    @FXML
    private void IniciarSesion() throws IOException {
        if (usuario.getText().equalsIgnoreCase("Admin") && contraseña.getText().equalsIgnoreCase("admin")) {
            App.setRoot("primary");
        }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Usuario o contraseña incorrectos.");

                alert.showAndWait();
        }
        
        
    }
    
}
