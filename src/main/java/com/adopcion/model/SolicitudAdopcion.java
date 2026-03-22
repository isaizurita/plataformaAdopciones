package com.adopcion.model;

import java.time.LocalDate;

public class SolicitudAdopcion {
    private int id;
    private int idMascota;
    private String nombreSolicitante;
    private LocalDate fecha;

    public SolicitudAdopcion(int idMascota, String nombreSolicitante) {
        this.idMascota = idMascota;
        this.nombreSolicitante = nombreSolicitante;
        this.fecha = LocalDate.now();
    }

    public int getIdMascota() {
        return idMascota;
    }

    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}