package com.mycompany.biblioteca;

import com.mycompany.biblioteca.Model.Connexio;
import com.mycompany.biblioteca.Model.Gestion;
import com.mycompany.biblioteca.Model.Socios;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SecondaryController {
 @FXML
TextField nif;
  @FXML
TextField nombre;
   @FXML
TextField apellido;
    @FXML
TextField direccion;
 
  Gestion gestion = new Gestion();
  Connection conecta;
     Connexio connexio = new Connexio();
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
        @FXML

void eliminar_usuario() throws SQLException, IOException{
    
    gestion.dardealta(new Socios(nif.getText(), nombre.getText(), apellido.getText(), direccion.getText()));
}

    public void initialize(URL url, ResourceBundle rb) {
        conecta = connexio.connecta();
    }
}