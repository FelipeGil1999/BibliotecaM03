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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(LocalDate fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public LocalDate getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(LocalDate fecha_limite) {
        this.fecha_limite = fecha_limite;
    }
    
    


    
    
}
