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
public class Devolucion {
    private String dni;
    private String isbn;
    private LocalDate fecha_devolucion;
    private LocalDate fecha_limite;

    public Devolucion(String dni, String isbn, LocalDate fecha_limite) {
        this.dni = dni;
        this.isbn = isbn;
        this.fecha_limite = fecha_limite;
        this.fecha_devolucion = null;
    }


    
    
}
