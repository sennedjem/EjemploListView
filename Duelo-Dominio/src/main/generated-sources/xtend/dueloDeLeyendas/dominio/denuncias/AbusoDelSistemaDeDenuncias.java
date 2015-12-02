package dueloDeLeyendas.dominio.denuncias;

import dueloDeLeyendas.dominio.denuncias.MotivoDenuncia;
import dueloDeLeyendas.dominio.jugador.Jugador;

@SuppressWarnings("all")
public class AbusoDelSistemaDeDenuncias extends MotivoDenuncia {
  /**
   * Crea una denuncia al denunciante si no se puede validar la misma
   */
  public AbusoDelSistemaDeDenuncias() {
    super(Integer.valueOf(25));
  }
  
  /**
   * Retorna el jugador denunciado, en este caso es el denunciante
   */
  public Jugador aQuienCastigo(final Jugador denunciado, final Jugador denunciante) {
    return denunciante;
  }
}
