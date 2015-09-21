package dueloDeLeyendas.dominio.personaje.test

import static org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.util.List
import java.util.ArrayList
import dueloDeLeyendas.dominio.personaje.Personaje

/* Teste la funcionalidad de la clase Personaje */
class PersonajeTestCase {
	
	var Personaje vipper
	
	@Before def void setUp(){
		val List<String> esp = new ArrayList()
		val List<String> deb = new ArrayList()
		vipper = new Personaje ("Vipper", esp, deb, "JUNGLE")
	}
	
	@Test def void testAgregarEspecialidad(){
		vipper.agregarEspecialidad("Espada")
		val especialidades = vipper.especialidades
		
		assertEquals(especialidades.size(), 1)
		assertTrue(especialidades.contains("Espada"))
	}
	
	@Test def void testAgregarDebilidad(){
		vipper.agregarEspecialidad("Ataque frontal")
		val especialidades = vipper.especialidades
		
		assertEquals(especialidades.size(), 1)
		assertTrue(especialidades.contains("Ataque frontal"))
	}
	
	@Test def void testSetClasificacionNOOB() {
		vipper.setClasificacion(11)
		val String clasificacionVipper = vipper.getClasificacion
		assertEquals (clasificacionVipper, "NOOB")
	}
	
	@Test def void testSetClasificacionMANCO() {
		vipper.setClasificacion(15)
		val String clasificacionVipper = vipper.getClasificacion
		assertEquals (clasificacionVipper, "MANCO")
	}
	
	@Test def void testSetClasificacionKILLINGSPREAD() {
		vipper.setClasificacion(74)
		val String clasificacionVipper = vipper.getClasificacion
		assertEquals (clasificacionVipper, "KILLING-SPREAD")
	}
	
	@Test def void testSetClasificacionDOMINADOR() {
		vipper.setClasificacion(76)
		val String clasificacionVipper = vipper.getClasificacion
		assertEquals (clasificacionVipper, "DOMINADOR")
	}
	
	@Test def void testSetClasificacionRAMPAGE() {
		vipper.setClasificacion(100)
		val String clasificacionVipper = vipper.getClasificacion
		assertEquals (clasificacionVipper, "RAMPAGE")
	}
	
}