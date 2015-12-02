package dueloDeLeyendas.dominio.applicationModel;

import dueloDeLeyendas.dominio.estadisticas.Estadisticas;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class EstadisticasRep {
  private Integer jugadas;
  
  private Integer ganadas;
  
  private Integer kills;
  
  private Integer deads;
  
  private Integer assists;
  
  private String mejorUbicacion;
  
  private String puntaje;
  
  public EstadisticasRep(final Estadisticas estadistica) {
    Integer _cantDuelosIniciados = estadistica.getCantDuelosIniciados();
    this.jugadas = _cantDuelosIniciados;
    Integer _cantGanadosEIniciados = estadistica.getCantGanadosEIniciados();
    this.ganadas = _cantGanadosEIniciados;
    Integer _cantKills = estadistica.getCantKills();
    this.kills = _cantKills;
    Integer _cantDeads = estadistica.getCantDeads();
    this.deads = _cantDeads;
    Integer _assists = estadistica.getAssists();
    this.assists = _assists;
    String _mejorUbicacion = estadistica.getMejorUbicacion();
    this.mejorUbicacion = _mejorUbicacion;
    double _clasificacion = estadistica.getClasificacion();
    String _string = Double.valueOf(_clasificacion).toString();
    this.puntaje = _string;
  }
  
  @Pure
  public Integer getJugadas() {
    return this.jugadas;
  }
  
  public void setJugadas(final Integer jugadas) {
    this.jugadas = jugadas;
  }
  
  @Pure
  public Integer getGanadas() {
    return this.ganadas;
  }
  
  public void setGanadas(final Integer ganadas) {
    this.ganadas = ganadas;
  }
  
  @Pure
  public Integer getKills() {
    return this.kills;
  }
  
  public void setKills(final Integer kills) {
    this.kills = kills;
  }
  
  @Pure
  public Integer getDeads() {
    return this.deads;
  }
  
  public void setDeads(final Integer deads) {
    this.deads = deads;
  }
  
  @Pure
  public Integer getAssists() {
    return this.assists;
  }
  
  public void setAssists(final Integer assists) {
    this.assists = assists;
  }
  
  @Pure
  public String getMejorUbicacion() {
    return this.mejorUbicacion;
  }
  
  public void setMejorUbicacion(final String mejorUbicacion) {
    this.mejorUbicacion = mejorUbicacion;
  }
  
  @Pure
  public String getPuntaje() {
    return this.puntaje;
  }
  
  public void setPuntaje(final String puntaje) {
    this.puntaje = puntaje;
  }
}
