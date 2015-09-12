package dueloDeLeyendas.dominio.personaje.test

import static org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.util.List
import java.util.ArrayList
import dueloDeLeyendas.dominio.personaje.Personaje

/*
 * Esta clase se encarga de testear la funcionalidad de la clase Personaje
 */
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
	
	@Test def void testSetClasificacion() {
		vipper.setClasificacion(30)
		val String clasificacionVipper = vipper.getClasificacion
		
		assertEquals (clasificacionVipper, "SHAME-ON-YOU")
	}
}