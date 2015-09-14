package dueloDeLeyendas.dominio.jugador.test;

import dueloDeLeyendas.dominio.estadisticas.Estadisticas;
import dueloDeLeyendas.dominio.jugador.Jugador;
import dueloDeLeyendas.dominio.personaje.Personaje;
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos;
import org.junit.Before;
import org.mockito.Mockito;

@SuppressWarnings("all")
public class JugadorTestCase {
  private Jugador jugador;
  
  private SistemaDeDuelos sistema;
  
  private Personaje personje;
  
  private Personaje personje1;
  
  private Estadisticas estadistica;
  
  @Before
  public void setUp() {
    SistemaDeDuelos _mock = Mockito.<SistemaDeDuelos>mock(SistemaDeDuelos.class);
    this.sistema = _mock;
    Jugador _jugador = new Jugador("WOPR", this.sistema);
    this.jugador = _jugador;
    Personaje _mock_1 = Mockito.<Personaje>mock(Personaje.class);
    this.personje = _mock_1;
    Personaje _mock_2 = Mockito.<Personaje>mock(Personaje.class);
    this.personje1 = _mock_2;
    Estadisticas _estadisticas = new Estadisticas(this.personje, this.jugador);
    this.estadistica = _estadisticas;
    this.jugador.agregarPersonaje(this.personje);
  }
}
