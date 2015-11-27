package uis.tp.grupo1.duelodeleyendas;

import java.util.ArrayList;
import java.util.List;

public class Personaje {


    private String nombre;
    private List<String> habilidades;
    private List<String> debilidades;
    private String mejorPos;
    private Estadisticas stats;

    public Personaje(String unid,String name, String pos){
        this.nombre = name;
        this.habilidades = new ArrayList<String>();
        this.debilidades = new ArrayList<String>();
        this.mejorPos = pos;
    }


    public String getMejorPos() {
        return mejorPos;
    }

    public void setMejorPos(String mejorPos) {
        this.mejorPos = mejorPos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public List<String> getDebilidades() {
        return debilidades;
    }

    public void setDebilidades(List<String> debilidades) {
        this.debilidades = debilidades;
    }

    public Estadisticas getStats() {
        return stats;
    }

    public void setStats(Estadisticas stats) {
        this.stats = stats;
    }

    public void agregarHabilidad(String s){
        habilidades.add(s);
    }

    public void agregarDebilidad(String s){
        debilidades.add(s);
    }

    public String toString(){
        return this.nombre;
    }

    private class Estadisticas {
    }
}
