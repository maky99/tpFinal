package com.softmaky.examenturismo.Lugares;

import java.io.Serializable;

public class Lugar implements Serializable {
    private String nombre;
    private double latitud;
    private double longitud;
    private String descripcion;
    private String horario;
    private int foto;

    // Constructor
    public Lugar(String nombre, double latitud, double longitud, String descripcion, String horario, int foto) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
        this.horario = horario;
        this.foto = foto;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getHorario() {
        return horario;
    }

    public int getFoto() {
        return foto;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
