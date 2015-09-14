package dueloDeLeyendas.dominio.denuncias.test;

import dueloDeLeyendas.dominio.denuncias.Denuncia;
import dueloDeLeyendas.dominio.denuncias.MotivoDenuncia;
import dueloDeLeyendas.dominio.jugador.Jugador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

@SuppressWarnings("all")
public class denunciaTestCase {
  Denuncia denFalsa;
  
  Denuncia denVerdadera;
  
  Jugador denunciante;
  
  Jugador denunciado;
  
  MotivoDenuncia motivo;
  
  @Before
  public void setUp() {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The constructor Denuncia(Jugador, Jugador) is not applicable for the arguments (String,Jugador,Jugador,MotivoDenuncia)"
      + "\nInvalid number of arguments. The constructor Denuncia(Jugador, Jugador) is not applicable for the arguments (String,Jugador,Jugador,MotivoDenuncia)"
      + "\nType mismatch: cannot convert from String to Jugador"
      + "\nType mismatch: cannot convert from String to Jugador");
  }
  
  /**
   * Este test prueba el metodo esValida
   */
  @Test
  public void testEsValida() {
    boolean _esValida = this.denFalsa.esValida();
    Assert.assertFalse(_esValida);
    this.denFalsa.setJustificacion("lo denuncio porque se dejo matar mas de 10 veces");
    boolean _esValida_1 = this.denFalsa.esValida();
    Assert.assertTrue(_esValida_1);
  }
  
  /**
   * Este test prueba el metodo realizarPenalizacion
   */
  @Test
  public void testRealizarPenalizacionConDenunciaFalsa() {
    this.denFalsa.realizarPenalizacion();
    Denuncia _verify = Mockito.<Denuncia>verify(this.denFalsa);
    _verify.castigarJugador(this.denunciante);
  }
  
  /**
   * Este test prueba el metodo realizarPenalizacion
   */
  @Test
  public void testRealizarPenalizacionConDenunciaVerdadera() {
    this.denVerdadera.realizarPenalizacion();
    Denuncia _verify = Mockito.<Denuncia>verify(this.denVerdadera);
    _verify.castigarJugador(this.denunciado);
  }
  
  /**
   * Este test prueba el metodo castigarJugador
   */
  @Test
  public void testCastigarJugador() {
    this.denVerdadera.castigarJugador(this.denunciado);
    Jugador _verify = Mockito.<Jugador>verify(this.denunciado);
    _verify.sumaleATuPesoDeDenuncia(Integer.valueOf(10));
  }
}
