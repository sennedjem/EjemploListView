package dueloDeLeyendas.dominio.realizarDuelo.test

import org.junit.Before
import org.junit.Test
import static org.mockito.Mockito.*
import dueloDeLeyendas.dominio.duelo.RealizadorDuelo
import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.personaje.Personaje
import dueloDeLeyendas.dominio.estadisticas.Estadisticas

class RealizadorDueloTestCase {
	package RealizadorDuelo rd
	package Jugador retadorMock
	package Jugador rivalMock
	package Personaje pRetMock
	package Personaje pRivMock
	package Estadisticas estPRetMock
	package Estadisticas estPRivMock

	@Before def void setUp() throws Exception {
		retadorMock = mock(Jugador)
		rivalMock = mock(Jugador)
		
		pRetMock = mock(Personaje)
		pRivMock = mock(Personaje)
		
		estPRetMock = mock(Estadisticas)
		estPRivMock = mock(Estadisticas)
		rd = new RealizadorDuelo //"MID", retadorMock, rivalMock, pRetMock, pRivMock) 
		// setUp Estadisticas del jugador retador mock
		when(retadorMock.getEstadisticas(pRetMock)).thenReturn(estPRetMock)
		when(estPRetMock.poderDeAtaque).thenReturn(45.0)
		// setUp Estadisticas del jugador rival mock
		when(rivalMock.getEstadisticas(pRivMock)).thenReturn(estPRivMock)
		when(estPRivMock.poderDeAtaque).thenReturn(40.0)
	}

	/** 
	 * Este test prueba que al realizar un duelo los resultados son los esperados
	 */
	@Test def void testRealizarDuelo() {
		rd.realizarDuelo("MID", retadorMock, rivalMock, pRetMock, pRivMock)
		verify(retadorMock).ganeSumarAEstadisticas(retadorMock, pRetMock, "MID", 45.0)
		verify(rivalMock).perdiSumarAEstadisticas(retadorMock, pRivMock, "MID",45.0)
	}

	/** 
	 * Este test prueba que al realizar un duelo los resultados son los esperados
	 */
	@Test def void testRealizarDueloQueGanaElRival() {
		when(estPRivMock.poderDeAtaque).thenReturn(50.0)
		rd.realizarDuelo("MID", retadorMock, rivalMock, pRetMock, pRivMock)
		verify(retadorMock).perdiSumarAEstadisticas(retadorMock, pRetMock,"MID", 45.0)
		verify(rivalMock).ganeSumarAEstadisticas(retadorMock, pRivMock, "MID",45.0)
	}
	
	/** 
	 * Este test prueba que al realizar un duelo los resultados son los esperados
	 */
	@Test def void testRealizarDueloQueEmpatan() {
		when(estPRivMock.poderDeAtaque).thenReturn(45.0)
		rd.realizarDuelo("MID", retadorMock, rivalMock, pRetMock, pRivMock)
		verify(retadorMock).empateSumarAEstadisticas(retadorMock, pRetMock, "MID", 45.0)
		verify(rivalMock).empateSumarAEstadisticas(retadorMock, pRivMock,"MID",45.0)
	}

}
