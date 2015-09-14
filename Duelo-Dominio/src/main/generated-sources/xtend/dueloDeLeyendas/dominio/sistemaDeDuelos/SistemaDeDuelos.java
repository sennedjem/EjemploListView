package dueloDeLeyendas.dominio.sistemaDeDuelos;

import com.google.common.base.Objects;
import dueloDeLeyendas.dominio.estadisticas.Estadisticas;
import dueloDeLeyendas.dominio.jugador.Jugador;
import dueloDeLeyendas.dominio.personaje.Personaje;
import dueloDeLeyendas.dominio.realizarDuelo.RealizadorDuelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class SistemaDeDuelos {
  private List<Jugador> jugadores;
  
  private List<Personaje> personajesDisponibles;
  
  private List<Personaje> personajesDesactivados;
  
  private final RealizadorDuelo realizadorDuelo;
  
  public SistemaDeDuelos(final RealizadorDuelo realizDuelo) {
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.jugadores = _arrayList;
    ArrayList<Personaje> _arrayList_1 = new ArrayList<Personaje>();
    this.personajesDisponibles = _arrayList_1;
    ArrayList<Personaje> _arrayList_2 = new ArrayList<Personaje>();
    this.personajesDesactivados = _arrayList_2;
    this.realizadorDuelo = realizDuelo;
  }
  
  /**
   * Devuelve un jugador en el mismo escalon de ranking. Si no encuentra ninguno crea y devuelve una nueva instancia de Mr.X
   */
  public Jugador encontrarRivalAcorde(final Jugador jugador, final Personaje personaje) {
    Integer _ranking = jugador.getRanking();
    final int rankingMenor = ((_ranking).intValue() - 100);
    Integer _ranking_1 = jugador.getRanking();
    final int rankingMayor = ((_ranking_1).intValue() + 100);
    for (final Jugador j : this.jugadores) {
      boolean _and = false;
      boolean _or = false;
      Integer _ranking_2 = j.getRanking();
      boolean _lessThan = (rankingMenor < (_ranking_2).intValue());
      if (_lessThan) {
        _or = true;
      } else {
        Integer _ranking_3 = j.getRanking();
        boolean _greaterThan = (rankingMayor > (_ranking_3).intValue());
        _or = _greaterThan;
      }
      if (!_or) {
        _and = false;
      } else {
        boolean _notEquals = (!Objects.equal(j, jugador));
        _and = _notEquals;
      }
      if (_and) {
        return j;
      }
    }
    return this.generarJugadorMrX(jugador, personaje);
  }
  
  /**
   * Genera y devuelve una instancia nueva de Mr.X con todos los paramenteros necesarios para el duelo igual que el retador
   * por lo tanto el ganador del duelo se decide por el numero de suerte
   */
  public Jugador generarJugadorMrX(final Jugador jugador, final Personaje personaje) {
    Jugador _xblockexpression = null;
    {
      Jugador mrX = new Jugador("MR.x", this);
      final Personaje per = this.filtrarPersonaje(this.personajesDisponibles, personaje);
      final Estadisticas est = new Estadisticas(per, mrX);
      final Procedure1<Jugador> _function = new Procedure1<Jugador>() {
        public void apply(final Jugador it) {
          Integer _puntuacionRanking = jugador.getPuntuacionRanking();
          it.setPuntuacionRanking(_puntuacionRanking);
          Integer _pesoDenuncias = jugador.getPesoDenuncias();
          it.setPesoDenuncias(_pesoDenuncias);
          it.agregarPersonaje(per);
        }
      };
      ObjectExtensions.<Jugador>operator_doubleArrow(mrX, _function);
      final Estadisticas estadisticaMrX = jugador.getEstadisticas(personaje);
      final Procedure1<Estadisticas> _function_1 = new Procedure1<Estadisticas>() {
        public void apply(final Estadisticas it) {
          Integer _cantDuelosIniciados = estadisticaMrX.getCantDuelosIniciados();
          it.setCantDuelosIniciados(_cantDuelosIniciados);
          Integer _cantDuelosGanados = estadisticaMrX.getCantDuelosGanados();
          it.setCantDuelosGanados(_cantDuelosGanados);
          Integer _cantKills = estadisticaMrX.getCantKills();
          it.setCantKills(_cantKills);
          Integer _cantDeads = estadisticaMrX.getCantDeads();
          it.setCantDeads(_cantDeads);
          Integer _assists = estadisticaMrX.getAssists();
          it.setAssists(_assists);
          Set<String> _ubicacionesUsadas = estadisticaMrX.getUbicacionesUsadas();
          it.setUbicacionesUsadas(_ubicacionesUsadas);
          String _mejorUbicacion = estadisticaMrX.getMejorUbicacion();
          it.setMejorUbicacion(_mejorUbicacion);
          double _clasificacion = estadisticaMrX.getClasificacion();
          it.setClasificacion(_clasificacion);
        }
      };
      ObjectExtensions.<Estadisticas>operator_doubleArrow(est, _function_1);
      List<Estadisticas> _misEstadisticas = mrX.getMisEstadisticas();
      _misEstadisticas.add(est);
      _xblockexpression = mrX;
    }
    return _xblockexpression;
  }
  
  /**
   * Devuelve un personaje para participar de un duelo diferente al del retador (que es el pasado por parametro)
   */
  public Personaje filtrarPersonaje(final List<Personaje> personajes, final Personaje pers) {
    for (final Personaje j : personajes) {
      boolean _notEquals = (!Objects.equal(j, pers));
      if (_notEquals) {
        return j;
      }
    }
    return null;
  }
  
  /**
   * recibe un Jugador (retador), el personaje y la posicion seleccionada por el susodicho, busca un rival y realiza el duelo e/ estos dos
   */
  public void iniciarDuelo(final Jugador ret, final Personaje personaje, final String pos) {
    final Personaje rivPers = this.buscarPersonajeParaDuelo(ret, personaje);
    final Jugador rival = this.encontrarRivalAcorde(ret, personaje);
    this.realizadorDuelo.realizarDuelo(pos, ret, rival, personaje, rivPers);
  }
  
  /**
   * Dado un jugador busca los personajes capaces de afrontar el duelo. De no encontrar ninguno, devuelve cualquier personaje
   */
  public Personaje buscarPersonajeParaDuelo(final Jugador jugador, final Personaje personaje) {
    List<Personaje> personajesAptos = new ArrayList<Personaje>();
    Personaje personajeApto = null;
    List<Estadisticas> _misEstadisticas = jugador.getMisEstadisticas();
    for (final Estadisticas e : _misEstadisticas) {
      Integer _cantDuelosIniciados = e.getCantDuelosIniciados();
      boolean _greaterThan = ((_cantDuelosIniciados).intValue() > 0);
      if (_greaterThan) {
        Personaje _personaje = e.getPersonaje();
        personajesAptos.add(_personaje);
      }
    }
    int _size = personajesAptos.size();
    boolean _greaterThan_1 = (_size > 0);
    if (_greaterThan_1) {
      List<Personaje> _personajes = jugador.getPersonajes();
      Personaje _filtrarPersonaje = this.filtrarPersonaje(_personajes, personaje);
      personajeApto = _filtrarPersonaje;
    } else {
      Personaje _filtrarPersonaje_1 = this.filtrarPersonaje(personajesAptos, personaje);
      personajeApto = _filtrarPersonaje_1;
    }
    return personajeApto;
  }
  
  /**
   * Agrega un personaje a la lista de personajes del sistema
   */
  public void agregarPersonaje(final Personaje personaje) {
    this.personajesDisponibles.add(personaje);
  }
  
  public void modificarPersonaje() {
  }
  
  /**
   * Desactiva un personaje, haciendo que no sea posible seleccionarlo pero no lo elimina del sistema
   */
  public boolean desactivarPersonaje(final Personaje personaje) {
    boolean _xblockexpression = false;
    {
      this.personajesDesactivados.add(personaje);
      _xblockexpression = this.personajesDisponibles.remove(personaje);
    }
    return _xblockexpression;
  }
  
  /**
   * agregar un jugador previamente creado a la lista de jugadores
   */
  public void agregarJugador(final Jugador jugador) {
    this.jugadores.add(jugador);
  }
  
  /**
   * Crea un jugador nuevo y lo agrega al sistema
   */
  public void crearJugadorNuevo(final String nombreJugador) {
    Jugador _jugador = new Jugador(nombreJugador, this);
    this.jugadores.add(_jugador);
  }
  
  @Pure
  public List<Jugador> getJugadores() {
    return this.jugadores;
  }
  
  public void setJugadores(final List<Jugador> jugadores) {
    this.jugadores = jugadores;
  }
  
  @Pure
  public List<Personaje> getPersonajesDisponibles() {
    return this.personajesDisponibles;
  }
  
  public void setPersonajesDisponibles(final List<Personaje> personajesDisponibles) {
    this.personajesDisponibles = personajesDisponibles;
  }
  
  @Pure
  public List<Personaje> getPersonajesDesactivados() {
    return this.personajesDesactivados;
  }
  
  public void setPersonajesDesactivados(final List<Personaje> personajesDesactivados) {
    this.personajesDesactivados = personajesDesactivados;
  }
  
  @Pure
  public RealizadorDuelo getRealizadorDuelo() {
    return this.realizadorDuelo;
  }
}
