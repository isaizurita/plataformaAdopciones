package com.adopcion.dao;

import com.adopcion.database.ConexionDB;
import com.adopcion.model.SolicitudAdopcion;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class SolicitudAdopcionDAO {

    public static void registrarSolicitud(SolicitudAdopcion solicitud) {
        String sql = "INSERT INTO solicitud_adopcion (id_adoptante, id_mascota) VALUES (?, ?)";

        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, 1); // adoptante dummy
            stmt.setInt(2, solicitud.getIdMascota());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}