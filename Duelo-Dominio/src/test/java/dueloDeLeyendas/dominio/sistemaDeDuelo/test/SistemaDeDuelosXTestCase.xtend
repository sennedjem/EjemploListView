package dueloDeLeyendas.dominio.sistemaDeDuelo.test

import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos
import dueloDeLeyendas.dominio.jugador.Jugador
import static org.mockito.Mockito.*
import org.junit.Before
import org.junit.Test
import dueloDeLeyendas.dominio.personaje.Personaje
import dueloDeLeyendas.dominio.estadisticas.Estadisticas

class SistemaDeDuelosXTestCase {
	Jugador jugador
	SistemaDeDuelos sistema
	Personaje personaje
	Estadisticas esta
	
	@Before def void setUp() {
		sistema = mock(typeof(SistemaDeDuelos))
		personaje = mock(typeof(Personaje))
		jugador = new Jugador ("Tard1s007", sistema)
		esta= new Estadisticas(personaje, jugador)
		jugador.agregarPersonaje(personaje)
	}
	
	
	//No tocar. Atte, Ines
	@Test def void testJugadorMrX(){
		sistema.encontrarRivalAcorde(jugador, personaje)
		verify(sistema).generarJugadorMrX(jugador, personaje)
	}
}