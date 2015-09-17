package dueloDeLeyendas.dominio.sistemaDeDuelo.test

import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos
import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.personaje.Personaje
import org.junit.Before
import static org.mockito.Mockito.*
import org.junit.Test
import static org.junit.Assert.*
import dueloDeLeyendas.dominio.realizarDuelo.RealizadorDuelo

class SistemaDeDuelosTestCase {
	var SistemaDeDuelos sistema
	var Jugador jugador
	var Jugador jugador1
	var Personaje personaje
	var Personaje personaje1
	var RealizadorDuelo realizadorDuel
	var Jugador jugador2
	
	@Before def void setUp() {
		realizadorDuel = mock(typeof(RealizadorDuelo))
		sistema = new SistemaDeDuelos(realizadorDuel)
		jugador = new Jugador("DarthJ0rge", sistema)
		jugador = spy(jugador)
		jugador1 =new Jugador("Flynn_Lives", sistema)
		jugador1 = spy(jugador1)
		jugador2 = new Jugador("ZeroCool", sistema)
		personaje = mock(typeof(Personaje))
		personaje1 = mock(typeof(Personaje))
		sistema.agregarJugador(jugador)
		sistema.agregarJugador(jugador1)
		sistema.agregarPersonaje(personaje)		
		jugador.agregarPersonaje(personaje)
		jugador1.agregarPersonaje(personaje1)
		jugador1.agregarPersonaje(personaje)		
	}
	
	@Test def void testAgregarPersonaje(){
		sistema.agregarPersonaje(personaje1)
		var Boolean expected= true
		var Integer expected1= 2
		var Boolean actual = sistema.personajesDisponibles.contains(personaje)
		var Integer actual1= sistema.personajesDisponibles.size 
		assertEquals(expected, actual)
		assertEquals(expected1, actual1)
	}
	
	@Test def void testAgregarJugador(){
		sistema.agregarJugador(jugador2)
		var Boolean expected = true
		var Boolean actual = sistema.jugadores.contains(jugador2)
		var Integer expc = 3
		var Integer act = sistema.jugadores.size
		assertEquals(expected, actual)
		assertEquals(expc, act)
	}
	 
	@Test def void TestencontrarRivalAcorde(){
		when(jugador.ranking).thenReturn(100)
		when(jugador1.ranking).thenReturn(100)
		var Jugador expected = jugador1
		var Jugador actual = sistema.encontrarRivalAcorde(jugador, personaje)
		assertEquals(expected, actual)
	} 
	
	@Test def void testDesactivarPersonaje(){
		sistema.desactivarPersonaje(personaje1)
		var Boolean expected = false
		var Boolean actual = sistema.personajesDisponibles.contains(personaje1)
		var Boolean expec = true
		var Boolean act = sistema.personajesDesactivados.contains(personaje1)
		assertEquals(expected, actual)
		assertEquals (expec, act)
	}
}