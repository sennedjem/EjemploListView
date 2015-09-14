package dueloDeLeyendas.dominio.denuncias.test


import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*
import static org.mockito.Mockito.*
import dueloDeLeyendas.dominio.denuncias.Denuncia
import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.denuncias.MotivoDenuncia
import dueloDeLeyendas.dominio.denuncias.FeedIntencional
import dueloDeLeyendas.dominio.denuncias.AbusoHabilidad
import dueloDeLeyendas.dominio.denuncias.AbusoDelSistemaDeDenuncias

class denunciaTestCase {
	package Denuncia denFalsa
	package Denuncia denVerdadera
	package Jugador denunciante
	package Jugador denunciado
	package MotivoDenuncia motivo

	@Before def void setUp() {
		denunciante = mock(typeof(Jugador))
		denunciado = mock(typeof(Jugador))
		motivo = new FeedIntencional()
		denFalsa = new Denuncia(denunciante, denunciado)
		denVerdadera = new Denuncia(denunciante, denunciado)
		denFalsa = spy(denFalsa)
		denVerdadera = spy(denVerdadera)
	}

	/** 
	 * Este test prueba el metodo esValida
	 */
	@Test def void testEsValida() {
		denFalsa.justificacion = "hola chau"
		assertFalse(denFalsa.esValida())
		denFalsa.setJustificacion("lo denuncio porque se dejo matar mas de 10 veces")
		assertTrue(denFalsa.esValida())
	}

	/** 
	 * Este test prueba el metodo realizarPenalizacion
	 */
	@Test def void testRealizarPenalizacionConDenunciaFalsa() {
		denFalsa.motivo = new AbusoDelSistemaDeDenuncias
		denFalsa.realizarPenalizacion()
		verify(denFalsa).castigarJugador(denunciante)
	}

	/** 
	 * Este test prueba el metodo realizarPenalizacion
	 */
	@Test def void testRealizarPenalizacionConDenunciaVerdadera() {
		denVerdadera.motivo = new AbusoHabilidad
		denVerdadera.realizarPenalizacion()
		verify(denVerdadera).castigarJugador(denunciado)
	}

	/** 
	 * Este test prueba el metodo castigarJugador
	 */
	@Test def void testCastigarJugador() {
		denVerdadera.motivo = new FeedIntencional
		denVerdadera.castigarJugador(denunciado)
		verify(denunciado).sumaleATuPesoDeDenuncia(10)
	}

}
