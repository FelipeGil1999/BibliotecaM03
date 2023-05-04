package com.mycompany.biblioteca;

import com.mycompany.biblioteca.Model.Connexio;
import com.mycompany.biblioteca.Model.Gestion;
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

public class SecondaryController {

    @FXML
    TextField nif;
    @FXML
    TextField nombre;
    @FXML
    TextField apellido;
    @FXML
    TextField direccion;
    @FXML
    RadioButton alta;
    @FXML
    RadioButton baja;
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
    void agregar_usuario() throws SQLException, IOException {
        if (nif.getText() != "" && nombre.getText() != "" && apellido.getText() != "" && direccion.getText() != "") {

            boolean condi = gestion.dardealta(new Socios(nif.getText(), nombre.getText(), apellido.getText(), direccion.getText()));
            if (condi) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Socio agregado");
                alert.setHeaderText(null);
                alert.setContentText("El socio ha sido agregado correctamente.");

                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Ha habido un error al agregar el socio.");

                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Ha habido un error al agregar el socio.");

            alert.showAndWait();
        }
    }

    @FXML
    public void eliminar_usuario() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Eliminar socio");
        alert.setHeaderText(null);
        alert.setContentText("¿Seguro que desea eliminar al socio?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            
            boolean condi = gestion.dardebaja(nif.getText());
            System.out.println(condi);

            if (!condi) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Error");
                alert2.setHeaderText(null);
                alert2.setContentText("Ha habido un error al eliminar el socio.");
                alert2.showAndWait();
            }
        }
    }

    @FXML
    public void isselected() {
        if (baja.isSelected()) {
            nombre.disableProperty().set(true);
            apellido.disableProperty().set(true);
            direccion.disableProperty().set(true);
            asignar.disableProperty().set(true);
            eliminar.disableProperty().set(false);

        } else {
            nombre.disableProperty().set(false);
            apellido.disableProperty().set(false);
            direccion.disableProperty().set(false);
            asignar.disableProperty().set(false);
            eliminar.disableProperty().set(true);
        }
    }

}
