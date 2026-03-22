package com.adopcion.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {

    private static final String URL =
            "jdbc:mysql://localhost:3306/adopcion_mascotas";

    private static final String USER = "root";
    private static final String PASS = "saBElo70";

    public static Connection getConexion() throws Exception {

        // Registrar el driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(URL, USER, PASS);
    }
}