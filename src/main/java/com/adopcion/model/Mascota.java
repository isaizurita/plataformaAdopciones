package com.adopcion.model;

public class Mascota {
    private int id;
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private String estado; // "disponible" o "adoptada"
    private int refugioId;

    public Mascota() {}

    public Mascota(String nombre, String especie, String raza, int edad, String estado, int refugioId) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.estado = estado;
        this.refugioId = refugioId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }
    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public int getRefugioId() { return refugioId; }
    public void setRefugioId(int refugioId) { this.refugioId = refugioId; }

    @Override
    public String toString() { return nombre; }
}