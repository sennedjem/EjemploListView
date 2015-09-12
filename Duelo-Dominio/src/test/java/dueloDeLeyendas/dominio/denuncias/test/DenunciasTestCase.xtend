package dueloDeLeyendas.dominio.denuncias.test


import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*
import static org.mockito.Mockito.*
import dueloDeLeyendas.dominio.denuncias.Denuncia
import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.denuncias.MotivoDenuncia
import dueloDeLeyendas.dominio.denuncias.FeedIntencional

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
		denFalsa = new Denuncia("hola chau", denunciante, denunciado, motivo)
		denVerdadera = new Denuncia("se dejo matar mas de 10 veces no lo soporto mas", denunciante, denunciado, motivo)
		denFalsa = spy(denFalsa)
		denVerdadera = spy(denVerdadera)
	}

	/** 
	 * Este test prueba el metodo esValida
	 */
	@Test def void testEsValida() {
		assertFalse(denFalsa.esValida())
		denFalsa.setJustificacion("lo denuncio porque se dejo matar mas de 10 veces")
		assertTrue(denFalsa.esValida())
	}

	/** 
	 * Este test prueba el metodo realizarPenalizacion
	 */
	@Test def void testRealizarPenalizacionConDenunciaFalsa() {
		denFalsa.realizarPenalizacion()
		verify(denFalsa).castigarJugador(denunciante)
	}

	/** 
	 * Este test prueba el metodo realizarPenalizacion
	 */
	@Test def void testRealizarPenalizacionConDenunciaVerdadera() {
		denVerdadera.realizarPenalizacion()
		verify(denVerdadera).castigarJugador(denunciado)
	}

	/** 
	 * Este test prueba el metodo castigarJugador
	 */
	@Test def void testCastigarJugador() {
		denVerdadera.castigarJugador(denunciado)
		verify(denunciado).sumaleATuPesoDeDenuncia(10)
	}

}
