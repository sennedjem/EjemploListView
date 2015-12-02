package dueloDeLeyendas.dominio.jugador.test;

import dueloDeLeyendas.dominio.estadisticas.Estadisticas;
import dueloDeLeyendas.dominio.jugador.Jugador;
import dueloDeLeyendas.dominio.personaje.Personaje;
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class JugadorTestCase {
  private Jugador jugador;
  
  private Personaje personaje;
  
  private Personaje personaje1;
  
  private SistemaDeDuelos sistema;
  
  private Estadisticas estadistica;
  
  @Before
  public void setUp() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method cantDuelosGanados is undefined for the type JugadorTestCase"
      + "\nThe method personajes is undefined for the type JugadorTestCase"
      + "\nadd cannot be resolved");
  }
  
  @Test
  public void testRanking() {
    Integer expected = Integer.valueOf(0);
    Integer actual = this.jugador.getRanking();
    Assert.assertEquals(expected, actual);
  }
  
  @Test
  public void testCantidadDuelosGanados() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method cantDuelosGanados is undefined for the type JugadorTestCase");
  }
  
  @Test
  public void testAgregarPersonaje() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method agregarPersonaje is undefined for the type JugadorTestCase"
      + "\nThe method personajes is undefined for the type JugadorTestCase"
      + "\nThe method personajes is undefined for the type JugadorTestCase"
      + "\ncontains cannot be resolved"
      + "\nsize cannot be resolved");
  }
  
  @Test
  public void testGetEstadistica() {
    Estadisticas expected = this.estadistica;
    Estadisticas actual = this.jugador.getEstadisticas(this.personaje);
    Assert.assertEquals(expected, actual);
  }
}
