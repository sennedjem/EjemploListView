package dueloDeLeyendas.dominio.jugador.test

import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos
import org.junit.Before
import dueloDeLeyendas.dominio.personaje.Personaje
import dueloDeLeyendas.dominio.estadisticas.Estadisticas
import static org.mockito.Mockito.*

class JugadorTestCase {
	
	var Jugador jugador
	var SistemaDeDuelos sistema
	var Personaje personje
	var Personaje personje1
	var Estadisticas estadistica
	
	@Before def void setUp(){
		sistema = mock(typeof(SistemaDeDuelos))
		jugador = new Jugador("WOPR", sistema)
		personje = mock(typeof(Personaje))
		personje1 = mock (typeof(Personaje))
		estadistica = new Estadisticas (personje, jugador)
		jugador.agregarPersonaje(personje)
		
	}
}