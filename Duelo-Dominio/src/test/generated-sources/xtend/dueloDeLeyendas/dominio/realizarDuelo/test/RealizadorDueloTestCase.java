package dueloDeLeyendas.dominio.realizarDuelo.test;

import dueloDeLeyendas.dominio.duelo.RealizadorDuelo;
import dueloDeLeyendas.dominio.estadisticas.Estadisticas;
import dueloDeLeyendas.dominio.jugador.Jugador;
import dueloDeLeyendas.dominio.personaje.Personaje;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

@SuppressWarnings("all")
public class RealizadorDueloTestCase {
  RealizadorDuelo rd;
  
  Jugador retadorMock;
  
  Jugador rivalMock;
  
  Personaje pRetMock;
  
  Personaje pRivMock;
  
  Estadisticas estPRetMock;
  
  Estadisticas estPRivMock;
  
  @Before
  public void setUp() throws Exception {
    Jugador _mock = Mockito.<Jugador>mock(Jugador.class);
    this.retadorMock = _mock;
    Jugador _mock_1 = Mockito.<Jugador>mock(Jugador.class);
    this.rivalMock = _mock_1;
    Personaje _mock_2 = Mockito.<Personaje>mock(Personaje.class);
    this.pRetMock = _mock_2;
    Personaje _mock_3 = Mockito.<Personaje>mock(Personaje.class);
    this.pRivMock = _mock_3;
    Estadisticas _mock_4 = Mockito.<Estadisticas>mock(Estadisticas.class);
    this.estPRetMock = _mock_4;
    Estadisticas _mock_5 = Mockito.<Estadisticas>mock(Estadisticas.class);
    this.estPRivMock = _mock_5;
    RealizadorDuelo _realizadorDuelo = new RealizadorDuelo();
    this.rd = _realizadorDuelo;
    Estadisticas _estadisticas = this.retadorMock.getEstadisticas(this.pRetMock);
    OngoingStubbing<Estadisticas> _when = Mockito.<Estadisticas>when(_estadisticas);
    _when.thenReturn(this.estPRetMock);
    double _poderDeAtaque = this.estPRetMock.poderDeAtaque();
    OngoingStubbing<Double> _when_1 = Mockito.<Double>when(Double.valueOf(_poderDeAtaque));
    _when_1.thenReturn(Double.valueOf(45.0));
    Estadisticas _estadisticas_1 = this.rivalMock.getEstadisticas(this.pRivMock);
    OngoingStubbing<Estadisticas> _when_2 = Mockito.<Estadisticas>when(_estadisticas_1);
    _when_2.thenReturn(this.estPRivMock);
    double _poderDeAtaque_1 = this.estPRivMock.poderDeAtaque();
    OngoingStubbing<Double> _when_3 = Mockito.<Double>when(Double.valueOf(_poderDeAtaque_1));
    _when_3.thenReturn(Double.valueOf(40.0));
  }
  
  /**
   * Este test prueba que al realizar un duelo los resultados son los esperados
   */
  @Test
  public void testRealizarDuelo() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method ganeSumarAEstadisticas is undefined for the type RealizadorDueloTestCase"
      + "\nThe method perdiSumarAEstadisticas is undefined for the type RealizadorDueloTestCase");
  }
  
  /**
   * Este test prueba que al realizar un duelo los resultados son los esperados
   */
  @Test
  public void testRealizarDueloQueGanaElRival() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method perdiSumarAEstadisticas is undefined for the type RealizadorDueloTestCase"
      + "\nThe method ganeSumarAEstadisticas is undefined for the type RealizadorDueloTestCase");
  }
  
  /**
   * Este test prueba que al realizar un duelo los resultados son los esperados
   */
  @Test
  public void testRealizarDueloQueEmpatan() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method empateSumarAEstadisticas is undefined for the type RealizadorDueloTestCase"
      + "\nThe method empateSumarAEstadisticas is undefined for the type RealizadorDueloTestCase");
  }
}
