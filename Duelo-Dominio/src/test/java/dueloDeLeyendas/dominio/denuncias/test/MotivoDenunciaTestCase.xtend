package dueloDeLeyendas.dominio.denuncias.test

import org.junit.Before
import org.junit.Test
import static org.junit.Assert.*
import static org.mockito.Mockito.*
import dueloDeLeyendas.dominio.denuncias.MotivoDenuncia
import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.denuncias.AbusoHabilidad
import dueloDeLeyendas.dominio.denuncias.ComunicacionAbusiva
import dueloDeLeyendas.dominio.denuncias.AbusoDelSistemaDeDenuncias

class MotivoDenunciaTestCase {
	package MotivoDenuncia motivoAbusoHabilidad
	package MotivoDenuncia motivoComunicacionAbusiva
	package MotivoDenuncia motivoAbusoSistema
	package Jugador mock1
	package Jugador mock2

	@Before def void setUp() throws Exception {
		motivoAbusoHabilidad = new AbusoHabilidad()
		motivoComunicacionAbusiva = new ComunicacionAbusiva()
		motivoAbusoSistema = new AbusoDelSistemaDeDenuncias()
		mock1 = mock(typeof(Jugador))
		mock2 = mock(typeof(Jugador))
	}

	/** 
	 * Este test prueba el metodo aQuienCastigo
	 */
	@Test def void testAQuienCastigoComunicacionAbusiva() {
		assertEquals(motivoComunicacionAbusiva.aQuienCastigo(mock1, mock2), mock1)
	}

	/** 
	 * Este test prueba el metodo aQuienCastigo
	 */
	@Test def void testAQuienCastigoAbusoSistemaDeDenuncias() {
		assertEquals(motivoAbusoSistema.aQuienCastigo(mock1, mock2), mock2)
	}

}
