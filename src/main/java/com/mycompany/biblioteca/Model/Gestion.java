/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.Model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Felipe
 */
public class Gestion {

    public Gestion() {
    }
    
    
    public boolean dardealta(Socios socio) throws SQLException, FileNotFoundException, IOException{
        boolean condicion = false;   
        Connection connection = new Connexio().connecta();
        String sql = "INSERT INTO socios VALUES (?,?,?,?,?)";
        PreparedStatement ordre = connection.prepareStatement(sql);
        try {
            ordre.setString(1, socio.getDNI());
            ordre.setString(2, socio.getNombre());
            ordre.setString(3, socio.getApellido());
            ordre.setString(4, socio.getDireccion());
            ordre.setDouble(5, socio.getSancion());


            ordre.executeUpdate();
            condicion = true;

        } catch (SQLException throwables) {
            System.out.println("Error:"+throwables.getMessage());
        }
        
        return condicion;
    }
    
    public boolean dardebaja(String dni){
        boolean condicion = false;
        String sql = "DELETE FROM socios WHERE DNI=?";
        // 0125678T
        
        System.out.println(dni);
        Connection connection = new Connexio().connecta();
        try {
            PreparedStatement ordre = connection.prepareStatement(sql);
            ordre.setString(1, dni);
            
            condicion = ordre.executeUpdate() > 0;
        } catch (SQLException throwables) {
            System.out.println("Error:"+throwables.getMessage());
        }
        return condicion;
    }

    
        public boolean IngresarLibro(Libros libro) throws SQLException, FileNotFoundException, IOException{
        boolean condicion = false;   
        Connection connection = new Connexio().connecta();
        String sql = "INSERT INTO socios VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ordre = connection.prepareStatement(sql);
        try {
            ordre.setString(1, libro.getISBN());
            ordre.setString(2, libro.getAutor());
            ordre.setString(3, libro.getTitulo());
            ordre.setString(4, libro.getEditorial());
            ordre.setInt(5, libro.getId_categoria());
            ordre.setString(6, libro.getIdioma());
            ordre.setBoolean(7, libro.isPrestado());


            ordre.executeUpdate();
            condicion = true;

        } catch (SQLException throwables) {
            System.out.println("Error:"+throwables.getMessage());
        }
        
        return condicion;
    }
        
        public boolean eliminarlibro(String isbn){
        boolean condicion = false;
        String sql = "DELETE FROM libros WHERE ISBN=?";
        Connection connection = new Connexio().connecta();
        try {
            PreparedStatement ordre = connection.prepareStatement(sql);
            ordre.setString(1, isbn);
            condicion = ordre.executeUpdate() > 0;
        } catch (SQLException throwables) {
            System.out.println("Error:"+throwables.getMessage());
        }
        return condicion;
    }
        
        public boolean Agregarcategoria(Categoria categoria) throws SQLException, FileNotFoundException, IOException{
        boolean condicion = false;   
        Connection connection = new Connexio().connecta();
        String sql = "INSERT INTO categoria VALUES (?,?)";
        PreparedStatement ordre = connection.prepareStatement(sql);
        try {
            ordre.setInt(1, categoria.getId());
            ordre.setString(2, categoria.getNombre());



            ordre.executeUpdate();
            condicion = true;

        } catch (SQLException throwables) {
            System.out.println("Error:"+throwables.getMessage());
        }
        
        return condicion;
    }
        
        public boolean eliminarcategoria(int id){
        boolean condicion = false;
        String sql = "DELETE FROM categoria WHERE ID_categoria=?";
        Connection connection = new Connexio().connecta();
        try {
            PreparedStatement ordre = connection.prepareStatement(sql);
            ordre.setInt(1, id);
            condicion = ordre.executeUpdate() > 0;
        } catch (SQLException throwables) {
            System.out.println("Error:"+throwables.getMessage());
        }
        return condicion;
    }
        
        public boolean AñadirPrestamo(Prestamo prestamo) throws SQLException, FileNotFoundException, IOException{
        boolean condicion = false;   
        Connection connection = new Connexio().connecta();
        String sql = "INSERT INTO prestamos VALUES (?,?,?)";
        PreparedStatement ordre = connection.prepareStatement(sql);
        try {
            ordre.setString(1, prestamo.getDni());
            ordre.setString(2, prestamo.getIsbn());
            ordre.setDate(3, java.sql.Date.valueOf(prestamo.getFecha_prestamo()));

            ordre.executeUpdate();
            condicion = true;

        } catch (SQLException throwables) {
            System.out.println("Error:"+throwables.getMessage());
        }
        
        return condicion;
    }
    }
    
    

