package dueloDeLeyendas.dominio.jugador;

import com.google.common.base.Objects;
import dueloDeLeyendas.dominio.estadisticas.Estadisticas;
import dueloDeLeyendas.dominio.personaje.Personaje;
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Jugador {
  private String nombreJugador;
  
  private Integer pesoDenuncias;
  
  private Integer puntuacionRanking;
  
  private List<Personaje> personajes;
  
  private List<Estadisticas> misEstadisticas;
  
  private SistemaDeDuelos sistema;
  
  public Jugador(final String nombre, final SistemaDeDuelos sist) {
    this.nombreJugador = nombre;
    this.pesoDenuncias = Integer.valueOf(0);
    this.puntuacionRanking = Integer.valueOf(0);
    ArrayList<Personaje> _arrayList = new ArrayList<Personaje>();
    this.personajes = _arrayList;
    ArrayList<Estadisticas> _arrayList_1 = new ArrayList<Estadisticas>();
    this.misEstadisticas = _arrayList_1;
    this.sistema = sist;
  }
  
  public void iniciarDuelo(final SistemaDeDuelos sistema, final Personaje personaje, final String posicion) {
    sistema.iniciarDuelo(this, personaje, posicion);
  }
  
  public Integer getRanking() {
    Integer _cantDuelosGanados = this.cantDuelosGanados();
    return Integer.valueOf(((this.pesoDenuncias).intValue() * (_cantDuelosGanados).intValue()));
  }
  
  public Integer cantDuelosGanados() {
    Integer cantidadDG = Integer.valueOf(0);
    for (final Estadisticas e : this.misEstadisticas) {
      Integer _cantDuelosGanados = e.getCantDuelosGanados();
      int _plus = ((cantidadDG).intValue() + (_cantDuelosGanados).intValue());
      cantidadDG = Integer.valueOf(_plus);
    }
    return cantidadDG;
  }
  
  public boolean agregarPersonaje(final Personaje pers) {
    return this.personajes.add(pers);
  }
  
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
  
  public void ganeSumarAEstadisticas(final Jugador retador, final Personaje personaje, final String posicion, final double clasificacion) {
    Estadisticas est = this.getEstadisticas(personaje);
    boolean _equals = Objects.equal(retador, this);
    if (_equals) {
      est.actualizarGaneRetador(posicion, clasificacion);
    } else {
      est.actualizarGane();
    }
  }
  
  public void perdiSumarAEstadisticas(final Jugador retador, final Personaje personaje, final String posicion, final double clasificacion) {
    Estadisticas est = this.getEstadisticas(personaje);
    boolean _equals = Objects.equal(retador, this);
    if (_equals) {
      est.actualizarPerdiRetador(posicion, clasificacion);
    } else {
      est.actualizarPerdi();
    }
  }
  
  public void empateSumarAEstadisticas(final Jugador retador, final Personaje personaje, final String ubicacion, final double clasificacion) {
    final Estadisticas est = this.getEstadisticas(personaje);
    boolean _equals = Objects.equal(retador, this);
    if (_equals) {
      est.actualizarEmpateRetador(ubicacion, clasificacion);
    } else {
      est.actualizarEmpate();
    }
  }
  
  public void sumaleATuPesoDeDenuncia(final Integer peso) {
    this.setPesoDenuncias(Integer.valueOf(((this.pesoDenuncias).intValue() + (peso).intValue())));
  }
  
  public void sumaCalificacion(final Personaje per, final Integer i) {
    final Estadisticas est = this.getEstadisticas(per);
    est.setClasificacion((i).intValue());
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
  public List<Personaje> getPersonajes() {
    return this.personajes;
  }
  
  public void setPersonajes(final List<Personaje> personajes) {
    this.personajes = personajes;
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
