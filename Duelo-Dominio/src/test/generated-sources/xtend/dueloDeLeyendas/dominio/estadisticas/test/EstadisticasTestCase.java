package dueloDeLeyendas.dominio.estadisticas.test;

import dueloDeLeyendas.dominio.estadisticas.Estadisticas;
import dueloDeLeyendas.dominio.jugador.Jugador;
import dueloDeLeyendas.dominio.personaje.Personaje;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Esta clase se encarga de testear la funcionalidad de la clase Estadisticas
 */
@SuppressWarnings("all")
public class EstadisticasTestCase {
  private Personaje pers;
  
  private Jugador jug;
  
  private Estadisticas est;
  
  @Before
  public void setUp() {
    Personaje _mock = Mockito.<Personaje>mock(Personaje.class);
    this.pers = _mock;
    Jugador _mock_1 = Mockito.<Jugador>mock(Jugador.class);
    this.jug = _mock_1;
    Estadisticas _estadisticas = new Estadisticas(this.pers, this.jug);
    this.est = _estadisticas;
  }
  
  @Test
  public void testSumarIniciado() {
    this.est.sumarIniciado();
    final Integer iniciados = this.est.getCantDuelosIniciados();
    Assert.assertEquals((iniciados).intValue(), 1);
  }
  
  @Test
  public void testSumarGanado() {
    this.est.sumarGanado();
    final Integer ganados = this.est.getCantDuelosGanados();
    Assert.assertEquals((ganados).intValue(), 1);
  }
  
  @Test
  public void testSumarKill() {
    this.est.sumarKill();
    final Integer kills = this.est.getCantKills();
    Assert.assertEquals((kills).intValue(), 1);
  }
  
  @Test
  public void testSumarDead() {
    this.est.sumarDead();
    final Integer deads = this.est.getCantDeads();
    Assert.assertEquals((deads).intValue(), 1);
  }
  
  @Test
  public void testSumarAssist() {
    this.est.sumarAssist();
    final Integer assists = this.est.getAssists();
    Assert.assertEquals((assists).intValue(), 1);
  }
  
  @Test
  public void testAgregarUbicacionSinRepetidos() {
    this.est.agregarUbicacion("TOP");
    final Set<String> ubicaciones = this.est.getUbicacionesUsadas();
    boolean _contains = ubicaciones.contains("TOP");
    Assert.assertTrue(_contains);
  }
  
  @Test
  public void testAgregarUbicacionConRepetidos() {
    this.est.agregarUbicacion("MID");
    Set<String> ubicaciones = this.est.getUbicacionesUsadas();
    boolean _contains = ubicaciones.contains("MID");
    Assert.assertTrue(_contains);
    int _size = ubicaciones.size();
    Assert.assertEquals(_size, 1);
    this.est.agregarUbicacion("MID");
    boolean _contains_1 = ubicaciones.contains("MID");
    Assert.assertTrue(_contains_1);
    int _size_1 = ubicaciones.size();
    Assert.assertEquals(_size_1, 1);
  }
}
