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

@Observable
@Accessors
@SuppressWarnings("all")
public class DueloConBot {
  private SistemaDeDuelos sistema;
  
  private Random rnd = new Random(50);
  
  public DueloConBot(final SistemaDeDuelos sist) {
    this.sistema = sist;
  }
  
  public ResultadoDuelo realizarDueloBot(final String pos, final Jugador ret, final Personaje retPer, final Personaje personajeBot) {
    Jugador bot = new Jugador("mrX", this.sistema);
    bot.agregarEstadistica(personajeBot);
    Estadisticas estRetador = ret.getEstadisticas(retPer);
    final double poderAtaqueRetador = estRetador.poderDeAtaque();
    final int poderAtaqueBot = 10;
    return new ResultadoDuelo(ret, bot, retPer, personajeBot, pos, poderAtaqueRetador, poderAtaqueBot);
  }
  
  @Pure
  public SistemaDeDuelos getSistema() {
    return this.sistema;
  }
  
  public void setSistema(final SistemaDeDuelos sistema) {
    this.sistema = sistema;
  }
  
  @Pure
  public Random getRnd() {
    return this.rnd;
  }
  
  public void setRnd(final Random rnd) {
    this.rnd = rnd;
  }
}
