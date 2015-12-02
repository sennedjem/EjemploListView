package dueloDeLeyendas.dominio.duelo;

import dueloDeLeyendas.dominio.jugador.Jugador;
import dueloDeLeyendas.dominio.personaje.Personaje;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class ResultadoDuelo {
  private Jugador iniciador;
  
  private Jugador retado;
  
  private Personaje iniciadorPersonaje;
  
  private Personaje retadoPersonaje;
  
  private String posicion;
  
  private double poderAtaqueIniciador;
  
  private double poderAtaqueRetado;
  
  public ResultadoDuelo(final Jugador elQueInicio, final Jugador jRetado, final Personaje personaje, final Personaje personaje2, final String string, final double d, final double e) {
    this.iniciador = elQueInicio;
    this.retado = jRetado;
    this.iniciadorPersonaje = personaje;
    this.retadoPersonaje = personaje2;
    this.posicion = string;
    this.poderAtaqueIniciador = d;
    this.poderAtaqueRetado = e;
  }
  
  public boolean esEmpate() {
    return (this.poderAtaqueIniciador == this.poderAtaqueRetado);
  }
  
  public boolean participo(final Jugador jugador) {
    boolean _or = false;
    boolean _esIniciador = this.esIniciador(jugador);
    if (_esIniciador) {
      _or = true;
    } else {
      boolean _esRetado = this.esRetado(jugador);
      _or = _esRetado;
    }
    return _or;
  }
  
  public boolean esIniciador(final Jugador jugador) {
    String _nombreJugador = this.iniciador.getNombreJugador();
    String _nombreJugador_1 = jugador.getNombreJugador();
    return _nombreJugador.equals(_nombreJugador_1);
  }
  
  public boolean esRetado(final Jugador jugador) {
    String _nombreJugador = this.retado.getNombreJugador();
    String _nombreJugador_1 = jugador.getNombreJugador();
    return _nombreJugador.equals(_nombreJugador_1);
  }
  
  public boolean ganoIniciador() {
    return (this.poderAtaqueIniciador > this.poderAtaqueRetado);
  }
  
  public boolean ganoRetado() {
    return (this.poderAtaqueIniciador < this.poderAtaqueRetado);
  }
  
  @Pure
  public Jugador getIniciador() {
    return this.iniciador;
  }
  
  public void setIniciador(final Jugador iniciador) {
    this.iniciador = iniciador;
  }
  
  @Pure
  public Jugador getRetado() {
    return this.retado;
  }
  
  public void setRetado(final Jugador retado) {
    this.retado = retado;
  }
  
  @Pure
  public Personaje getIniciadorPersonaje() {
    return this.iniciadorPersonaje;
  }
  
  public void setIniciadorPersonaje(final Personaje iniciadorPersonaje) {
    this.iniciadorPersonaje = iniciadorPersonaje;
  }
  
  @Pure
  public Personaje getRetadoPersonaje() {
    return this.retadoPersonaje;
  }
  
  public void setRetadoPersonaje(final Personaje retadoPersonaje) {
    this.retadoPersonaje = retadoPersonaje;
  }
  
  @Pure
  public String getPosicion() {
    return this.posicion;
  }
  
  public void setPosicion(final String posicion) {
    this.posicion = posicion;
  }
  
  @Pure
  public double getPoderAtaqueIniciador() {
    return this.poderAtaqueIniciador;
  }
  
  public void setPoderAtaqueIniciador(final double poderAtaqueIniciador) {
    this.poderAtaqueIniciador = poderAtaqueIniciador;
  }
  
  @Pure
  public double getPoderAtaqueRetado() {
    return this.poderAtaqueRetado;
  }
  
  public void setPoderAtaqueRetado(final double poderAtaqueRetado) {
    this.poderAtaqueRetado = poderAtaqueRetado;
  }
}
