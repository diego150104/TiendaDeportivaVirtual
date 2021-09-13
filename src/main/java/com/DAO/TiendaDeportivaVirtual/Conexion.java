package com.DAO.TiendaDeportivaVirtual;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    protected Connection Conexion;
    
    protected void Conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver Cargado");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoweb?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8", "root", "root");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
    }
    
    protected void Desconectar() {
        try {
            Conexion.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
