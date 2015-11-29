package uis.tp.grupo1.duelodeleyendas;

/**
 * Created by sebastian on 29/11/15.
 */
public class EstadisticasRep {

    private Integer jugadas;
    private Integer ganadas;
    private Integer kills;
    private Integer deads;
    private Integer assists;
    private String mejorUbicacion;
    private String puntaje;

    public EstadisticasRep() {
    }

    public Integer getGanadas() {
        return ganadas;
    }

    public void setGanadas(Integer ganadas) {
        this.ganadas = ganadas;
    }

    public Integer getJugadas() {
        return jugadas;
    }

    public void setJugadas(Integer jugadas) {
        this.jugadas = jugadas;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Integer getDeads() {
        return deads;
    }

    public void setDeads(Integer deads) {
        this.deads = deads;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public String getMejorUbicacion() {
        return mejorUbicacion;
    }

    public void setMejorUbicacion(String mejorUbicacion) {
        this.mejorUbicacion = mejorUbicacion;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }
}
