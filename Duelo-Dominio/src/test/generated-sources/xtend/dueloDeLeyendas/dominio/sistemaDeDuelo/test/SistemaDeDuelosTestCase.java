package dueloDeLeyendas.dominio.sistemaDeDuelo.test;

import dueloDeLeyendas.dominio.duelo.RealizadorDuelo;
import dueloDeLeyendas.dominio.jugador.Jugador;
import dueloDeLeyendas.dominio.personaje.Personaje;
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

@SuppressWarnings("all")
public class SistemaDeDuelosTestCase {
  private SistemaDeDuelos sistema;
  
  private Jugador jugador;
  
  private Jugador jugador1;
  
  private Personaje personaje;
  
  private Personaje personaje1;
  
  private RealizadorDuelo realizadorDuel;
  
  private Jugador jugador2;
  
  @Before
  public void setUp() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method agregarPersonaje is undefined for the type SistemaDeDuelosTestCase"
      + "\nThe method agregarPersonaje is undefined for the type SistemaDeDuelosTestCase"
      + "\nThe method agregarPersonaje is undefined for the type SistemaDeDuelosTestCase");
  }
  
  @Test
  public void testAgregarPersonaje() {
    this.sistema.agregarPersonaje(this.personaje1);
    Boolean expected = Boolean.valueOf(true);
    Integer expected1 = Integer.valueOf(2);
    List<Personaje> _personajesDisponibles = this.sistema.getPersonajesDisponibles();
    Boolean actual = Boolean.valueOf(_personajesDisponibles.contains(this.personaje));
    List<Personaje> _personajesDisponibles_1 = this.sistema.getPersonajesDisponibles();
    Integer actual1 = Integer.valueOf(_personajesDisponibles_1.size());
    Assert.assertEquals(expected, actual);
    Assert.assertEquals(expected1, actual1);
  }
  
  @Test
  public void testAgregarJugador() {
    this.sistema.agregarJugador(this.jugador2);
    Boolean expected = Boolean.valueOf(true);
    List<Jugador> _jugadores = this.sistema.getJugadores();
    Boolean actual = Boolean.valueOf(_jugadores.contains(this.jugador2));
    Integer expc = Integer.valueOf(3);
    List<Jugador> _jugadores_1 = this.sistema.getJugadores();
    Integer act = Integer.valueOf(_jugadores_1.size());
    Assert.assertEquals(expected, actual);
    Assert.assertEquals(expc, act);
  }
  
  @Test
  public void TestencontrarRivalAcorde() {
    Integer _ranking = this.jugador.getRanking();
    OngoingStubbing<Integer> _when = Mockito.<Integer>when(_ranking);
    _when.thenReturn(Integer.valueOf(100));
    Integer _ranking_1 = this.jugador1.getRanking();
    OngoingStubbing<Integer> _when_1 = Mockito.<Integer>when(_ranking_1);
    _when_1.thenReturn(Integer.valueOf(100));
    Jugador expected = this.jugador1;
    Jugador actual = this.sistema.encontrarRivalAcorde(this.jugador, this.personaje);
    Assert.assertEquals(expected, actual);
  }
  
  @Test
  public void testDesactivarPersonaje() {
    this.sistema.desactivarPersonaje(this.personaje1);
    Boolean expected = Boolean.valueOf(false);
    List<Personaje> _personajesDisponibles = this.sistema.getPersonajesDisponibles();
    Boolean actual = Boolean.valueOf(_personajesDisponibles.contains(this.personaje1));
    Boolean expec = Boolean.valueOf(true);
    List<Personaje> _personajesDesactivados = this.sistema.getPersonajesDesactivados();
    Boolean act = Boolean.valueOf(_personajesDesactivados.contains(this.personaje1));
    Assert.assertEquals(expected, actual);
    Assert.assertEquals(expec, act);
  }
}
