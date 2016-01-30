package com.ejemplo.pruebafragments.model;

/**
 * Created by gcalero1984 on 12/18/15.
 */
public class Playa {

    private String nombre;
    private int fotoId;
    private float temperatura;

    public Playa(String unNombre, float unaTemperatura,int fotoId) {
        this.nombre = unNombre;
        this.temperatura = unaTemperatura;
        this.fotoId = fotoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }


    public int getFotoId() {
        return fotoId;
    }

    public void setFotoId(int fotoId) {
        this.fotoId = fotoId;
    }
}