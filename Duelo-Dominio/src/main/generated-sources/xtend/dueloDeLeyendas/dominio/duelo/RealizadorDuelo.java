package dueloDeLeyendas.dominio.duelo;

import dueloDeLeyendas.dominio.duelo.ResultadoDuelo;
import dueloDeLeyendas.dominio.estadisticas.Estadisticas;
import dueloDeLeyendas.dominio.jugador.Jugador;
import dueloDeLeyendas.dominio.personaje.Personaje;
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos;
import java.util.Random;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

/**
 * Calcula ganadores y perdedores a la hora de hacer un duelo
 */
@Observable
@Accessors
@SuppressWarnings("all")
public class RealizadorDuelo {
  private SistemaDeDuelos sis;
  
  private Random rnd = new Random(System.currentTimeMillis());
  
  private Integer numRandom = Integer.valueOf(this.rnd.nextInt(2));
  
  /**
   * Recibe a los jugadores, personajes y la posicion para el duelo. Despues de encontrar al ganador
   * actualiza las estadisticas de cada uno dependiendo el resultado
   */
  public ResultadoDuelo realizarDuelo(final String pos, final Jugador ret, final Jugador riv, final Personaje retPer, final Personaje rivPer) {
    Estadisticas estadisticasDeRetadorConSuPj = ret.getEstadisticas(retPer);
    Estadisticas estadisticasDeRivalConSuPj = riv.getEstadisticas(rivPer);
    double _poderDeAtaque = estadisticasDeRetadorConSuPj.poderDeAtaque();
    double poderAtaqueRetador = (_poderDeAtaque * (this.numRandom).intValue());
    double _poderDeAtaque_1 = estadisticasDeRivalConSuPj.poderDeAtaque();
    double poderAtaqueRival = (_poderDeAtaque_1 * (this.numRandom).intValue());
    return new ResultadoDuelo(ret, riv, retPer, rivPer, pos, poderAtaqueRetador, poderAtaqueRival);
  }
  
  @Pure
  public SistemaDeDuelos getSis() {
    return this.sis;
  }
  
  public void setSis(final SistemaDeDuelos sis) {
    this.sis = sis;
  }
  
  @Pure
  public Random getRnd() {
    return this.rnd;
  }
  
  public void setRnd(final Random rnd) {
    this.rnd = rnd;
  }
  
  @Pure
  public Integer getNumRandom() {
    return this.numRandom;
  }
  
  public void setNumRandom(final Integer numRandom) {
    this.numRandom = numRandom;
  }
}
