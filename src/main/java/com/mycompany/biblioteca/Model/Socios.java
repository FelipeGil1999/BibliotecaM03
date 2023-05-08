/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.Model;

/**
 *
 * @author Felipe
 */
public class Socios {
        private String DNI;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private double Sancion;

    public Socios(String DNI, String Nombre, String Apellido, String Direccion) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.Sancion = 0.0;
    }

    public Socios(String DNI, String Nombre, String Apellido, String Direccion, double Sancion) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.Sancion = Sancion;
    }


    

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public String getDireccion() {
        return Direccion;
    }

    public double getSancion() {
        return Sancion;
    }
    
    
    
}
