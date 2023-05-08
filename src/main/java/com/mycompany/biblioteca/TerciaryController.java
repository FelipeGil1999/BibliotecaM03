package com.mycompany.biblioteca;

import com.mycompany.biblioteca.Model.Connexio;
import com.mycompany.biblioteca.Model.Devolucion;
import com.mycompany.biblioteca.Model.Gestion;
import com.mycompany.biblioteca.Model.Libros;
import com.mycompany.biblioteca.Model.Prestamo;
import com.mycompany.biblioteca.Model.Socios;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import java.time.LocalDate;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TerciaryController {

    @FXML
    ComboBox lista;

    @FXML
    ComboBox lista1;

    @FXML
    ComboBox lista2;

    @FXML
    ComboBox lista3;

    @FXML
    ComboBox lista4;

    @FXML
    TextField dni;

    @FXML
    TextArea info;

    Gestion gestion = new Gestion();

    Connection conecta;
    Connexio connexio = new Connexio();

    ComboBox[] array = new ComboBox[5];

    int index = 0;
    String cadena = "";

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void DescubrirLista1() throws IOException {
        lista1.disableProperty().set(false);
    }

    @FXML
    private void DescubrirLista2() throws IOException {
        lista2.disableProperty().set(false);
    }

    @FXML
    private void DescubrirLista3() throws IOException {
        lista3.disableProperty().set(false);
    }

    @FXML
    private void DescubrirLista4() throws IOException {
        lista4.disableProperty().set(false);
    }

    public void initialize() throws SQLException {
        llista();

        array[0] = lista;
        array[1] = lista1;
        array[2] = lista2;
        array[3] = lista3;
        array[4] = lista4;

        lista1.disableProperty().set(true);
        lista2.disableProperty().set(true);
        lista3.disableProperty().set(true);
        lista4.disableProperty().set(true);

    }

    public void llista() throws SQLException {
        lista.setItems(gestion.llista_libros());
        lista1.setItems(gestion.llista_libros());
        lista2.setItems(gestion.llista_libros());
        lista3.setItems(gestion.llista_libros());
        lista4.setItems(gestion.llista_libros());
    }

    @FXML
    private void prestar() throws SQLException, IOException {

        for (int i = 0; i < array.length; i++) {
            Libros libroseleccionado = (Libros) array[i].getSelectionModel().getSelectedItem();
            if (libroseleccionado != null) {
                index++;
                cadena = cadena + libroseleccionado.getTitulo() + ",\n";
                Prestamo prestamo = new Prestamo(dni.getText(), libroseleccionado.getISBN());
                LocalDate fechaDevolucion = prestamo.getFecha_prestamo().plusDays(15);

                gestion.AñadirPrestamo(prestamo);
                Devolucion devolucion = new Devolucion(dni.getText(), libroseleccionado.getISBN(), fechaDevolucion);
                gestion.AñadirDevolucion(devolucion);

                gestion.prestar(libroseleccionado.getISBN());

                int j = 0;

                while (j < gestion.llista_libros().size()) {
                    if (libroseleccionado.getISBN().equals(gestion.llista_libros().get(j).getISBN())) {
                        gestion.llista_libros().get(j).setPrestado(true);
                        j = gestion.llista_libros().size() + 10;
                        //Actualizamos la lista de libros prestados

                    } else {
                        j++;
                    }
                }

            }

        }

        //Buscamos el nombre del socio
        Socios nombre_socio = new Socios("", "", "", "");

        int k = 0;
        while (k < gestion.llista_socios().size()) {
            if (gestion.llista_socios().get(k).getDNI().equals(dni.getText())) {
                nombre_socio = new Socios(gestion.llista_socios().get(k).getDNI(), gestion.llista_socios().get(k).getNombre(), gestion.llista_socios().get(k).getApellido(), gestion.llista_socios().get(k).getDireccion(), gestion.llista_socios().get(k).getSancion());
                k = gestion.llista_socios().size() + 1;
            } else {
                k++;
            }
        }
        if (index == 1) {
            info.setText("El libro: " + cadena + "\n" + "Fue prestado al socio: " + nombre_socio.getNombre() + " " + nombre_socio.getApellido());
        } else {
            if (index > 1) {
                info.setText("Los libros: " + cadena + "\n" + "Fueron prestados al socio: " + nombre_socio.getNombre() + " " + nombre_socio.getApellido());
            }
        }

        //cambiamos el estado del libro a prestado
    }
}
