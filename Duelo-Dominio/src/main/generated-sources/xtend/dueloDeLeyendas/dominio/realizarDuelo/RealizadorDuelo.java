package dueloDeLeyendas.dominio.realizarDuelo;

import dueloDeLeyendas.dominio.estadisticas.Estadisticas;
import dueloDeLeyendas.dominio.jugador.Jugador;
import dueloDeLeyendas.dominio.personaje.Personaje;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RealizadorDuelo {
  private String posicion;
  
  private Jugador retador;
  
  private Jugador rival;
  
  private Personaje retadorPersonaje;
  
  private Personaje rivalPersonaje;
  
  public void realizarDuelo(final String pos, final Jugador ret, final Jugador riv, final Personaje retPer, final Personaje rivPer) {
    Estadisticas estadisticasDeRetadorConSuPj = this.retador.getEstadisticas(this.retadorPersonaje);
    Estadisticas estadisticasDeRivalConSuPj = this.rival.getEstadisticas(this.rivalPersonaje);
    double poderAtaqueRetador = estadisticasDeRetadorConSuPj.poderDeAtaque();
    double poderAtaqueRival = estadisticasDeRivalConSuPj.poderDeAtaque();
    if ((poderAtaqueRetador > poderAtaqueRival)) {
      this.retador.ganeSumarAEstadisticas(this.retador, this.retadorPersonaje, this.posicion, poderAtaqueRetador);
      this.rival.perdiSumarAEstadisticas(this.retador, this.rivalPersonaje, this.posicion, poderAtaqueRetador);
    } else {
      this.rival.ganeSumarAEstadisticas(this.retador, this.rivalPersonaje, this.posicion, poderAtaqueRetador);
      this.retador.perdiSumarAEstadisticas(this.retador, this.retadorPersonaje, this.posicion, poderAtaqueRetador);
    }
    if ((poderAtaqueRetador == poderAtaqueRival)) {
      this.retador.empateSumarAEstadisticas(this.retador, this.retadorPersonaje, this.posicion, poderAtaqueRetador);
      this.rival.empateSumarAEstadisticas(this.retador, this.rivalPersonaje, this.posicion, poderAtaqueRetador);
    }
  }
  
  @Pure
  public String getPosicion() {
    return this.posicion;
  }
  
  public void setPosicion(final String posicion) {
    this.posicion = posicion;
  }
  
  @Pure
  public Jugador getRetador() {
    return this.retador;
  }
  
  public void setRetador(final Jugador retador) {
    this.retador = retador;
  }
  
  @Pure
  public Jugador getRival() {
    return this.rival;
  }
  
  public void setRival(final Jugador rival) {
    this.rival = rival;
  }
  
  @Pure
  public Personaje getRetadorPersonaje() {
    return this.retadorPersonaje;
  }
  
  public void setRetadorPersonaje(final Personaje retadorPersonaje) {
    this.retadorPersonaje = retadorPersonaje;
  }
  
  @Pure
  public Personaje getRivalPersonaje() {
    return this.rivalPersonaje;
  }
  
  public void setRivalPersonaje(final Personaje rivalPersonaje) {
    this.rivalPersonaje = rivalPersonaje;
  }
}
