package com.adopcion.dao;

import com.adopcion.database.ConexionDB;
import com.adopcion.model.Refugio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RefugioDAO {

    public void guardar(Refugio refugio) throws Exception {

        Connection conn = ConexionDB.getConexion();

        String sql =
        "INSERT INTO refugio(nombre,direccion,telefono) VALUES(?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, refugio.getNombre());
        ps.setString(2, refugio.getDireccion());
        ps.setString(3, refugio.getTelefono());

        ps.executeUpdate();
    }

    public List<Refugio> obtenerTodos() throws Exception {

        List<Refugio> lista = new ArrayList<>();

        Connection conn = ConexionDB.getConexion();

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM refugio");

        while(rs.next()){

            Refugio r = new Refugio();

            r.setId(rs.getInt("id_refugio"));
            r.setNombre(rs.getString("nombre"));
            r.setDireccion(rs.getString("direccion"));
            r.setTelefono(rs.getString("telefono"));

            lista.add(r);
        }

        return lista;
    }
}