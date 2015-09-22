package dueloDeLeyendas.dominio.estadisticas.test

import static org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import static org.mockito.Mockito.*
import java.util.Set
import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.estadisticas.Estadisticas
import dueloDeLeyendas.dominio.personaje.Personaje
import java.util.ArrayList
import java.util.List

/*
 * Esta clase se encarga de testear la funcionalidad de la clase Estadisticas
 */
class EstadisticasTestCase {
	var Personaje pers
	var Jugador jug
	var Estadisticas est
	
	@Before def void setUp(){
		pers = mock(Personaje)
		jug = mock(Jugador)
		est = new Estadisticas (pers, jug)
	}
	
	@Test def void testSumarIniciado(){
		est.sumarIniciado
		val Integer iniciados = est.getCantDuelosIniciados
		
		assertEquals (iniciados, 1)
	}
	
	@Test def void testSumarGanado(){
		est.sumarGanado
		val Integer ganados = est.getCantDuelosGanados
		
		assertEquals (ganados, 1)
	}
	
	@Test def void testSumarKill(){
		est.sumarKill
		val Integer kills = est.getCantKills()
		
		assertEquals (kills, 1)
	}
	
	@Test def void testSumarDead(){
		est.sumarDead
		val Integer deads = est.getCantDeads
		
		assertEquals (deads, 1)
	}
	
	@Test def void testSumarAssist(){
		est.sumarAssist
		val Integer assists = est.getAssists
		
		assertEquals (assists, 1)
	}
	
	@Test def void testAgregarUbicacionSinRepetidos(){
		est.agregarUbicacion("TOP")
		val List<String> ubicaciones = est.getUbicacionesUsadas
		
		assertTrue (ubicaciones.contains("TOP"))		
	}
	
	@Test def void testAgregarUbicacionConRepetidos(){
		est.agregarUbicacion("MID")
		var List<String> ubicaciones = est.getUbicacionesUsadas
		
		assertTrue (ubicaciones.contains("MID"))
		assertEquals (ubicaciones.size, 1)
		
		est.agregarUbicacion("MID")
		
		assertTrue (ubicaciones.contains("MID"))
		assertEquals (ubicaciones.size,1)
	}
}