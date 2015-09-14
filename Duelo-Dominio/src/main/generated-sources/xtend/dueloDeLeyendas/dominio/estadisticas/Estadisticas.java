package dueloDeLeyendas.dominio.estadisticas;

import dueloDeLeyendas.dominio.jugador.Jugador;
import dueloDeLeyendas.dominio.personaje.Personaje;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Esta clase modela las estadísticas correspondientes a un jugador y un personaje
 */
@Accessors
@SuppressWarnings("all")
public class Estadisticas {
  private final Personaje personaje;
  
  private final Jugador jugador;
  
  private Integer cantDuelosIniciados;
  
  private Integer cantDuelosGanados;
  
  private Integer cantKills;
  
  private Integer cantDeads;
  
  private Integer assists;
  
  private Set<String> ubicacionesUsadas;
  
  private String mejorUbicacion;
  
  private double clasificacion;
  
  /**
   * Este constructor crea una instancia de la clase Estadisticas con los personajes y jugadores pasados
   * por parametro y todos los demas valores inicializados en 0, o lista vacia.
   */
  public Estadisticas(final Personaje pers, final Jugador jug) {
    this.jugador = jug;
    this.personaje = pers;
    this.cantDuelosIniciados = Integer.valueOf(0);
    this.cantDuelosGanados = Integer.valueOf(0);
    this.cantKills = Integer.valueOf(0);
    this.cantDeads = Integer.valueOf(0);
    this.assists = Integer.valueOf(0);
    HashSet<String> _hashSet = new HashSet<String>();
    this.ubicacionesUsadas = _hashSet;
    this.mejorUbicacion = "";
    this.clasificacion = 0;
  }
  
  /**
   * Este metodo aumenta en uno la cantidad de duelos iniciados.
   */
  public void sumarIniciado() {
    this.cantDuelosIniciados++;
  }
  
  /**
   * Este metodo aumenta en uno la cantidad de duelos ganados.
   */
  public void sumarGanado() {
    this.cantDuelosGanados++;
  }
  
  /**
   * Este metodo aumenta en uno la cantidad de kills.
   */
  public void sumarKill() {
    this.cantKills++;
  }
  
  /**
   * Este metodo aumenta en uno la cantidad de kills.
   */
  public void sumarDead() {
    this.cantDeads++;
  }
  
  /**
   * Este metodo aumenta en uno la cantidad de assists.
   */
  public void sumarAssist() {
    this.assists++;
  }
  
  /**
   * Este metodo agrega la ubicacion en que el personaje fue utilizado en un duelo
   */
  public void agregarUbicacion(final String ubicacion) {
    this.ubicacionesUsadas.add(ubicacion);
  }
  
  public void sumarEmpate(final String string) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void sumarPerdida(final String string) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void sumarVictoria(final String string) {
    this.sumarKill();
    this.sumarGanado();
    this.agregarUbicacion(string);
    this.setMejorUbicacion(string);
  }
  
  public void actualizarGaneRetador(final String posicion, final double clasificacion) {
    this.sumarIniciado();
    this.sumarGanado();
    this.agregarUbicacion(posicion);
    this.setMejorUbicacion(posicion);
    this.setClasificacion(clasificacion);
  }
  
  public void actualizarGane() {
    this.sumarGanado();
    this.sumarKill();
  }
  
  public void actualizarPerdi() {
    this.sumarDead();
  }
  
  public void actualizarPerdiRetador(final String posicion, final double clasificacion) {
    this.sumarIniciado();
    this.agregarUbicacion(posicion);
    this.setClasificacion(clasificacion);
  }
  
  public void actualizarEmpate() {
    this.sumarAssist();
  }
  
  public void actualizarEmpateRetador(final String posicion, final double clasificacion) {
    this.sumarIniciado();
    this.sumarAssist();
    this.agregarUbicacion(posicion);
    this.setClasificacion(clasificacion);
  }
  
  public double poderDeAtaque() {
    return ((this.clasificacion * (((this.cantKills).intValue() + ((this.assists).intValue() / 2)) - (this.cantDeads).intValue())) * (this.cantDuelosIniciados).intValue());
  }
  
  @Pure
  public Personaje getPersonaje() {
    return this.personaje;
  }
  
  @Pure
  public Jugador getJugador() {
    return this.jugador;
  }
  
  @Pure
  public Integer getCantDuelosIniciados() {
    return this.cantDuelosIniciados;
  }
  
  public void setCantDuelosIniciados(final Integer cantDuelosIniciados) {
    this.cantDuelosIniciados = cantDuelosIniciados;
  }
  
  @Pure
  public Integer getCantDuelosGanados() {
    return this.cantDuelosGanados;
  }
  
  public void setCantDuelosGanados(final Integer cantDuelosGanados) {
    this.cantDuelosGanados = cantDuelosGanados;
  }
  
  @Pure
  public Integer getCantKills() {
    return this.cantKills;
  }
  
  public void setCantKills(final Integer cantKills) {
    this.cantKills = cantKills;
  }
  
  @Pure
  public Integer getCantDeads() {
    return this.cantDeads;
  }
  
  public void setCantDeads(final Integer cantDeads) {
    this.cantDeads = cantDeads;
  }
  
  @Pure
  public Integer getAssists() {
    return this.assists;
  }
  
  public void setAssists(final Integer assists) {
    this.assists = assists;
  }
  
  @Pure
  public Set<String> getUbicacionesUsadas() {
    return this.ubicacionesUsadas;
  }
  
  public void setUbicacionesUsadas(final Set<String> ubicacionesUsadas) {
    this.ubicacionesUsadas = ubicacionesUsadas;
  }
  
  @Pure
  public String getMejorUbicacion() {
    return this.mejorUbicacion;
  }
  
  public void setMejorUbicacion(final String mejorUbicacion) {
    this.mejorUbicacion = mejorUbicacion;
  }
  
  @Pure
  public double getClasificacion() {
    return this.clasificacion;
  }
  
  public void setClasificacion(final double clasificacion) {
    this.clasificacion = clasificacion;
  }
}
