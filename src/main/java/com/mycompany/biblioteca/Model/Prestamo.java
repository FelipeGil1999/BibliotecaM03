/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.Model;

import java.time.LocalDate;

/**
 *
 * @author Felipe
 */
public class Prestamo {
    private LocalDate fecha_prestamo;
    private String dni;
    private String isbn;

    public Prestamo(LocalDate fecha_prestamo, String dni, String isbn) {
        this.fecha_prestamo = fecha_prestamo;
        this.dni = dni;
        this.isbn = isbn;
    }

    public LocalDate getFecha_prestamo() {
        return fecha_prestamo;
    }

    public String getDni() {
        return dni;
    }

    public String getIsbn() {
        return isbn;
    }




    
    
}
