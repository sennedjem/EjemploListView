package dueloDeLeyendas.dominio.denuncias.test;

import dueloDeLeyendas.dominio.denuncias.AbusoDelSistemaDeDenuncias;
import dueloDeLeyendas.dominio.denuncias.AbusoHabilidad;
import dueloDeLeyendas.dominio.denuncias.ComunicacionAbusiva;
import dueloDeLeyendas.dominio.denuncias.MotivoDenuncia;
import dueloDeLeyendas.dominio.jugador.Jugador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

@SuppressWarnings("all")
public class MotivoDenunciaTestCase {
  MotivoDenuncia motivoAbusoHabilidad;
  
  MotivoDenuncia motivoComunicacionAbusiva;
  
  MotivoDenuncia motivoAbusoSistema;
  
  Jugador mock1;
  
  Jugador mock2;
  
  @Before
  public void setUp() throws Exception {
    AbusoHabilidad _abusoHabilidad = new AbusoHabilidad();
    this.motivoAbusoHabilidad = _abusoHabilidad;
    ComunicacionAbusiva _comunicacionAbusiva = new ComunicacionAbusiva();
    this.motivoComunicacionAbusiva = _comunicacionAbusiva;
    AbusoDelSistemaDeDenuncias _abusoDelSistemaDeDenuncias = new AbusoDelSistemaDeDenuncias();
    this.motivoAbusoSistema = _abusoDelSistemaDeDenuncias;
    Jugador _mock = Mockito.<Jugador>mock(Jugador.class);
    this.mock1 = _mock;
    Jugador _mock_1 = Mockito.<Jugador>mock(Jugador.class);
    this.mock2 = _mock_1;
  }
  
  /**
   * Este test prueba el metodo aQuienCastigo
   */
  @Test
  public void testAQuienCastigoComunicacionAbusiva() {
    Jugador _aQuienCastigo = this.motivoComunicacionAbusiva.aQuienCastigo(this.mock1, this.mock2);
    Assert.assertEquals(_aQuienCastigo, this.mock1);
  }
  
  /**
   * Este test prueba el metodo aQuienCastigo
   */
  @Test
  public void testAQuienCastigoAbusoSistemaDeDenuncias() {
    Jugador _aQuienCastigo = this.motivoAbusoSistema.aQuienCastigo(this.mock1, this.mock2);
    Assert.assertEquals(_aQuienCastigo, this.mock2);
  }
}
