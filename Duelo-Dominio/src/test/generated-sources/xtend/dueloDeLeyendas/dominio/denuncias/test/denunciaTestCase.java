package dueloDeLeyendas.dominio.denuncias.test;

import dueloDeLeyendas.dominio.denuncias.AbusoDelSistemaDeDenuncias;
import dueloDeLeyendas.dominio.denuncias.Denuncia;
import dueloDeLeyendas.dominio.denuncias.FeedIntencional;
import dueloDeLeyendas.dominio.denuncias.MotivoDenuncia;
import dueloDeLeyendas.dominio.jugador.Jugador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

@SuppressWarnings("all")
public class denunciaTestCase {
  private Denuncia denFalsa;
  
  private Denuncia denVerdadera;
  
  private Jugador denunciante;
  
  private Jugador denunciado;
  
  private MotivoDenuncia motivo;
  
  private MotivoDenuncia abusoDeSistema;
  
  @Before
  public void setUp() {
    Jugador _mock = Mockito.<Jugador>mock(Jugador.class);
    this.denunciante = _mock;
    Jugador _mock_1 = Mockito.<Jugador>mock(Jugador.class);
    this.denunciado = _mock_1;
    FeedIntencional _feedIntencional = new FeedIntencional();
    this.motivo = _feedIntencional;
    AbusoDelSistemaDeDenuncias _abusoDelSistemaDeDenuncias = new AbusoDelSistemaDeDenuncias();
    this.abusoDeSistema = _abusoDelSistemaDeDenuncias;
    Denuncia _denuncia = new Denuncia(this.denunciante, this.denunciado);
    this.denFalsa = _denuncia;
    Denuncia _denuncia_1 = new Denuncia(this.denunciante, this.denunciado);
    this.denVerdadera = _denuncia_1;
    Denuncia _spy = Mockito.<Denuncia>spy(this.denFalsa);
    this.denFalsa = _spy;
    Denuncia _spy_1 = Mockito.<Denuncia>spy(this.denVerdadera);
    this.denVerdadera = _spy_1;
  }
  
  /**
   * Este test prueba el metodo esValida
   */
  @Test
  public void testEsValida() {
    this.denFalsa.setJustificacion("lo denuncio porque se dejo matar mas de 10 veces");
    boolean _esValida = this.denFalsa.esValida();
    Assert.assertTrue(_esValida);
  }
  
  /**
   * Este test prueba el metodo realizarPenalizacion
   */
  @Test
  public void testRealizarPenalizacionConDenunciaFalsa() {
    this.denFalsa.setMotivo(this.abusoDeSistema);
    this.denFalsa.realizarPenalizacion();
    Denuncia _verify = Mockito.<Denuncia>verify(this.denFalsa);
    _verify.castigarJugador(this.denunciante);
  }
  
  /**
   * Este test prueba el metodo realizarPenalizacion
   */
  @Test
  public void testRealizarPenalizacionConDenunciaVerdadera() {
    this.denVerdadera.setMotivo(this.motivo);
    this.denVerdadera.realizarPenalizacion();
    Denuncia _verify = Mockito.<Denuncia>verify(this.denVerdadera);
    _verify.castigarJugador(this.denunciado);
  }
  
  /**
   * Este test prueba el metodo castigarJugador
   */
  @Test
  public void testCastigarJugador() {
    this.denVerdadera.setMotivo(this.motivo);
    this.denVerdadera.castigarJugador(this.denunciado);
    Jugador _verify = Mockito.<Jugador>verify(this.denunciado);
    _verify.sumaleATuPesoDeDenuncia(Integer.valueOf(10));
  }
}
