package com.mycompany.biblioteca;

import com.mycompany.biblioteca.Model.Connexio;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class PrimaryController {
    Connection conecta;
    Connexio connexio = new Connexio();

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    public void initialize(URL url, ResourceBundle rb){
        conecta = connexio.connecta();
    }
}
