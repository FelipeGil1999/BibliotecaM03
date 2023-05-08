package com.mycompany.biblioteca;

import com.mycompany.biblioteca.Model.Connexio;
import com.mycompany.biblioteca.Model.Gestion;
import com.mycompany.biblioteca.Model.Libros;
import com.mycompany.biblioteca.Model.Socios;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class QuaternaryContraller {

    @FXML
    TextField isbn;
    @FXML
    TextField autor;
    @FXML
    TextField titulo;
    @FXML
    TextField editorial;
    @FXML
    TextField categoria;
    @FXML
    TextField idioma;
    @FXML
    RadioButton agregar;
    @FXML
    RadioButton eliminar_libro;
    @FXML
    Button asignar;
    @FXML
    Button eliminar;

    Gestion gestion = new Gestion();
    Connection conecta;
    Connexio connexio = new Connexio();

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    void agregar_libro() throws SQLException, IOException {
        if (isbn.getText() != "" && autor.getText() != "" && titulo.getText() != "" && editorial.getText() != "" && categoria.getText() != "" && idioma.getText() != "") {

            Libros libro = new Libros(isbn.getText(), autor.getText(), titulo.getText(), editorial.getText(), Integer.parseInt(categoria.getText()), idioma.getText());
            boolean condi = gestion.IngresarLibro(libro);
            System.out.println(condi);
            
            if (condi) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Libro agregado");
                alert.setHeaderText(null);
                alert.setContentText("El libro ha sido agregado correctamente.");

                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Ha habido un error al agregar el libro.");

                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Ha habido un error al agregar el libro.");

            alert.showAndWait();
        }
    }

    @FXML
    public void eliminar_libro() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Eliminar libro");
        alert.setHeaderText(null);
        alert.setContentText("¿Seguro que desea eliminar el libro?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            
            boolean condi = gestion.eliminarlibro(isbn.getText());
            System.out.println(condi);

            if (!condi) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Error");
                alert2.setHeaderText(null);
                alert2.setContentText("Ha habido un error al eliminar el libro.");
                alert2.showAndWait();
            }
        }
    }

    @FXML
    public void isselected() {
        if (eliminar_libro.isSelected()) {
            autor.disableProperty().set(true);
            titulo.disableProperty().set(true);
            editorial.disableProperty().set(true);
            categoria.disableProperty().set(true);
            idioma.disableProperty().set(true);
            asignar.disableProperty().set(true);
            eliminar.disableProperty().set(false);

        } else {
            autor.disableProperty().set(false);
            titulo.disableProperty().set(false);
            editorial.disableProperty().set(false);
            categoria.disableProperty().set(false);
            idioma.disableProperty().set(false);
            asignar.disableProperty().set(false);
            eliminar.disableProperty().set(true);
        }
    }

}
