/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.Model;

/**
 *
 * @author Felipe
 */
public class Categoria {
    private int id;
    private String Nombre;

    public Categoria(int id, String Nombre) {
        this.id = id;
        this.Nombre = Nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }
    
    
}
