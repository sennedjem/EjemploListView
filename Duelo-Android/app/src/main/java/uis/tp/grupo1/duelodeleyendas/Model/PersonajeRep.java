package uis.tp.grupo1.duelodeleyendas.Model;

import java.util.List;

import uis.tp.grupo1.duelodeleyendas.EstadisticasRep;

/**
 * Created by sebastian on 29/11/15.
 */
public class PersonajeRep {

    private String nombre;
    private String path;
    private List<String> especialidades;
    private List<String> debilidades;
    private String posicionIdeal;
    private EstadisticasRep stat;

    public PersonajeRep(EstadisticasRep stat, String posicionIdeal, List<String> debilidades, List<String> especialidades, String path, String nombre) {
        this.stat = stat;
        this.posicionIdeal = posicionIdeal;
        this.debilidades = debilidades;
        this.especialidades = especialidades;
        this.path = path;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<String> especialidades) {
        this.especialidades = especialidades;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPosicionIdeal() {
        return posicionIdeal;
    }

    public void setPosicionIdeal(String posicionIdeal) {
        this.posicionIdeal = posicionIdeal;
    }

    public List<String> getDebilidades() {
        return debilidades;
    }

    public void setDebilidades(List<String> debilidades) {
        this.debilidades = debilidades;
    }

    public EstadisticasRep getStat() {
        return stat;
    }

    public void setStat(EstadisticasRep stat) {
        this.stat = stat;
    }
}
