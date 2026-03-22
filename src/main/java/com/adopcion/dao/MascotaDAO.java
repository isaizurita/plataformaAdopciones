package com.adopcion.dao;
import com.adopcion.database.ConexionDB;
import com.adopcion.model.Mascota;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MascotaDAO {
    public void agregar(Mascota m) throws Exception {
        String sql = "INSERT INTO mascota (nombre, especie, raza, edad, estado, id_refugio) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getEspecie());
            ps.setString(3, m.getRaza());
            ps.setInt(4, m.getEdad());
            ps.setString(5, m.getEstado());
            ps.setInt(6, m.getRefugioId());
            ps.executeUpdate();
        }
    }
    public List<Mascota> obtenerTodas() throws Exception {
        List<Mascota> lista = new ArrayList<>();
        String sql = "SELECT * FROM mascota";
        try (Connection con = ConexionDB.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Mascota m = new Mascota();
                m.setId(rs.getInt("id_mascota"));
                m.setNombre(rs.getString("nombre"));
                m.setEspecie(rs.getString("especie"));
                m.setRaza(rs.getString("raza"));
                m.setEdad(rs.getInt("edad"));
                m.setEstado(rs.getString("estado"));
                m.setRefugioId(rs.getInt("id_refugio"));
                lista.add(m);
            }
        }
        return lista;
    }
    public void marcarAdoptada(int id) throws Exception {
        String sql = "UPDATE mascota SET estado = 'adoptada' WHERE id = ?";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}