package dueloDeLeyendas.dominio.jugador;

import com.google.common.base.Objects;
import dueloDeLeyendas.dominio.applicationModel.PersonajePuntaje;
import dueloDeLeyendas.dominio.estadisticas.Estadisticas;
import dueloDeLeyendas.dominio.personaje.Personaje;
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class Jugador {
  /**
   * Modela al jugador
   */
  private String nombreJugador;
  
  private Integer pesoDenuncias;
  
  private Integer puntuacionRanking;
  
  private List<Estadisticas> misEstadisticas;
  
  private SistemaDeDuelos sistema;
  
  /**
   * Crea una nueva instancia de jugador con los parametros necesarios
   */
  public Jugador(final String nombre, final SistemaDeDuelos sist) {
    this.nombreJugador = nombre;
    this.pesoDenuncias = Integer.valueOf(0);
    this.puntuacionRanking = Integer.valueOf(0);
    ArrayList<Estadisticas> _arrayList = new ArrayList<Estadisticas>();
    this.misEstadisticas = _arrayList;
    this.sistema = sist;
    this.agregarTodosLosPjAEstadisticas();
  }
  
  public void agregarTodosLosPjAEstadisticas() {
    List<Personaje> _personajesDisponibles = this.sistema.getPersonajesDisponibles();
    for (final Personaje per : _personajesDisponibles) {
      this.agregarEstadistica(per);
    }
  }
  
  /**
   * Devuelve el raking de jugador
   */
  public Integer getRanking() {
    Integer _cantDuelosGanados = this.cantDuelosGanados();
    return Integer.valueOf(((this.pesoDenuncias).intValue() * (_cantDuelosGanados).intValue()));
  }
  
  /**
   * Devuelde la cantidad de duelos ganador por el jugador
   */
  public Integer cantDuelosGanados() {
    Integer cantidadDG = Integer.valueOf(0);
    for (final Estadisticas e : this.misEstadisticas) {
      Integer _getCantDuelosGanados = e.getGetCantDuelosGanados();
      int _plus = ((cantidadDG).intValue() + (_getCantDuelosGanados).intValue());
      cantidadDG = Integer.valueOf(_plus);
    }
    return cantidadDG;
  }
  
  public boolean agregarEstadistica(final Personaje pers) {
    Estadisticas _estadisticas = new Estadisticas(pers, this, this.sistema);
    return this.misEstadisticas.add(_estadisticas);
  }
  
  /**
   * Devuelve la estadistica correspondiente al personaje pasado por parametro
   */
  public Estadisticas getEstadisticas(final Personaje pers) {
    Estadisticas _xblockexpression = null;
    {
      Estadisticas estadistica = null;
      for (final Estadisticas est : this.misEstadisticas) {
        Personaje _personaje = est.getPersonaje();
        boolean _equals = Objects.equal(_personaje, pers);
        if (_equals) {
          estadistica = est;
        }
      }
      _xblockexpression = estadistica;
    }
    return _xblockexpression;
  }
  
  /**
   * Suma al peso de denuncias cuando es denunciado
   */
  public void sumaleATuPesoDeDenuncia(final Integer peso) {
    this.setPesoDenuncias(Integer.valueOf(((this.pesoDenuncias).intValue() + (peso).intValue())));
  }
  
  /**
   * Suma una calificacion pasada por parametro a la estadistica de un personaje, tambien pasado por parametro
   */
  public void sumaCalificacion(final Personaje per, final Integer i) {
    final Estadisticas est = this.getEstadisticas(per);
    est.setClasificacion((i).intValue());
  }
  
  public PersonajePuntaje getPuntajePara(final Personaje personaje) {
    PersonajePuntaje _xblockexpression = null;
    {
      final Estadisticas estadistica = this.getEstadisticas(personaje);
      PersonajePuntaje _xifexpression = null;
      boolean _equals = Objects.equal(estadistica, null);
      if (_equals) {
        _xifexpression = new PersonajePuntaje(personaje, "NOOB");
      } else {
        String _clasificacionString = estadistica.getClasificacionString();
        _xifexpression = new PersonajePuntaje(personaje, _clasificacionString);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public boolean peleasCon(final Personaje per) {
    boolean _xifexpression = false;
    boolean _noJugeConPersonaje = this.noJugeConPersonaje(per);
    if (_noJugeConPersonaje) {
      _xifexpression = this.agregarEstadistica(per);
    }
    return _xifexpression;
  }
  
  public List<Personaje> personajesConLosQueJuge() {
    final Function1<Estadisticas, Personaje> _function = new Function1<Estadisticas, Personaje>() {
      public Personaje apply(final Estadisticas it) {
        return it.getPersonaje();
      }
    };
    return ListExtensions.<Estadisticas, Personaje>map(this.misEstadisticas, _function);
  }
  
  public boolean noJugeConPersonaje(final Personaje per) {
    final Function1<Estadisticas, Boolean> _function = new Function1<Estadisticas, Boolean>() {
      public Boolean apply(final Estadisticas e) {
        Personaje _personaje = e.getPersonaje();
        return Boolean.valueOf(Objects.equal(_personaje, per));
      }
    };
    boolean _forall = IterableExtensions.<Estadisticas>forall(this.misEstadisticas, _function);
    return (!_forall);
  }
  
  public boolean agregarPersonajes(final ArrayList<Personaje> personajes) {
    return personajes.addAll(personajes);
  }
  
  @Pure
  public String getNombreJugador() {
    return this.nombreJugador;
  }
  
  public void setNombreJugador(final String nombreJugador) {
    this.nombreJugador = nombreJugador;
  }
  
  @Pure
  public Integer getPesoDenuncias() {
    return this.pesoDenuncias;
  }
  
  public void setPesoDenuncias(final Integer pesoDenuncias) {
    this.pesoDenuncias = pesoDenuncias;
  }
  
  @Pure
  public Integer getPuntuacionRanking() {
    return this.puntuacionRanking;
  }
  
  public void setPuntuacionRanking(final Integer puntuacionRanking) {
    this.puntuacionRanking = puntuacionRanking;
  }
  
  @Pure
  public List<Estadisticas> getMisEstadisticas() {
    return this.misEstadisticas;
  }
  
  public void setMisEstadisticas(final List<Estadisticas> misEstadisticas) {
    this.misEstadisticas = misEstadisticas;
  }
  
  @Pure
  public SistemaDeDuelos getSistema() {
    return this.sistema;
  }
  
  public void setSistema(final SistemaDeDuelos sistema) {
    this.sistema = sistema;
  }
}
