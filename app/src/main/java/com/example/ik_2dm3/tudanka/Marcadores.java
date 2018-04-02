package com.example.ik_2dm3.tudanka;

public class Marcadores {


    private String nombre;
    private Double latitud;
    private Double longitud;
    private float marcador;


    public Marcadores() {
        super();
    }


    public Marcadores(String nombre, Double latitud, Double longitud, float marcador) {
        super();
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.marcador = marcador;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Double getLatitud() {
        return latitud;
    }


    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }


    public Double getLongitud() {
        return longitud;
    }


    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }


    public float getMarcador() {
        return marcador;
    }


    public void setMarcador(float marcador) {
        this.marcador = marcador;
    }



}
