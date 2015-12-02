package dueloDeLeyendas.dominio.applicationModel;

import dueloDeLeyendas.dominio.applicationModel.PersonajePuntaje;
import dueloDeLeyendas.dominio.duelo.RealizadorDuelo;
import dueloDeLeyendas.dominio.duelo.ResultadoDuelo;
import dueloDeLeyendas.dominio.estadisticas.Estadisticas;
import dueloDeLeyendas.dominio.jugador.Jugador;
import dueloDeLeyendas.dominio.personaje.Personaje;
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

/**
 * Inicializacion a la Application
 */
@Observable
@Accessors
@SuppressWarnings("all")
public class DueloDeLeyendasModel {
  private List<Personaje> personajes;
  
  private String posicion;
  
  private RealizadorDuelo realizador;
  
  private Jugador capitanZanahoria;
  
  /**
   * Inicializa todos los colaboradores de la clase
   */
  public DueloDeLeyendasModel() {
    RealizadorDuelo _realizadorDuelo = new RealizadorDuelo();
    SistemaDeDuelos _sistemaDeDuelos = new SistemaDeDuelos(_realizadorDuelo);
    this.sistema = _sistemaDeDuelos;
    Jugador _jugador = new Jugador("Marcos", this.sistema);
    this.jugador = _jugador;
    Jugador _jugador_1 = new Jugador("capitanZanahoria", this.sistema);
    this.capitanZanahoria = _jugador_1;
    ArrayList<Personaje> _arrayList = new ArrayList<Personaje>();
    this.personajes = _arrayList;
    this.sistema.agregarJugador(this.capitanZanahoria);
    this.inicializarPersonajes();
    this.inicializarStats();
    final Function1<Personaje, PersonajePuntaje> _function = new Function1<Personaje, PersonajePuntaje>() {
      public PersonajePuntaje apply(final Personaje it) {
        return DueloDeLeyendasModel.this.jugador.getPuntajePara(it);
      }
    };
    List<PersonajePuntaje> _map = ListExtensions.<Personaje, PersonajePuntaje>map(this.personajes, _function);
    this.todosLosPersonajes = _map;
  }
  
  /**
   * Inicializa los 8 personajes de la pantalla principal, los agrega a la lista de personajes del modelo,
   * le agrega cuatro personajes al jugador, y pone al primer personaje como el personaje
   * seleccionado por defecto en la pantalla
   */
  public PersonajePuntaje inicializarPersonajes() {
    PersonajePuntaje _xblockexpression = null;
    {
      List<String> habilidades = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Ataque", "Defensa"));
      List<String> habilidades2 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Auto recuperacion"));
      List<String> habilidades3 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Daño a distancia", "Hundir acorazados"));
      List<String> habilidades4 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Proteccion ante hechizos", "Auto recuperacion"));
      List<String> habilidades5 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Sale de la B en un año"));
      List<String> habilidades6 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Punteria aumentada", "Velocidad superSonica", "Proteccion celestial"));
      List<String> habilidades7 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Velocidad de Lince", "Compartir XP"));
      List<String> habilidades8 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Agilidad imperial", "Robo de vida"));
      List<String> debilidades = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Alergico al agua"));
      List<String> debilidades2 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Miedo a la Obscuridad", "Ataque de asma"));
      List<String> debilidades3 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("No sabe leer", ""));
      List<String> debilidades4 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Hemorragia veloz"));
      List<String> debilidades5 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Torpeza"));
      List<String> debilidades6 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Baja concentracion"));
      List<String> debilidades7 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Inferioridad ante magia"));
      List<String> debilidades8 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Fotosensibilidad"));
      final Personaje per1 = new Personaje("Amumu", habilidades, debilidades7, "MID");
      final Personaje per2 = new Personaje("Techies", habilidades2, debilidades2, "TOP");
      final Personaje per3 = new Personaje("Katarina", habilidades3, debilidades3, "JUNGLE");
      final Personaje per4 = new Personaje("Sniper", habilidades4, debilidades4, "BOT");
      final Personaje per5 = new Personaje("Undaying", habilidades5, debilidades5, "MID");
      final Personaje per6 = new Personaje("Master Yi", habilidades6, debilidades6, "TOP");
      final Personaje per7 = new Personaje("Axe", habilidades7, debilidades, "JUNGLE");
      final Personaje per8 = new Personaje("Ashe", habilidades8, debilidades8, "BOT");
      final Procedure1<List<Personaje>> _function = new Procedure1<List<Personaje>>() {
        public void apply(final List<Personaje> it) {
          it.add(per1);
          it.add(per2);
          it.add(per3);
          it.add(per4);
          it.add(per5);
          it.add(per6);
          it.add(per7);
          it.add(per8);
        }
      };
      ObjectExtensions.<List<Personaje>>operator_doubleArrow(
        this.personajes, _function);
      final Procedure1<Jugador> _function_1 = new Procedure1<Jugador>() {
        public void apply(final Jugador it) {
          it.agregarEstadistica(per1);
          it.agregarEstadistica(per2);
          it.agregarEstadistica(per4);
          it.agregarEstadistica(per5);
        }
      };
      ObjectExtensions.<Jugador>operator_doubleArrow(
        this.jugador, _function_1);
      Estadisticas _estadisticas = this.jugador.getEstadisticas(per1);
      String _clasificacionString = _estadisticas.getClasificacionString();
      PersonajePuntaje _personajePuntaje = new PersonajePuntaje(per1, _clasificacionString);
      _xblockexpression = this.personajeSeleccionado = _personajePuntaje;
    }
    return _xblockexpression;
  }
  
  /**
   * Setea los stats para todos los personajes del jugador y crea la lista de personajes para la tabla
   */
  public Object inicializarStats() {
    return null;
  }
  
  /**
   * Setea las estadisticas del personaje pasado por parametro y con el jugador y datos pasados por parámetro
   */
  private PersonajePuntaje personajeSeleccionado;
  
  private String buscado;
  
  private Jugador jugador;
  
  private List<PersonajePuntaje> todosLosPersonajes;
  
  private SistemaDeDuelos sistema;
  
  /**
   * Setea el string buscado con lo que se pasa por parametro y busca entre los personajes disponibles
   * los que tengan algo de ese string para mostrarlo en la tabla de personajes de la pantalla
   */
  public void setBuscado(final String nombre) {
    this.buscado = nombre;
    ObservableUtils.firePropertyChanged(this, "resultadoBusquedaDePersonajes");
  }
  
  public List<PersonajePuntaje> getResultadoBusquedaDePersonajes() {
    List<PersonajePuntaje> _xifexpression = null;
    boolean _isEmpty = this.buscado.isEmpty();
    if (_isEmpty) {
      _xifexpression = this.todosLosPersonajes;
    } else {
      final Function1<PersonajePuntaje, Boolean> _function = new Function1<PersonajePuntaje, Boolean>() {
        public Boolean apply(final PersonajePuntaje it) {
          Personaje _pers = it.getPers();
          String _nombre = _pers.getNombre();
          return Boolean.valueOf(_nombre.contains(DueloDeLeyendasModel.this.buscado));
        }
      };
      Iterable<PersonajePuntaje> _filter = IterableExtensions.<PersonajePuntaje>filter(this.todosLosPersonajes, _function);
      _xifexpression = IterableExtensions.<PersonajePuntaje>toList(_filter);
    }
    return _xifexpression;
  }
  
  /**
   * Devuelve los stats del personaje seleccionado actualmente
   */
  public Object getStatsPersonajeSeleccionado() {
    return null;
  }
  
  /**
   * Setea el personaje seleccionado con el que se pasa por parámetro y dispara la notificación
   * para que se actualicen sus datos en la pantalla
   */
  public void setPersonajeSeleccionado(final PersonajePuntaje p) {
    this.personajeSeleccionado = p;
    ObservableUtils.firePropertyChanged(this, "statsPersonajeSeleccionado");
  }
  
  public ResultadoDuelo iniciarDuelo() {
    ResultadoDuelo _xblockexpression = null;
    {
      Personaje _pers = this.personajeSeleccionado.getPers();
      this.jugador.peleasCon(_pers);
      Personaje _pers_1 = this.personajeSeleccionado.getPers();
      _xblockexpression = this.sistema.iniciarDuelo(this.jugador, _pers_1, this.posicion);
    }
    return _xblockexpression;
  }
  
  @Pure
  public List<Personaje> getPersonajes() {
    return this.personajes;
  }
  
  public void setPersonajes(final List<Personaje> personajes) {
    this.personajes = personajes;
  }
  
  @Pure
  public String getPosicion() {
    return this.posicion;
  }
  
  public void setPosicion(final String posicion) {
    this.posicion = posicion;
  }
  
  @Pure
  public RealizadorDuelo getRealizador() {
    return this.realizador;
  }
  
  public void setRealizador(final RealizadorDuelo realizador) {
    this.realizador = realizador;
  }
  
  @Pure
  public Jugador getCapitanZanahoria() {
    return this.capitanZanahoria;
  }
  
  public void setCapitanZanahoria(final Jugador capitanZanahoria) {
    this.capitanZanahoria = capitanZanahoria;
  }
  
  @Pure
  public PersonajePuntaje getPersonajeSeleccionado() {
    return this.personajeSeleccionado;
  }
  
  @Pure
  public String getBuscado() {
    return this.buscado;
  }
  
  @Pure
  public Jugador getJugador() {
    return this.jugador;
  }
  
  public void setJugador(final Jugador jugador) {
    this.jugador = jugador;
  }
  
  @Pure
  public List<PersonajePuntaje> getTodosLosPersonajes() {
    return this.todosLosPersonajes;
  }
  
  public void setTodosLosPersonajes(final List<PersonajePuntaje> todosLosPersonajes) {
    this.todosLosPersonajes = todosLosPersonajes;
  }
  
  @Pure
  public SistemaDeDuelos getSistema() {
    return this.sistema;
  }
  
  public void setSistema(final SistemaDeDuelos sistema) {
    this.sistema = sistema;
  }
}
