package dueloDeLeyendas.dominio.sistemaDeDuelos;

import com.google.common.base.Objects;
import dueloDeLeyendas.dominio.duelo.RealizadorDuelo;
import dueloDeLeyendas.dominio.duelo.ResultadoDuelo;
import dueloDeLeyendas.dominio.estadisticas.Estadisticas;
import dueloDeLeyendas.dominio.jugador.Jugador;
import dueloDeLeyendas.dominio.personaje.Personaje;
import dueloDeLeyendas.dominio.sistemaDeDuelos.NoHayRival;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class SistemaDeDuelos {
  private List<Jugador> jugadores;
  
  private List<Personaje> personajesDisponibles;
  
  private List<Personaje> personajesDesactivados;
  
  private final RealizadorDuelo realizadorDuelo;
  
  private List<ResultadoDuelo> resultadosDuelo = CollectionLiterals.<ResultadoDuelo>newArrayList();
  
  /**
   * Constructor, crea una nueva instacia de sistema con un realizador de duelos
   */
  public SistemaDeDuelos(final RealizadorDuelo rd) {
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.jugadores = _arrayList;
    ArrayList<Personaje> _arrayList_1 = new ArrayList<Personaje>();
    this.personajesDisponibles = _arrayList_1;
    ArrayList<Personaje> _arrayList_2 = new ArrayList<Personaje>();
    this.personajesDesactivados = _arrayList_2;
    this.realizadorDuelo = rd;
  }
  
  /**
   * Dado un jugador y un personaje, busca un rival apropiado. De no encontrar ninguna lanza una excepcion
   */
  public Jugador encontrarRivalAcorde(final Jugador jugador, final Personaje personaje) {
    try {
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
      throw new NoHayRival();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Busca un personaje para el duelo distinto al del retador
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
   * Inicia un nuevo duelo con los parametros necesarios
   */
  public ResultadoDuelo iniciarDuelo(final Jugador ret, final Personaje personaje, final String pos) {
    ResultadoDuelo _xblockexpression = null;
    {
      final Jugador rival = this.encontrarRivalAcorde(ret, personaje);
      final Personaje rivPers = this.buscarPersonajeParaDuelo(ret, personaje);
      rival.agregarEstadistica(rivPers);
      ResultadoDuelo res = this.realizadorDuelo.realizarDuelo(pos, ret, rival, personaje, rivPers);
      this.resultadosDuelo.add(res);
      _xblockexpression = res;
    }
    return _xblockexpression;
  }
  
  /**
   * Retorna un personaje apto para iniciar el duelo, de no encontrar ninguno devuelve cualquier personaje siendo este
   * siempre distinto al personaje del retador
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
      List<Personaje> _personajesConLosQueJuge = jugador.personajesConLosQueJuge();
      Personaje _filtrarPersonaje = this.filtrarPersonaje(_personajesConLosQueJuge, personaje);
      personajeApto = _filtrarPersonaje;
    } else {
      Personaje _filtrarPersonaje_1 = this.filtrarPersonaje(personajesAptos, personaje);
      personajeApto = _filtrarPersonaje_1;
    }
    return personajeApto;
  }
  
  /**
   * Agregar un personaje a la lista de personajes disponibles para usar
   */
  public void agregarPersonaje(final Personaje personaje) {
    this.personajesDisponibles.add(personaje);
  }
  
  /**
   * Elimina al personaje de la lista de personajes disponibles pero no del sistema alcenandolo en otra lista
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
   * Reactiva un personaje
   */
  public boolean activarPersonaje(final Personaje personaje) {
    boolean _xblockexpression = false;
    {
      boolean _contains = this.personajesDesactivados.contains(personaje);
      if (_contains) {
        this.personajesDisponibles.add(personaje);
      }
      _xblockexpression = this.personajesDesactivados.remove(personaje);
    }
    return _xblockexpression;
  }
  
  /**
   * Agrega un jugador previamente creado a la lista de jugadores
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
  
  /**
   * Agrega una habilidad al personaje pasado por parametro
   */
  public void agregarHabilidadPersonaje(final Personaje per, final String habilidad) {
    boolean _contains = this.personajesDisponibles.contains(per);
    if (_contains) {
      per.agregarEspecialidad(habilidad);
    }
  }
  
  /**
   * Agrega una debilidad al personaje pasado por parametro
   */
  public void agregarDebilidadPersonaje(final Personaje per, final String debilidad) {
    boolean _contains = this.personajesDisponibles.contains(per);
    if (_contains) {
      per.agregarDebilidad(debilidad);
    }
  }
  
  /**
   * Quita una hablidad al personaje pasado por parametro
   */
  public void quitarHabilidad(final Personaje per, final String habilidad) {
    boolean _contains = this.personajesDisponibles.contains(per);
    if (_contains) {
      List<String> _especialidades = per.getEspecialidades();
      _especialidades.remove(habilidad);
    }
  }
  
  /**
   * Quita una hablidad al personaje pasado por parametro
   */
  public void quitarDebilidad(final Personaje per, final String debilidad) {
    boolean _contains = this.personajesDisponibles.contains(per);
    if (_contains) {
      List<String> _especialidades = per.getEspecialidades();
      _especialidades.remove(debilidad);
    }
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
  
  @Pure
  public List<ResultadoDuelo> getResultadosDuelo() {
    return this.resultadosDuelo;
  }
  
  public void setResultadosDuelo(final List<ResultadoDuelo> resultadosDuelo) {
    this.resultadosDuelo = resultadosDuelo;
  }
}
