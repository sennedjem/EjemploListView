package dueloDeLeyendas.dominio.estadisticas;

import com.google.common.base.Objects;
import dueloDeLeyendas.dominio.duelo.ResultadoDuelo;
import dueloDeLeyendas.dominio.jugador.Jugador;
import dueloDeLeyendas.dominio.personaje.Personaje;
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

/**
 * Modela las estadísticas correspondientes a un jugador y un personaje
 */
@Observable
@Accessors
@SuppressWarnings("all")
public class Estadisticas {
  private final Personaje personaje;
  
  private final Jugador jugador;
  
  private String mejorUbicacion;
  
  private double clasificacion;
  
  private SistemaDeDuelos sistema;
  
  /**
   * Crea una instancia de la clase Estadisticas con los personajes y jugadores pasados
   * por parametro y todos los demas valores inicializados en 0, o lista vacia.
   */
  public Estadisticas(final Personaje pers, final Jugador jug, final SistemaDeDuelos sis) {
    this.jugador = jug;
    this.personaje = pers;
    String _posicionIdeal = this.personaje.getPosicionIdeal();
    this.mejorUbicacion = _posicionIdeal;
    this.clasificacion = 0;
    this.sistema = sis;
  }
  
  /**
   * Evalua y aplica la clasificacion correspondiente
   */
  public String getClasificacionString() {
    String _xblockexpression = null;
    {
      String clas = null;
      boolean _matched = false;
      if (!_matched) {
        boolean _esRampage = this.esRampage();
        if (_esRampage) {
          _matched=true;
          clas = "RAMPAGE";
        }
      }
      if (!_matched) {
        boolean _esDominador = this.esDominador();
        if (_esDominador) {
          _matched=true;
          clas = "DOMINADOR";
        }
      }
      if (!_matched) {
        boolean _esKillingSpread = this.esKillingSpread();
        if (_esKillingSpread) {
          _matched=true;
          clas = "KILLING-SPREAD";
        }
      }
      if (!_matched) {
        boolean _esManco = this.esManco();
        if (_esManco) {
          _matched=true;
          clas = "MANCO";
        }
      }
      if (!_matched) {
        clas = "NOOB";
      }
      _xblockexpression = clas;
    }
    return _xblockexpression;
  }
  
  /**
   * Calcula el poder de ataque del personaje del jugador
   */
  public double poderDeAtaque() {
    Integer _cantKills = this.getCantKills();
    Integer _assists = this.getAssists();
    int _modulo = ((_assists).intValue() % 2);
    int _plus = ((_cantKills).intValue() + _modulo);
    Integer _cantDeads = this.getCantDeads();
    int _minus = (_plus - (_cantDeads).intValue());
    Integer _cantDuelosIniciados = this.getCantDuelosIniciados();
    return (_minus * (_cantDuelosIniciados).intValue());
  }
  
  public Integer getCantDuelosIniciados() {
    List<ResultadoDuelo> _resultadosDuelo = this.sistema.getResultadosDuelo();
    final Function1<ResultadoDuelo, Boolean> _function = new Function1<ResultadoDuelo, Boolean>() {
      public Boolean apply(final ResultadoDuelo it) {
        return Boolean.valueOf(it.esIniciador(Estadisticas.this.jugador));
      }
    };
    Iterable<ResultadoDuelo> _filter = IterableExtensions.<ResultadoDuelo>filter(_resultadosDuelo, _function);
    int _size = IterableExtensions.size(_filter);
    return Integer.valueOf((0 + _size));
  }
  
  public Integer getCantDeads() {
    List<ResultadoDuelo> _resultadosDuelo = this.sistema.getResultadosDuelo();
    final Function1<ResultadoDuelo, Boolean> _function = new Function1<ResultadoDuelo, Boolean>() {
      public Boolean apply(final ResultadoDuelo it) {
        boolean _and = false;
        boolean _esRetado = it.esRetado(Estadisticas.this.jugador);
        if (!_esRetado) {
          _and = false;
        } else {
          double _poderAtaqueIniciador = it.getPoderAtaqueIniciador();
          double _poderAtaqueRetado = it.getPoderAtaqueRetado();
          boolean _greaterThan = (_poderAtaqueIniciador > _poderAtaqueRetado);
          _and = _greaterThan;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<ResultadoDuelo> _filter = IterableExtensions.<ResultadoDuelo>filter(_resultadosDuelo, _function);
    int _size = IterableExtensions.size(_filter);
    return Integer.valueOf((0 + _size));
  }
  
  public Integer getAssists() {
    List<ResultadoDuelo> _resultadosDuelo = this.sistema.getResultadosDuelo();
    final Function1<ResultadoDuelo, Boolean> _function = new Function1<ResultadoDuelo, Boolean>() {
      public Boolean apply(final ResultadoDuelo it) {
        boolean _and = false;
        boolean _participo = it.participo(Estadisticas.this.jugador);
        if (!_participo) {
          _and = false;
        } else {
          boolean _esEmpate = it.esEmpate();
          _and = _esEmpate;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<ResultadoDuelo> _filter = IterableExtensions.<ResultadoDuelo>filter(_resultadosDuelo, _function);
    int _size = IterableExtensions.size(_filter);
    return Integer.valueOf((0 + _size));
  }
  
  public Integer getCantKills() {
    List<ResultadoDuelo> _resultadosDuelo = this.sistema.getResultadosDuelo();
    final Function1<ResultadoDuelo, Boolean> _function = new Function1<ResultadoDuelo, Boolean>() {
      public Boolean apply(final ResultadoDuelo it) {
        boolean _and = false;
        boolean _esRetado = it.esRetado(Estadisticas.this.jugador);
        if (!_esRetado) {
          _and = false;
        } else {
          boolean _ganoRetado = it.ganoRetado();
          _and = _ganoRetado;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<ResultadoDuelo> _filter = IterableExtensions.<ResultadoDuelo>filter(_resultadosDuelo, _function);
    int _size = IterableExtensions.size(_filter);
    return Integer.valueOf((0 + _size));
  }
  
  public Integer getCantGanadosEIniciados() {
    List<ResultadoDuelo> _resultadosDuelo = this.sistema.getResultadosDuelo();
    final Function1<ResultadoDuelo, Boolean> _function = new Function1<ResultadoDuelo, Boolean>() {
      public Boolean apply(final ResultadoDuelo it) {
        boolean _and = false;
        boolean _esIniciador = it.esIniciador(Estadisticas.this.jugador);
        if (!_esIniciador) {
          _and = false;
        } else {
          boolean _ganoIniciador = it.ganoIniciador();
          _and = _ganoIniciador;
        }
        return Boolean.valueOf(_and);
      }
    };
    Iterable<ResultadoDuelo> _filter = IterableExtensions.<ResultadoDuelo>filter(_resultadosDuelo, _function);
    int _size = IterableExtensions.size(_filter);
    return Integer.valueOf((0 + _size));
  }
  
  public Integer getGetCantDuelosGanados() {
    Integer _cantGanadosEIniciados = this.getCantGanadosEIniciados();
    int _plus = (0 + (_cantGanadosEIniciados).intValue());
    Integer _cantKills = this.getCantKills();
    return Integer.valueOf((_plus + (_cantKills).intValue()));
  }
  
  public Personaje getPersonaje() {
    return this.personaje;
  }
  
  public int vecesQueUsoPosicionIdeal() {
    int cantPosicionIdeal = 0;
    ArrayList<String> _ubicacionesUsadas = this.getUbicacionesUsadas();
    for (final String ubicacion : _ubicacionesUsadas) {
      boolean _equals = Objects.equal(ubicacion, this.mejorUbicacion);
      if (_equals) {
        cantPosicionIdeal++;
      }
    }
    return cantPosicionIdeal;
  }
  
  public ArrayList<String> getUbicacionesUsadas() {
    ArrayList<String> _xblockexpression = null;
    {
      ArrayList<String> posicionesQueJugoComoIniciador = new ArrayList<String>();
      List<ResultadoDuelo> _resultadosDuelo = this.sistema.getResultadosDuelo();
      for (final ResultadoDuelo res : _resultadosDuelo) {
        boolean _esIniciador = res.esIniciador(this.jugador);
        if (_esIniciador) {
          String _posicion = res.getPosicion();
          posicionesQueJugoComoIniciador.add(_posicion);
        }
      }
      _xblockexpression = posicionesQueJugoComoIniciador;
    }
    return _xblockexpression;
  }
  
  public int numeroRandom() {
    long _currentTimeMillis = System.currentTimeMillis();
    final Random rand = new Random(_currentTimeMillis);
    return rand.nextInt(150);
  }
  
  public boolean esRampage() {
    boolean _and = false;
    boolean _and_1 = false;
    Integer _getCantDuelosGanados = this.getGetCantDuelosGanados();
    boolean _greaterEqualsThan = ((_getCantDuelosGanados).intValue() >= 5);
    if (!_greaterEqualsThan) {
      _and_1 = false;
    } else {
      int _vecesQueUsoPosicionIdeal = this.vecesQueUsoPosicionIdeal();
      boolean _greaterEqualsThan_1 = (_vecesQueUsoPosicionIdeal >= 5);
      _and_1 = _greaterEqualsThan_1;
    }
    if (!_and_1) {
      _and = false;
    } else {
      int _numeroRandom = this.numeroRandom();
      boolean _greaterThan = (_numeroRandom > 90);
      _and = _greaterThan;
    }
    return _and;
  }
  
  /**
   * Determina si el personaje del jugador es Dominador
   */
  public boolean esDominador() {
    boolean _and = false;
    boolean _and_1 = false;
    Integer _getCantDuelosGanados = this.getGetCantDuelosGanados();
    boolean _greaterEqualsThan = ((_getCantDuelosGanados).intValue() >= 2);
    if (!_greaterEqualsThan) {
      _and_1 = false;
    } else {
      int _vecesQueUsoPosicionIdeal = this.vecesQueUsoPosicionIdeal();
      boolean _greaterEqualsThan_1 = (_vecesQueUsoPosicionIdeal >= 2);
      _and_1 = _greaterEqualsThan_1;
    }
    if (!_and_1) {
      _and = false;
    } else {
      int _numeroRandom = this.numeroRandom();
      boolean _greaterThan = (_numeroRandom > 70);
      _and = _greaterThan;
    }
    return _and;
  }
  
  public boolean esKillingSpread() {
    int _numeroRandom = this.numeroRandom();
    return (_numeroRandom > 50);
  }
  
  public boolean esManco() {
    int _numeroRandom = this.numeroRandom();
    return (_numeroRandom > 30);
  }
  
  @Pure
  public Jugador getJugador() {
    return this.jugador;
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
  
  @Pure
  public SistemaDeDuelos getSistema() {
    return this.sistema;
  }
  
  public void setSistema(final SistemaDeDuelos sistema) {
    this.sistema = sistema;
  }
}
