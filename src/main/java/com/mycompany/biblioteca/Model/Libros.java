/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.Model;

/**
 *
 * @author Felipe
 */
public class Libros {
    private String ISBN;
    private String autor;
    private String Titulo;
    private String Editorial;
    private int id_categoria;
    private String Idioma;
    private boolean Prestado;

    public Libros(String ISBN, String autor, String Titulo, String Editorial, int id_categoria, String Idioma) {
        this.ISBN = ISBN;
        this.autor = autor;
        this.Titulo = Titulo;
        this.Editorial = Editorial;
        this.id_categoria = id_categoria;
        this.Idioma = Idioma;
        this.Prestado = false;
    }

    public Libros(String ISBN, String autor, String Titulo, String Editorial, int id_categoria, String Idioma, boolean Prestado) {
        this.ISBN = ISBN;
        this.autor = autor;
        this.Titulo = Titulo;
        this.Editorial = Editorial;
        this.id_categoria = id_categoria;
        this.Idioma = Idioma;
        this.Prestado = Prestado;
    }

    @Override
    public String toString() {
        return Titulo + " " + "(" + autor + ")";
    }



    public String getISBN() {
        return ISBN;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getEditorial() {
        return Editorial;
    }

    public String getIdioma() {
        return Idioma;
    }

    public boolean isPrestado() {
        return Prestado;
    }

    public String getAutor() {
        return autor;
    }

    public int getId_categoria() {
        return id_categoria;
    }
    
    
    
    
}
