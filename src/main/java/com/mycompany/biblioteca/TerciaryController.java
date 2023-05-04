package com.mycompany.biblioteca;

import com.mycompany.biblioteca.Model.Connexio;
import com.mycompany.biblioteca.Model.Gestion;
import com.mycompany.biblioteca.Model.Libros;
import com.mycompany.biblioteca.Model.Prestamo;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TerciaryController {

    @FXML
    ComboBox lista;
    
    @FXML
    TextField dialogo1;

    Gestion gestion = new Gestion();

    Connection conecta;
    Connexio connexio = new Connexio();

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    public void initialize() throws SQLException {
         System.out.println("hola");
        llista();
        
       

    }

    public void llista() throws SQLException {
        lista.setItems(gestion.llista_libros());
    }
    
    @FXML
    private void prestar() throws SQLException, IOException{
        Libros libroSeleccionado = (Libros) lista.getSelectionModel().getSelectedItem();
        gestion.AñadirPrestamo(new Prestamo(dialogo1.getText(), libroSeleccionado.getISBN()));
    }
}
