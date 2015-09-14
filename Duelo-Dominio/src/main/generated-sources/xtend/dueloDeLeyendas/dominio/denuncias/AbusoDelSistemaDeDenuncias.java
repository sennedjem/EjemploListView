package dueloDeLeyendas.dominio.denuncias;

import dueloDeLeyendas.dominio.denuncias.MotivoDenuncia;
import dueloDeLeyendas.dominio.jugador.Jugador;

@SuppressWarnings("all")
public class AbusoDelSistemaDeDenuncias extends MotivoDenuncia {
  public AbusoDelSistemaDeDenuncias() {
    super(Integer.valueOf(25));
  }
  
  public Jugador aQuienCastigo(final Jugador denunciado, final Jugador denunciante) {
    return denunciante;
  }
}
