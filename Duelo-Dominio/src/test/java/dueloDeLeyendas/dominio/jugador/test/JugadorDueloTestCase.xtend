package dueloDeLeyendas.dominio.jugador.test

import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos
import dueloDeLeyendas.dominio.personaje.Personaje
import dueloDeLeyendas.dominio.realizarDuelo.RealizadorDuelo
import org.junit.Before
import static org.mockito.Mockito.*
import dueloDeLeyendas.dominio.estadisticas.Estadisticas

class JugadorDueloTestCase {
	var Jugador jugador
	var Jugador jugador1
	var SistemaDeDuelos sistema
	var Personaje personaje
	var Personaje personaje1
	var RealizadorDuelo realizador
	var Estadisticas estadistica
	var Estadisticas estadistica1
	
	@Before def void setUp(){
		jugador = new Jugador ("ElMagoDe_W0Z", sistema)
		jugador1 = new Jugador ("B-MOr", sistema)
		sistema = new SistemaDeDuelos(realizador)
		realizador = mock (typeof(RealizadorDuelo))
		personaje= mock (typeof(Personaje))
		personaje1 = mock (typeof(Personaje))
		estadistica = mock (typeof(Estadisticas))
		estadistica1 = mock (typeof(Estadisticas))
		when(estadistica.jugador).thenReturn(jugador)
		when(estadistica.personaje).thenReturn(personaje)
		when(estadistica.cantDuelosGanados).thenReturn(20)
		when(estadistica1.jugador).thenReturn(jugador1)
		when(estadistica1.personaje).thenReturn(personaje1)
		when(estadistica1.cantDuelosGanados).thenReturn(25)
		
	}
}