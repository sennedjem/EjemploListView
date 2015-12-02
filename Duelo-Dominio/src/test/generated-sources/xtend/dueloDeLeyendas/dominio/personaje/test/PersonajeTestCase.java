package dueloDeLeyendas.dominio.personaje.test;

import dueloDeLeyendas.dominio.personaje.Personaje;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Teste la funcionalidad de la clase Personaje
 */
@SuppressWarnings("all")
public class PersonajeTestCase {
  private Personaje vipper;
  
  @Before
  public void setUp() {
    final List<String> esp = new ArrayList<String>();
    final List<String> deb = new ArrayList<String>();
    Personaje _personaje = new Personaje("Vipper", esp, deb, "JUNGLE");
    this.vipper = _personaje;
  }
  
  @Test
  public void testAgregarEspecialidad() {
    this.vipper.agregarEspecialidad("Espada");
    final List<String> especialidades = this.vipper.getEspecialidades();
    int _size = especialidades.size();
    Assert.assertEquals(_size, 1);
    boolean _contains = especialidades.contains("Espada");
    Assert.assertTrue(_contains);
  }
  
  @Test
  public void testAgregarDebilidad() {
    this.vipper.agregarEspecialidad("Ataque frontal");
    final List<String> especialidades = this.vipper.getEspecialidades();
    int _size = especialidades.size();
    Assert.assertEquals(_size, 1);
    boolean _contains = especialidades.contains("Ataque frontal");
    Assert.assertTrue(_contains);
  }
  
  @Test
  public void testSetClasificacionNOOB() {
    this.vipper.setClasificacion(Integer.valueOf(11));
    final String clasificacionVipper = this.vipper.getClasificacion();
    Assert.assertEquals(clasificacionVipper, "NOOB");
  }
  
  @Test
  public void testSetClasificacionMANCO() {
    this.vipper.setClasificacion(Integer.valueOf(15));
    final String clasificacionVipper = this.vipper.getClasificacion();
    Assert.assertEquals(clasificacionVipper, "MANCO");
  }
  
  @Test
  public void testSetClasificacionKILLINGSPREAD() {
    this.vipper.setClasificacion(Integer.valueOf(74));
    final String clasificacionVipper = this.vipper.getClasificacion();
    Assert.assertEquals(clasificacionVipper, "KILLING-SPREAD");
  }
  
  @Test
  public void testSetClasificacionDOMINADOR() {
    this.vipper.setClasificacion(Integer.valueOf(76));
    final String clasificacionVipper = this.vipper.getClasificacion();
    Assert.assertEquals(clasificacionVipper, "DOMINADOR");
  }
  
  @Test
  public void testSetClasificacionRAMPAGE() {
    this.vipper.setClasificacion(Integer.valueOf(100));
    final String clasificacionVipper = this.vipper.getClasificacion();
    Assert.assertEquals(clasificacionVipper, "RAMPAGE");
  }
}
