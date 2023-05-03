/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.Model;

/**
 *
 * @author Felipe
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexio {

    private final String URL = "jdbc:mysql://localhost:3306/bd_biblioteca";//nom bd
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String USER = "root";
    private final String PASSWD = "";   

    public Connexio() {
    }

    
    
    public Connection connecta() {
        Connection connexio = null;
        try {
            //Carreguem el driver          
            Class.forName(DRIVER);
            connexio = DriverManager.getConnection(URL, USER, PASSWD);
            System.out.println("Connect!");
        } catch (SQLException | ClassNotFoundException throwables) {
            System.out.println("Error connect");
            // System.out.println(throwables.getLocalizedMessage());
        }
        return connexio;
    }
}
