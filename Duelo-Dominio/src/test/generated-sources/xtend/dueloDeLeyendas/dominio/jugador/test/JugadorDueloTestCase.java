package dueloDeLeyendas.dominio.jugador.test;

import dueloDeLeyendas.dominio.duelo.RealizadorDuelo;
import dueloDeLeyendas.dominio.estadisticas.Estadisticas;
import dueloDeLeyendas.dominio.jugador.Jugador;
import dueloDeLeyendas.dominio.personaje.Personaje;
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos;
import org.junit.Before;
import org.mockito.Mockito;

@SuppressWarnings("all")
public class JugadorDueloTestCase {
  private Jugador jugador;
  
  private Jugador jugador1;
  
  private SistemaDeDuelos sistema;
  
  private Personaje personaje;
  
  private Personaje personaje1;
  
  private RealizadorDuelo realizador;
  
  private Estadisticas estadistica;
  
  private Estadisticas estadistica1;
  
  @Before
  public void setUp() {
    Jugador _jugador = new Jugador("ElMagoDe_W0Z", this.sistema);
    this.jugador = _jugador;
    Jugador _jugador_1 = new Jugador("B-MOr", this.sistema);
    this.jugador1 = _jugador_1;
    SistemaDeDuelos _sistemaDeDuelos = new SistemaDeDuelos(this.realizador);
    this.sistema = _sistemaDeDuelos;
    RealizadorDuelo _mock = Mockito.<RealizadorDuelo>mock(RealizadorDuelo.class);
    this.realizador = _mock;
    Personaje _mock_1 = Mockito.<Personaje>mock(Personaje.class);
    this.personaje = _mock_1;
    Personaje _mock_2 = Mockito.<Personaje>mock(Personaje.class);
    this.personaje1 = _mock_2;
    Estadisticas _mock_3 = Mockito.<Estadisticas>mock(Estadisticas.class);
    this.estadistica = _mock_3;
    Estadisticas _mock_4 = Mockito.<Estadisticas>mock(Estadisticas.class);
    this.estadistica1 = _mock_4;
  }
}
