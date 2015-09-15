package dueloDeLeyendas.dominio.jugador.test

import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.personaje.Personaje
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos
import dueloDeLeyendas.dominio.estadisticas.Estadisticas
import org.junit.Before
import static org.mockito.Mockito.*
import org.junit.Test
import static org.junit.Assert.*

class JugadorTestCase {
	
	var Jugador jugador
	var Personaje personaje
	var Personaje personaje1
	var SistemaDeDuelos sistema
	var Estadisticas estadistica
	
	
	@Before def void setUp(){
		jugador = new Jugador("HellRaiser", sistema)
		personaje= mock (typeof(Personaje))
		personaje1 = mock (typeof(Personaje))
		estadistica = mock (typeof(Estadisticas))
		sistema = mock(typeof(SistemaDeDuelos)) 
		when(estadistica.jugador).thenReturn(jugador)
		when(estadistica.personaje).thenReturn(personaje)
		when(estadistica.cantDuelosGanados).thenReturn(20)
		jugador.misEstadisticas.add(estadistica)
	}
	
	@Test def void testRanking(){
		var Integer expected = 0
		var Integer actual = jugador.ranking
		assertEquals(expected, actual)
	}
	
	@Test def void testCantidadDuelosGanados(){
		var Integer expected = 20
		var Integer actual = jugador.getEstadisticas(personaje).cantDuelosGanados
		assertEquals(expected, actual)
	} 
	
	
}